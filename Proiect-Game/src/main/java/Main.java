import cards.DeckView;
import cards.Suit;
import gui.CardPileView;
import gui.DiscardPileView;
import gui.SuitStack;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.FinaleStackOrder;
import model.GameModel;
import model.IndexCardsPile;

public class Main extends Application {
    private Stage stage;
    private Scene startScene;
    private Scene gameScene;
    private Scene infoScene;
    private DeckView aDeckView = new DeckView();
    private DiscardPileView aDiscardPileView = new DiscardPileView();
    private SuitStack[] aSuitStacks = new SuitStack[Suit.values().length];
    private CardPileView[] aStacks = new CardPileView[IndexCardsPile.values().length];
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;


        startScene = createStartScene(stage);
        gameScene = createGameScene(stage);
        infoScene = createInfoScene(stage);

        stage.setScene(startScene);
        stage.setResizable(false);
        stage.show();
    }

    private Scene createGameScene(Stage primaryStage) {
        Stage window=primaryStage;
        window.setTitle("Solitaire by MCI");
        GridPane layout=new GridPane();
        window.getIcons().add(new Image("solitaire.png"));

        ///////////////////////////////////////////////////////MENU


        //Setting background
        BackgroundImage myBI = new BackgroundImage(new Image("background.png", 1300, 1000, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));

        MenuBar menuBar = new MenuBar();

        //creating submenus and items
        Menu menu1 = new Menu("Game");
        MenuItem menuItem1 = new MenuItem("New Game");
        MenuItem menuItem7 =new MenuItem("Start Menu");
        MenuItem menuItem2 = new MenuItem("Exit");


        menuItem1.setOnAction(e -> {
            GameModel.instance().reset();
            switchScenes(gameScene);
        });
        menuItem2.setOnAction(e -> {
            System.out.println("Game exited");
            primaryStage.close();
            System.exit(1);

        });
        menuItem7.setOnAction( e ->{
            GameModel.instance().reset();
            switchScenes(startScene);});
        menu1.getItems().addAll(menuItem1,menuItem7,menuItem2);

        menuBar.getMenus().add(menu1);
        Menu menu2 = new Menu("About Game");

        MenuItem menuItem3 = new MenuItem("How to play");
        MenuItem menuItem4 = new MenuItem("Credits & Author");

        menuItem3.setOnAction(e -> RulesAlert.display());
        menuItem4.setOnAction(e -> {
            CreditsAlert.display();

        });
        menu2.getItems().add(menuItem3);
        menu2.getItems().add(menuItem4);

        // setting style for menubar
        menuBar.setStyle("-fx-background-color: #d0f6e1;-fx-border-color: #a9ecdb");
        menu1.setStyle("-fx-background-image: url(background.jpg)");
        menuItem1.setStyle("-fx-background-image: url(background.jpg)");
        menuItem2.setStyle("-fx-background-image: url(background.jpg)");
        menu2.setStyle("-fx-background-image: url(background.jpg)");
        menuItem4.setStyle("-fx-background-image: url(background.jpg)");
        menuItem3.setStyle("-fx-background-image: url(background.jpg)");
        menuItem7.setStyle("-fx-background-image: url(background.jpg)");

        menuBar.getMenus().add(menu2);

        layout.add(menuBar,0,0);
        ///////////////////////////////////////////////////////MENU END


        layout.add(aDeckView,0,1);
        layout.add(aDiscardPileView,1,1);

        for( FinaleStackOrder index : FinaleStackOrder.values() )
        {
        	aSuitStacks[index.ordinal()] = new SuitStack(index);
        	layout.add(aSuitStacks[index.ordinal()], 3+index.ordinal(), 1);
        }

        for( IndexCardsPile index : IndexCardsPile.values() )
        {
        	aStacks[index.ordinal()] = new CardPileView(index);
        	layout.add(aStacks[index.ordinal()], index.ordinal(), 2);
        }


        layout.setOnKeyTyped(new EventHandler<KeyEvent>()
        {

            @Override
            public void handle(final KeyEvent pEvent)
            {

                if( pEvent.getCharacter().equals("\b"))
                {
                    GameModel.instance().undoLast();
                }
                pEvent.consume();
            }

        });
        gameScene=new Scene(layout,1300,1000);

        return gameScene;
    }

    private Scene createStartScene(Stage primaryStage) {
        Stage window=primaryStage;
        window.getIcons().add(new Image("solitaire.png"));
        window.setTitle("Welcome to Solitaire by MCI");
        AnchorPane layout = new AnchorPane();

        ///////////////////////////////////////////////////////MENU
        //creating menubar
        MenuBar menuBar = new MenuBar();

        menuBar.prefWidthProperty().bind(window.widthProperty());//setez width ca la parinte

        //Setting background
        BackgroundImage myBI = new BackgroundImage(new Image("background.png", 1300, 1000, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));

        layout.getChildren().add(menuBar);

        //creating submenus and items
        Menu menu1 = new Menu("Game");
        MenuItem menuItem1 = new MenuItem("New Game");
        MenuItem menuItem2 = new MenuItem("Exit");


        menuItem1.setOnAction(
                e -> switchScenes(gameScene));
        menuItem2.setOnAction(e -> {
            System.out.println("Game exited");
            window.close();
            System.exit(1);

        });
        menu1.getItems().add(menuItem1);
        menu1.getItems().add(menuItem2);

        menuBar.getMenus().add(menu1);
        Menu menu2 = new Menu("About Game");

        MenuItem menuItem3 = new MenuItem("How to play");
        MenuItem menuItem4 = new MenuItem("Credits & Author");

        menuItem3.setOnAction(e -> RulesAlert.display());
        menuItem4.setOnAction(e -> {
            CreditsAlert.display();

        });
        menu2.getItems().add(menuItem3);
        menu2.getItems().add(menuItem4);

        // setting style for menubar
        menuBar.setStyle("-fx-background-color: #d0f6e1;-fx-border-color: #a9ecdb");
        menu1.setStyle("-fx-background-image: url(background.jpg)");
        menuItem1.setStyle("-fx-background-image: url(background.jpg)");
        menuItem2.setStyle("-fx-background-image: url(background.jpg)");
        menu2.setStyle("-fx-background-image: url(background.jpg)");
        menuItem4.setStyle("-fx-background-image: url(background.jpg)");
        menuItem3.setStyle("-fx-background-image: url(background.jpg)");

        menuBar.getMenus().add(menu2);
        ///////////////////////////////////////////////////////MENU END

        ////////////////////////////////////////////////////BUTTONS MAIN PAGE
        Button playBtn=new Button("Play New Game");
        Button instrBtn=new Button("About");
        Button exitBtn=new Button("Exit Game");

        playBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #8fe9e0;"+"-fx-border-color: #98d7a1");
        playBtn.setLayoutX(550);
        playBtn.setLayoutY(330);

        playBtn.setOnAction(e ->switchScenes(gameScene));

        layout.getChildren().add(playBtn);

        instrBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #8fe9e0;"+"-fx-border-color: #98d7a1");
        instrBtn.setLayoutX(550);
        instrBtn.setLayoutY(430);

        instrBtn.setOnAction(e ->{
            switchScenes(infoScene);
        });

        layout.getChildren().add(instrBtn);

        exitBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #8fe9e0;"+"-fx-border-color: #98d7a1");
        exitBtn.setLayoutX(550);
        exitBtn.setLayoutY(530);

        exitBtn.setOnAction(e ->{
            System.out.println("Game exited");
            window.close();
            System.exit(1);
        });

        layout.getChildren().add(exitBtn);
        ///////////////////////////////////////////////END BUTTONS MAIN PAGE
        //creating scene
        startScene = new Scene(layout, 1300, 1000); ///adding main page,start
        return startScene;
    }

    private Scene createInfoScene(Stage primaryStage){
       Stage window =primaryStage;
        window.getIcons().add(new Image("instructions.png"));
        AnchorPane layout=new AnchorPane();
        //Setting background
        BackgroundImage myBI = new BackgroundImage(new Image("new.jpg", 1300, 1000, false, true), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));

        MenuBar menuBar = new MenuBar();

        //creating submenus and items
        Menu menu1 = new Menu("Game");
        MenuItem menuItem1 = new MenuItem("New Game");
        MenuItem menuItem7 =new MenuItem("Start Menu");
        MenuItem menuItem2 = new MenuItem("Exit");


        menuItem1.setOnAction(e -> {
            GameModel.instance().reset();
            switchScenes(gameScene);
        });
        menuItem2.setOnAction(e -> {
            System.out.println("Game exited");
            primaryStage.close();
            System.exit(1);

        });
        menuItem7.setOnAction( e ->{
            GameModel.instance().reset();
            switchScenes(startScene);});
        menu1.getItems().addAll(menuItem1,menuItem7,menuItem2);

        menuBar.getMenus().add(menu1);
        Menu menu2 = new Menu("About Game");

        MenuItem menuItem3 = new MenuItem("How to play");
        MenuItem menuItem4 = new MenuItem("Credits & Author");

        menuItem3.setOnAction(e -> RulesAlert.display());
        menuItem4.setOnAction(e -> {
            CreditsAlert.display();

        });
        menu2.getItems().add(menuItem3);
        menu2.getItems().add(menuItem4);

        // setting style for menubar
        menuBar.setStyle("-fx-background-color: #d0f6e1;-fx-border-color: #a9ecdb");
        menu1.setStyle("-fx-background-image: url(background.jpg)");
        menuItem1.setStyle("-fx-background-image: url(background.jpg)");
        menuItem2.setStyle("-fx-background-image: url(background.jpg)");
        menu2.setStyle("-fx-background-image: url(background.jpg)");
        menuItem4.setStyle("-fx-background-image: url(background.jpg)");
        menuItem3.setStyle("-fx-background-image: url(background.jpg)");
        menuItem7.setStyle("-fx-background-image: url(background.jpg)");

        menuBar.getMenus().add(menu2);

        //buton de exit din window
        Button exitBtn=new Button("Exit Rules");
        exitBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #fda9a9;"+"-fx-border-color: #98d7a1");
        exitBtn.setLayoutX(1050);
        exitBtn.setLayoutY(940);
        exitBtn.setOnAction(e -> switchScenes(startScene) );

        Image image=new Image("game.png");
        ImageView imageAdd=new ImageView(image);
        imageAdd.setX(0);
        imageAdd.setY(400);
        imageAdd.setFitWidth(800);
        imageAdd.setFitHeight(600);
        layout.getChildren().add(imageAdd);



        Label title=new Label("Solitaire");
        title.setStyle("-fx-font-family: 'Comic Sans MS';-fx-font-size: 30px;-fx-font-style: italic");
        title.setLayoutX(450);
        title.setLayoutY(65);
        layout.getChildren().add(title);

        Label subtitle=new Label("Game design by Marele Carina-Ioana 2A4");
        subtitle.setStyle("-fx-font-family: 'Comic Sans MS';-fx-font-size: 21px;-fx-font-style: italic");
        subtitle.setLayoutX(570);
        subtitle.setLayoutY(98);
        layout.getChildren().add(subtitle);

        //Rules
        Label rules=new Label("\n      Solitaire este unul dintre cele mai populare jocuri cu carti de computer din lume. Acesta poate fi jucat doar de o singura \n persoana atat la calculator(Windows Solitaire sau joc online de Solitaire), cat si cu un pachet de carti aranjate pe masa.\n" +
                "\n" +
                "      Obiectivul jocului este de a construi patru stive de carti, cate una pentru fiecare suita, in ordine crescatoare, de la as la popa.\n      Reguli:\n" +
                "\n ●  Fiecare teanc din casa trebuie sa inceapa cu un as. Daca nu aveti niciunul, va trebui sa mutati cartile intre coloane pana \n cand dezvaluiti unul.\n\n" +" ●  Insa nu este posibil sa mutati cartile intamplator intre coloane. Coloanele trebuie construite in ordine ascendenta,\n de la rege la as. De aceea, se poate pune cartea de 10 pe un valet, dar nu pe un 3.\n" +
                "\n ●  Pentru sporirea dificultatii, cartile din coloane trebuie sa alterneze culorile rosu si negru.\n" +
                "\n ●  Nu sunteti limitat doar la mutarea cartilor unice. De asemenea, aveti posibilitatea sa mutati intre coloane siruri de carti \n organizate secvential.\n" +
                "\n ●  Daca nu mai aveti mutari, va trebui sa extrageti mai multe carti, facand clic/extragand din pachetul din coltul din stanga\n sus. Daca in pachet nu mai este nici o carte, faceti clic pe conturul sau de pe tabla \n pentru a le rearanja/reluati cartile ramase.\n" +
                "\n ●  Aveti posibilitatea sa mutati o carte in teancul de casa glisand-o sau facand dublu clic pe ea.\n" +
                "\n ●  Jocul poate fi intrerupt oricand de catre jucator, atunci cand nu mai poate face nici o mutare cu sens.\n");
        rules.setLayoutX(40);
        rules.setLayoutY(130);
        rules.setStyle("-fx-font-family: 'Lucida Sans';-fx-font-size: 20px;");

        layout.getChildren().add(rules);

        layout.getChildren().add(exitBtn);
        infoScene=new Scene(layout,1300,1000);


        return infoScene;
    }
    public void switchScenes(Scene scene){
        stage.setScene(scene);
    }
}
