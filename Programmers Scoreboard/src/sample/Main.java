package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("CF.fxml"));

        Scene scene = new Scene(root,1390,700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Programmers Scoreboard");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("Programmer.png")));
        primaryStage.show();

       // CF cf = new CF();
        //cf.getRankGraph("Rashid_Abrar_Riyad");

    }
}
