
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.concurrent.Executors;

/**
 * @author Carina
 * <p>Main unde creeam prima fereastra si lansez aplicatia</p>
 */
public class Main extends Application
{
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setResizable(false);
        window.setTitle("Movies & Persons Database");
        window.getIcons().add(new Image("database_add.png"));
        AnchorPane layout =new AnchorPane();
        DatabaseComands commands=new DatabaseComands(window,layout);
        commands.initStage();
        Scene scene=new Scene(layout,1000,400);
        window.setScene(scene);
        window.show();



    }
    //in main am facut connection pool, care imbunatateste performanta conexiunii cu baza de date si operatiilor de scriere citire din ea
    public static void main(String[] args )
    {
        launch(args);
        MyThreadPoolExecutor threadPoolExecutor = (MyThreadPoolExecutor) Executors.newFixedThreadPool(25);


        for (int i = 1; i <= 25; i++) {
            Runnable artistThread = new MovieThread(i);
            threadPoolExecutor.execute(artistThread);
            artistThread.run();
        }
    }
}
