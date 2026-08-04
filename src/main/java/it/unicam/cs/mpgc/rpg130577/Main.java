package it.unicam.cs.mpgc.rpg130577;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/homepage.fxml")
        );

        Parent root = loader.load();

        Scene scene = new Scene(root, 1000, 650);
        stage.setScene(scene);

        stage.setTitle("The Lost Packet");
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
