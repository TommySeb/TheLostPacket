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
    private static Stage stageAttuale;

    /**
     * Costruttore
     */
    private GestoreFinestre() {
    }

    /**
     * Apre una nuova finestra
     * @param percorso Percorso del file fxml
     * @param titolo Titolo della finestra
     * @param isPopUp Se true, apre la finestra come pop-up
     * @return Controller della form aperta
     */
    public static <T> T apriDaFXML(String percorso, String titolo, boolean isPopUp) {
        if (stageAttuale != null && !isPopUp) {
            stageAttuale.close();
        }

        FXMLLoader loader = new FXMLLoader(
                GestoreFinestre.class.getResource(percorso)
        );

        try{
            Parent root = loader.load();
            stageAttuale = new Stage();
            stageAttuale.setTitle(titolo);
            stageAttuale.setScene(new Scene(root));
            stageAttuale.setResizable(false);

            if(isPopUp){
                stageAttuale.initModality(Modality.APPLICATION_MODAL);
                stageAttuale.showAndWait();
            }
            else
                stageAttuale.show();
        } catch (IOException e) {
            throw new RuntimeException("Impossibile caricare il file fxml al percorso " + percorso, e);
        }

        return loader.getController();
    }
}
