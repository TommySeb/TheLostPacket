package it.unicam.cs.mpgc.rpg130577;

import it.unicam.cs.mpgc.rpg130577.utili.GestoreFinestre;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        /*
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/homepage.fxml")
        );

        Parent root = loader.load();

        Scene scene = new Scene(root, 1000, 650);
        stage.setScene(scene);

        stage.setTitle("The Lost Packet");
        stage.show();

         */

        GestoreFinestre.apriDaFXML("/fxml/homepage.fxml", "The Lost Packet", false);
    }

    public static void main(String[] args){
        launch(args);
    }
}
