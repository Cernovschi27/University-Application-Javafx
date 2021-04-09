package lab3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * lab3.Main class where program starts.
 */
public class StartApp extends Application {

    public static void startStage(Stage primaryStage, String path) throws IOException {
        Parent mainMenuRoot = FXMLLoader.load(StartApp.class.getResource(path));
        Scene mainMenuScene = new Scene(mainMenuRoot);
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Main Menu");
        startStage(primaryStage, "view/mainMenuScene.fxml");
    }

    /**
     * Start point of the application
     * @param args command line arguments
     */
    public static void main(String[] args){

        launch(args);
    }
}