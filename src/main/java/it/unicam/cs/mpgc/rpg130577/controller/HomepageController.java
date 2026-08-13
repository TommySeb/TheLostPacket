package it.unicam.cs.mpgc.rpg130577.controller;

import it.unicam.cs.mpgc.rpg130577.utili.GestoreFinestre;
import javafx.fxml.FXML;
import java.io.IOException;

public class HomepageController {
    @FXML
    private void apriCredits() throws IOException {
        GestoreFinestre.apriDaFXML("/fxml/credits.fxml", "Credits", true);
    }

    @FXML
    private void apriSceltaPersonaggio() throws IOException {
        GestoreFinestre.apriDaFXML("/fxml/sceltaPersonaggio.fxml", "Scelta personaggio", true);
    }
}
