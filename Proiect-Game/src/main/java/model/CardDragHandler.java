package model;


import cards.Card;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

/**
 * Class for moving every card on the table which contains the card(string) and the image for it
 */
public class CardDragHandler implements EventHandler<MouseEvent>
{
    private static final ClipboardContent CLIPBOARD_CONTENT = new ClipboardContent();

    private Card aCard;
    private ImageView aImageView;

    public CardDragHandler(ImageView pView)
    {
        aImageView = pView;
    }

    public void setCard(Card pCard)
    {
        aCard = pCard;
    }

    @Override
    public void handle(MouseEvent pMouseEvent)
    {
        Dragboard db = aImageView.startDragAndDrop(TransferMode.ANY);
        CLIPBOARD_CONTENT.putString(aCard.getIDString());
        db.setContent(CLIPBOARD_CONTENT);
        pMouseEvent.consume();
    }
}