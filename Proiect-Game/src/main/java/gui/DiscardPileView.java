package gui;


import cards.Card;
import cards.CardImages;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.CardDragHandler;
import model.GameModel;
import model.GameModelListener;

public class DiscardPileView extends HBox implements GameModelListener
{
    private static final int PADDING = 5;
    private CardDragHandler aDragHandler;

    public DiscardPileView()
    {
        setPadding(new Insets(PADDING));
        final ImageView image = new ImageView(CardImages.getBack());
        image.setVisible(false);
        getChildren().add(image);
        aDragHandler = new CardDragHandler(image);
        image.setOnDragDetected(aDragHandler);
        GameModel.instance().addListener(this);
    }

    @Override
    public void gameStateChanged()
    {
        if( GameModel.instance().isDiscardPileEmpty()) //check if there are still any cards let in the main deck
        {
            getChildren().get(0).setVisible(false);//if it's visible then for the next game, the last card in the previous deck will still be visible at the beggining of a new game
        }
        else
        {
            //
            getChildren().get(0).setVisible(true);
            Card topCard = GameModel.instance().peekDiscardPile();
            ImageView image = (ImageView)getChildren().get(0);
            image.setImage(CardImages.getCard(topCard));
            aDragHandler.setCard(topCard);
        }
    }
}