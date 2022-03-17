

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;


import java.io.FileNotFoundException;
import java.sql.SQLException;


public class DatabaseComands {
    Stage window;
    AnchorPane layout;

    public DatabaseComands(Stage window, AnchorPane layout){
        this.window=window;
        this.layout=layout;
    }
    //creez interfata pentru afisarea datelor din baza de date( pentru butoane si pentru ce pot face in aceasta aplicatie
    public void initStage(){
        //pun un background
        BackgroundImage myBI=new BackgroundImage(new Image("newback.jpg",1000,400,false,true),BackgroundRepeat.REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));
        // titlu aplicatiei
        Label title = new Label("Movies & Persons Database");
        title.setFont(new Font("Nunito",40));
        title.setTextFill(Color.web("#3b136b"));
        AnchorPane.setRightAnchor(title,360.00);
        AnchorPane.setTopAnchor(title,20.00);
        layout.getChildren().add(title);
        // subtitlul aplicatiei
        Label title2= new Label("My Management App");
        title2.setFont(new Font("Nunito",30));
        title2.setTextFill(Color.web("#3b136b"));
        AnchorPane.setRightAnchor(title2,490.00);
        AnchorPane.setTopAnchor(title2,55.00);
        layout.getChildren().add(title2);


        //button de conectare la baza de date + inserare  doua elemente( unu in movies si unu in genres)
        Button connBtn=new Button("Connect to database");
        connBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #99e6ff;");
        connBtn.setOnAction(connHandler);
        AnchorPane.setTopAnchor(connBtn,110.00);
        AnchorPane.setRightAnchor(connBtn,730.00);
        layout.getChildren().add(connBtn);
        // buton pentru a vedea toate filmele existente si date despre ele
        Button nameMovieBtn=new Button("See Movies");
        nameMovieBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #99e6ff;");
        nameMovieBtn.setOnAction(nameMovieHandler);
        AnchorPane.setTopAnchor(nameMovieBtn,110.00);
        AnchorPane.setRightAnchor(nameMovieBtn,500.00);
        layout.getChildren().add(nameMovieBtn);

        //buton pentru afisarea filmelor in functie de genuri
        final ComboBox genreComboBox = new ComboBox();
        genreComboBox.getItems().addAll(
                "Drama",
                "Crima",
                "Romance",
                "Action",
                "Fiction",
                "Melodrama"
        );

        genreComboBox.setPromptText("See Movies By Genre");
        genreComboBox.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #99e6ff;");
        genreComboBox.setOnAction(ep -> {Database database=null;
        try{
            database=Database.getInstance();
            GenreController genres=new GenreController(database);
            genres.findByName(genreComboBox.getValue().toString());
            // database.connection.close();

        } catch (SQLException exc){
            exc.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }});
        AnchorPane.setTopAnchor(genreComboBox,160.00);
        AnchorPane.setRightAnchor(genreComboBox,500.00);
        layout.getChildren().add(genreComboBox);

        //buton pentru afisarea datelor despre un film cu id -ul dat
        Button idMovieBtn=new Button("Find Movie by ID");
        idMovieBtn.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #99e6ff;");
        idMovieBtn.setOnAction(idMovieHandler);
        AnchorPane.setTopAnchor(idMovieBtn,160.00);
        AnchorPane.setRightAnchor(idMovieBtn,730.00);
        layout.getChildren().add(idMovieBtn);

        //buton pentru a vedea actorii si directorii unui film
        final ComboBox actorsComboBox = new ComboBox();
        actorsComboBox.getItems().addAll(
                "The Avengers",
                "Cinderella",
                "Another Day",
                "Another Cinderella Story"
        );

        actorsComboBox.setPromptText("Actors & Directors");
        actorsComboBox.setStyle("-fx-pref-height: 40px;"+"-fx-pref-width: 200px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #99e6ff;");
        actorsComboBox.setOnAction(ep -> {Database database=null;
            try{
                database=Database.getInstance();
                MovieController movieActors=new MovieController(database);
                movieActors.findActorByMovie(actorsComboBox.getValue().toString());

            } catch (SQLException exc){
                exc.printStackTrace();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }});
        AnchorPane.setTopAnchor(actorsComboBox,210.00);
        AnchorPane.setRightAnchor(actorsComboBox,730.00);
        layout.getChildren().add(actorsComboBox);

        //button de exit
        Button exitBtn=new Button("Exit");
        exitBtn.setStyle("-fx-pref-height: 40px;"+ "-fx-pref-width: 100px;"+"-fx-font: 18 Nunito;"+"-fx-background-color: #99e6ff;");
        exitBtn.setOnAction(exitHandler);
        AnchorPane.setTopAnchor(exitBtn,320.00);
        AnchorPane.setRightAnchor(exitBtn,490.00);
        layout.getChildren().add(exitBtn);
    }

    //Handlere pentru ce se va apela cand se apasa diverse butoane

    EventHandler<ActionEvent> connHandler=new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Database database=null;
            try{
                database=Database.getInstance();
                MovieController movies=new MovieController(database);
                movies.create(4,"Another Cinderella Story",2008,129,9.7);
                GenreController genres=new GenreController(database);
                genres.create(5,"Romantic");
               // database.connection.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            } catch (FileNotFoundException e){
                e.printStackTrace();
            }

        }
    };
    EventHandler<ActionEvent> idMovieHandler=new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Database database=null;
            try{
                database=Database.getInstance();
                MovieController movies=new MovieController(database);
                movies.findByAMovieId(1);

            } catch (SQLException exc){
                exc.printStackTrace();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }

    };
    EventHandler<ActionEvent> nameMovieHandler=new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Database database=null;
            try{
                database=Database.getInstance();
                MovieController movies=new MovieController(database);
                movies.allMovies();


            } catch (SQLException exc){
                exc.printStackTrace();
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
    };
    EventHandler<ActionEvent> exitHandler=new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            window.close();
        }
    };
}
