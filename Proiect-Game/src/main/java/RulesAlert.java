import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class RulesAlert {

    public static void display(){
        Stage window=new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Rules Of Solitaire by MCI");
        window.getIcons().add(new Image("instructions.png"));
        AnchorPane layout=new AnchorPane();
        //Setting background
        BackgroundImage myBI = new BackgroundImage(new Image("background1.jpg", 1000, 750, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));

        //buton de exit din window
        Button exitBtn=new Button("Exit Rules");
        exitBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #fda9a9;"+"-fx-border-color: #98d7a1");
        exitBtn.setLayoutX(750);
        exitBtn.setLayoutY(640);
        exitBtn.setOnAction(e -> window.close() );

        //titlu

        Label title=new Label("Cum se joaca Solitaire?");
        title.setStyle("-fx-font-family: 'Comic Sans MS';-fx-font-size: 30px;-fx-font-style: italic");
        title.setLayoutX(30);
        title.setLayoutY(40);
        layout.getChildren().add(title);

        //Rules
        Label rules=new Label(" ●  Fiecare teanc din casa trebuie sa inceapa cu un as. Daca nu aveti niciunul, va trebui sa mutati \n cartile intre coloane pana cand dezvaluiti unul.\n\n" +" ●  Insa nu este posibil sa mutati cartile intamplator intre coloane. Coloanele trebuie construite \n in ordine ascendenta, de la rege la as. De aceea, se poate pune cartea de 10 pe un valet, dar nu\n pe un 3.\n" +
                "\n ●  Pentru sporirea dificultatii, cartile din coloane trebuie sa alterneze culorile rosu si negru.\n" +
                "\n ●  Nu sunteti limitat doar la mutarea cartilor unice. De asemenea, aveti posibilitatea sa mutati \n intre coloane siruri de carti organizate secvential.\n" +
                "\n ●  Daca nu mai aveti mutari, va trebui sa extrageti mai multe carti, facand clic/extragand din\n  pachetul din coltul din stanga sus. Daca in pachet nu mai este nici o carte, \n faceti clic pe conturul sau de pe tabla pentru a le rearanja/reluati cartile ramase.\n" +
                "\n ●  Aveti posibilitatea sa mutati o carte in teancul de casa glisand-o sau facand dublu clic pe ea.\n" +
                "\n ●  Jocul poate fi intrerupt oricand de catre jucator, atunci cand nu mai poate face nici o \nmutare cu sens.\n");
        rules.setLayoutX(40);
        rules.setLayoutY(110);
        rules.setStyle("-fx-font-family: 'Lucida Sans';-fx-font-size: 20px;");

        layout.getChildren().add(rules);

        layout.getChildren().add(exitBtn);
        Scene scene=new Scene(layout,1000,700);
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();


    }
}
