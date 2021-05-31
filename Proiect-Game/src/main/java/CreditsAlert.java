import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreditsAlert {

    public static void display(){
        Stage window=new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Credits&Author Solitaire");
        window.getIcons().add(new Image("copyright.png"));
        AnchorPane layout=new AnchorPane();
        //Setting background
        BackgroundImage myBI = new BackgroundImage(new Image("background2.jpg", 200, 300, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));

        //buton de exit din window
        Button exitBtn=new Button("Exit Rules");
        exitBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #fda9a9;"+"-fx-border-color: #98d7a1");
        exitBtn.setLayoutX(750);
        exitBtn.setLayoutY(640);
        exitBtn.setOnAction(e -> window.close() );

        //titlu

        Label title=new Label("Credits & Author Solitaire");
        title.setStyle("-fx-font-family: 'Comic Sans MS';-fx-font-size: 30px;-fx-font-style: italic");
        title.setLayoutX(30);
        title.setLayoutY(50);
        layout.getChildren().add(title);

        //Rules
        Label rules=new Label(" All designs are made by Marele Carina-Ioana 2A4 which includes:\n" +
                " ● Cards: back and front\n"+" ● Backgrounds");
        rules.setLayoutX(40);
        rules.setLayoutY(130);
        rules.setStyle("-fx-font-family: 'Comic Sans MS';-fx-font-size: 20px;");

        layout.getChildren().add(rules);

        layout.getChildren().add(exitBtn);
        Scene scene=new Scene(layout,700,300);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();


    }
}
