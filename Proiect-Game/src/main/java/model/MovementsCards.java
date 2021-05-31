package model;

import move.Move;

import java.util.ArrayList;
import java.util.List;


public class MovementsCards implements Move
{
    private final List<Move> aMoves = new ArrayList<>();// where the moves of the cards will be saved

    /**
     * @param pMoves Memory every move
     */
    public MovementsCards(Move ... pMoves)
    {
        for( Move move : pMoves )
        {
            aMoves.add(move);
        }
    }

    @Override
    public void executeMove()
    {
        for( Move move : aMoves )
        {
            move.executeMove();
        }
    }

    @Override
    public void undo()
    {
        for( int i = aMoves.size()-1; i >=0; i-- )
        {
            aMoves.get(i).undo();
        }
    }
}
