package model;

import cards.Card;
import cards.CardStack;
import cards.Rank;
import cards.Suit;
import gui.Deck;
import move.Location;
import move.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public final class GameModel implements GameModelView
{
    private static final GameModel INSTANCE = new GameModel();

    private static final Move NULL_MOVE = new Move()
    {
        @Override
        public void executeMove()
        {} // Does nothing on purpose

        @Override
        public boolean isNull()
        { return true; }

        @Override
        public void undo()
        {} // Does nothing on purpose
    };

    private final Move aDiscardMove = new Move()
    {
        @Override
        public void executeMove()
        {
            aDiscard.push(aDeck.draw());
            aMoves.push(this);
            notifyListeners();
        }

        @Override
        public void undo()
        {
            aDeck.push(aDiscard.pop());
            notifyListeners();
        }
    };

    private final Deck aDeck = new Deck();
    private final Stack<Move> aMoves = new Stack<>();
    private final CardStack aDiscard = new CardStack();
    private final FinalePileStack aFinalePileStack = new FinalePileStack();
    private final StackDownGame aStackDownGame = new StackDownGame();
    private final List<GameModelListener> aListeners = new ArrayList<>();

    private GameModel()
    {
        reset();
    }

    /**
     * @return The number of cards in the space for the final stack which will contain 52 cards if the game is won.
     */
    public int getScore()
    {
        return aFinalePileStack.getTotalSize();
    }



    /**
     * @return The singleton instance for this class.
     */
    public static GameModel instance()
    {
        return INSTANCE;
    }

    	/**
	 * Registers an observer for the state of the game model.
	 * @param pListener A listener to register.
	 * @pre pListener != null
	 */
    public void addListener(GameModelListener pListener)
    {
        aListeners.add(pListener);
    }

    private void notifyListeners()
    {
        for( GameModelListener listener : aListeners )
        {
            listener.gameStateChanged();
        }
    }

    /**
     * Restores the model to the state corresponding to the start of a new game.
     */
    public void reset()
    {
        aMoves.clear();
        aDeck.shuffle();
        aDiscard.clear();
        aFinalePileStack.initialize();
        aStackDownGame.initialize(aDeck);
        notifyListeners();
    }

    /**
     * @return True if the game is completed.
     */
    public boolean isCompleted()
    {
        return aFinalePileStack.getTotalSize() == Rank.values().length * Suit.values().length;
    }


    @Override
    public boolean isDeckEmpty()
    {
        return aDeck.isEmpty();
    }


    @Override
    public boolean isDiscardPileEmpty()
    {
        return aDiscard.isEmpty();
    }

    @Override
    public boolean isFinalePileStackEmpty(FinaleStackOrder pPile)
    {
        return aFinalePileStack.isEmpty(pPile);
    }

    /**
     * Obtain the card on top of the stack pile pPile in the final space for all cards
     * without removing it.
     * @param pPile The pile to check.
     * @return The card on top of the pile.
     */
    public Card peekSuitStack(FinaleStackOrder pPile)
    {
        return aFinalePileStack.peek(pPile);
    }

    @Override
    public Card peekDiscardPile()
    {
        return aDiscard.peek();
    }


    /**
     * @param pCard A card to locate
     * @return The game location where this card currently is.
     * @pre the card is in a location where it can be found and moved.
     */
    private Location find(Card pCard)
    {
        if( !aDiscard.isEmpty() && aDiscard.peek() == pCard )
        {
            return OtherLocation.DISCARD_PILE;
        }
        for( FinaleStackOrder index : FinaleStackOrder.values() )
        {
            if( !aFinalePileStack.isEmpty(index) && aFinalePileStack.peek(index) == pCard )
            {
                return index;
            }
        }
        for( IndexCardsPile index : IndexCardsPile.values() )
        {
            if( aStackDownGame.contains(pCard, index))
            {
                return index;
            }
        }
        return null;
    }

    /**
     * Undoes the last move.
     */
    public void undoLast()
    {
        if( !aMoves.isEmpty() )
        {
            aMoves.pop().undo();
        }
    }

    /**
     * @return If there is a move to undo.
     */
    public boolean canUndo()
    {
        return !aMoves.isEmpty();
    }

    /**
     * Removes the moveable card from pLocation.
     */
    private void absorbCard(Location pLocation)
    {
        if( pLocation == OtherLocation.DISCARD_PILE )
        {

            aDiscard.pop();
        }
        else if( pLocation instanceof FinaleStackOrder) {
            aFinalePileStack.pop((FinaleStackOrder)pLocation);
        }
        else
        {
            aStackDownGame.pop((IndexCardsPile)pLocation);
        }
    }

    private void move(Card pCard, Location pDestination)
    {
        Location source = find(pCard);
        if( source instanceof IndexCardsPile && pDestination instanceof IndexCardsPile)
        {
            aStackDownGame.moveWithin(pCard, (IndexCardsPile)source, (IndexCardsPile) pDestination);
        }
        else
        {
            absorbCard(source);
            if( pDestination instanceof FinaleStackOrder)
            {
                aFinalePileStack.push(pCard, (FinaleStackOrder)pDestination);
            }
            else if( pDestination == OtherLocation.DISCARD_PILE )
            {
                aDiscard.push(pCard);
            }
            else
            {
                aStackDownGame.push(pCard, (IndexCardsPile)pDestination);
            }
        }
        notifyListeners();
    }

    @Override
    public CardStack getIndexCardsPile(IndexCardsPile pIndex)
    {
        return aStackDownGame.getPile(pIndex);
    }

    @Override
    public boolean isVisibleInStackDownGame(Card pCard)
    {
        return aStackDownGame.contains(pCard) && aStackDownGame.isVisible(pCard);
    }

    @Override
    public boolean isLowestVisibleInStackDownGame(Card pCard)
    {
        return aStackDownGame.contains(pCard) && aStackDownGame.isLowestVisible(pCard);
    }

    /**
     * Get the sequence consisting of pCard and all
     * the other cards below it, from the stacks of cards in the main game.
     * @param pCard The top card of the sequence
     * @param pPile The requested pile
     * @return A non-empty sequence of cards.
     * @pre pCard != null and is in pile pPile
     */
    public CardStack getSubStack(Card pCard, IndexCardsPile pPile)
    {
        return aStackDownGame.getSequence(pCard, pPile);
    }

    @Override
    public boolean isLegalMove(Card pCard, Location pDestination )
    {
        if( pDestination instanceof FinaleStackOrder)
        {
            return aFinalePileStack.canMoveTo(pCard, (FinaleStackOrder) pDestination);
        }
        else if( pDestination instanceof IndexCardsPile)
        {
            return aStackDownGame.canMoveTo(pCard, (IndexCardsPile) pDestination);
        }
        else
        {
            return false;
        }
    }

    @Override
    public Move getNullMove()
    {
        return NULL_MOVE;
    }

    @Override
    public Move getDiscardMove()
    {
        return aDiscardMove;
    }



    @Override
    public Move getCardMove(Card pCard, Location pDestination)
    {
        Location source = find( pCard );
        if( source instanceof IndexCardsPile && aStackDownGame.revealsTop(pCard))
        {
            return new MovementsCards(new CardMove(pCard, pDestination), new RevealTopMove((IndexCardsPile)source) );
        }
        return new CardMove(pCard, pDestination);
    }

    @Override
    public boolean isBottomKing(Card pCard)
    {
        return aStackDownGame.isBottomKing(pCard);
    }


    /**
     * A move that represents the intention to move pCard
     * to pDestination, possibly including all cards stacked
     * on top of pCard if pCard is in a working stack.
     */
    private class CardMove implements Move
    {
        private Card aCard;
        private Location aOrigin;
        private Location aDestination;

        CardMove(Card pCard, Location pDestination)
        {
            aCard = pCard;
            aDestination = pDestination;
            aOrigin = find(pCard);
        }

        @Override
        public void executeMove()
        {
            move(aCard, aDestination);
            aMoves.push(this);
        }

        @Override
        public void undo()
        {
            move(aCard, aOrigin);
        }
    }

    /**
     * reveals the top of the stack.
     *
     */
    private class RevealTopMove implements Move
    {
        private final IndexCardsPile aIndex;

        RevealTopMove(IndexCardsPile pIndex)
        {
            aIndex = pIndex;
        }

        @Override
        public void executeMove()
        {
            aStackDownGame.showTop(aIndex);
            aMoves.push(this);
            notifyListeners();
        }

        @Override
        public void undo()
        {
            aStackDownGame.hideTop(aIndex);
            aMoves.pop().undo();
            notifyListeners();
        }
    }
}
