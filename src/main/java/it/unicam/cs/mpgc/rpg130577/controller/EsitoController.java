package it.unicam.cs.mpgc.rpg130577.controller;

import it.unicam.cs.mpgc.rpg130577.utili.GestoreFinestre;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class EsitoController {
    @FXML
    private Label labelEsito;

    @FXML
    private void giocaDiNuovo() throws IOException {
        GestoreFinestre.apriDaFXML("/fxml/homepage.fxml", "Homepage", false);
    }

    public void setLabelEsito(boolean vincita){
        if(vincita){
            labelEsito.setText("Complimenti!\n Hai vinto!");
            labelEsito.getStyleClass().add("vincita");
        }

        else{
            labelEsito.setText("Hai perso! \n Riprova di nuovo!");
            labelEsito.getStyleClass().add("perdita");
        }

    }
}
