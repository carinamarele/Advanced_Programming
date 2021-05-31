package cards;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import model.GameModel;
import model.GameModelListener;

public class DeckView extends HBox implements GameModelListener {

    private static final String BUTTON_STYLE_NORMAL="-fx-background-color: transparent; -fx-padding: 6,6,6,6;";
    private static final String BUTTON_STYLE_PRESSED="-fx-background-color: transparent; -fx-padding: 9,7,7,9;";
        private static final int IMAGE_FONT_SIZE = 65;//font scris

        public DeckView()
        {
            final Button button = new Button();
            button.setGraphic(new ImageView(CardImages.getBack()));
            button.setStyle(BUTTON_STYLE_NORMAL);

            button.setOnMousePressed(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent pEvent)
                {
                    ((Button)pEvent.getSource()).setStyle(BUTTON_STYLE_PRESSED);
                }
            });

            button.setOnMouseReleased(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent pEvent)
                {
                    ((Button)pEvent.getSource()).setStyle(BUTTON_STYLE_NORMAL);
                    if( GameModel.instance().isDeckEmpty() )
                    {
                        //if there is not any card left in the deck, then we'll create a new instance of the game and reset the game
                        GameModel.instance().reset();
                    }
                    else
                    {
                        //if not, then we'll continue playing
                        GameModel.instance().getDiscardMove().executeMove();
                    }
                }
            });

            getChildren().add(button);
            GameModel.instance().addListener(this);
        }
        //if the deck is null then it will apear an image with the option of giving up and starting again
        public Canvas createNewGameImage()
        {
            double width = CardImages.getBack().getWidth();
            double height = CardImages.getBack().getHeight();
            Canvas canvas = new Canvas( width, height );
            GraphicsContext context = canvas.getGraphicsContext2D();
            Image fail=new Image("tryagain.png");
            Image succes=new Image("won.png");


            if( GameModel.instance().isCompleted() )
            {
                context.drawImage(succes,width/4-IMAGE_FONT_SIZE/2, height/2-width/4 -IMAGE_FONT_SIZE/2, width/2+IMAGE_FONT_SIZE, width/2+ IMAGE_FONT_SIZE);
            }else{
                context.drawImage(fail,width/4-IMAGE_FONT_SIZE/2, height/2-width/4 -IMAGE_FONT_SIZE/2, width/2+IMAGE_FONT_SIZE, width/2+ IMAGE_FONT_SIZE);
            }

            return canvas;
        }

        @Override
        public void gameStateChanged()
        {
            if( GameModel.instance().isDeckEmpty() )
            {
                //either we show the choice of giving up
                ((Button)getChildren().get(0)).setGraphic(createNewGameImage());
            }
            else
            {
                //either we show what card is left in the stack
                ((Button)getChildren().get(0)).setGraphic(new ImageView(CardImages.getBack()));
            }
        }

        public void reset()
        {
            getChildren().get(0).setVisible(true);
        }
    }