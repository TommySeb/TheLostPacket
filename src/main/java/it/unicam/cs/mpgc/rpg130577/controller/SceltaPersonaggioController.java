package it.unicam.cs.mpgc.rpg130577.controller;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.personaggi.alleati.Masterizzatore;
import it.unicam.cs.mpgc.rpg130577.personaggi.alleati.Sistemista;
import it.unicam.cs.mpgc.rpg130577.personaggi.alleati.Sniffer;
import it.unicam.cs.mpgc.rpg130577.utili.GestoreFinestre;
import it.unicam.cs.mpgc.rpg130577.utili.LoaderImmagini;
import javafx.fxml.FXML;
import javafx.scene.image.Image;

import java.io.IOException;

/**
 * Classe controller della gui della scelta del personaggio
 */
public class SceltaPersonaggioController {
    @FXML
    private void scegliMasterizzatore(){
        Personaggio masterizzatore = new Masterizzatore();
        apriGiocoConAlleato(masterizzatore);
    }

    @FXML
    private void scegliSistemista(){
        Personaggio sistemista = new Sistemista();
        apriGiocoConAlleato(sistemista);
    }

    @FXML
    private void scegliSniffer(){
        Personaggio sniffer = new Sniffer();
        apriGiocoConAlleato(sniffer);
    }

    /**
     * Apre la schermata di gioco impostando l'alleato scelto
     * @param alleato Alleato da impostare
     */
    private void apriGiocoConAlleato(Personaggio alleato){
        try{
            GiocoController controller = GestoreFinestre.apriDaFXML("/fxml/gioco.fxml", "Gioco", false);
            controller.inizializzaPartita(alleato);
        } catch (IOException e) {
            // TODO gestire
            throw new RuntimeException(e);
        }
    }
}
