package it.unicam.cs.mpgc.rpg130577.utili;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Classe per l'apertura di nuove finestre
 */
public class GestoreFinestre {
    /**
     * Apre una nuova finestra
     * @param percorso Percorso del file fxml
     * @param titolo Titolo della finestra
     * @param isPopUp Se true, apre la finestra come pop-up
     * @throws IOException Se il percorso non porta a una risorsa fxml valida
     */
    public static void apriDaFXML(String percorso, String titolo, boolean isPopUp) throws IOException {
        FXMLLoader loader = new FXMLLoader(
                GestoreFinestre.class.getResource(percorso)
        );

        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(titolo);
        stage.setScene(new Scene(root));
        stage.setResizable(false);

        if(isPopUp){
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        }
        else
            stage.show();
    }
}
