package it.unicam.cs.mpgc.rpg130577.ambienti.controller;

import it.unicam.cs.mpgc.rpg130577.ambienti.enumerazione.Ambienti;
import it.unicam.cs.mpgc.rpg130577.ambienti.gui.AmbienteGUI;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import javafx.scene.image.Image;

/**
 * Classe che controlla l'interfaccia grafica degli ambienti di gioco
 */
public class AmbienteController {
    private AmbienteGUI interfaccia;

    public AmbienteController(AmbienteGUI gui){
        interfaccia = gui;
    }

    private Image caricaImmagine(String percorso) {
        return new Image(getClass().getResourceAsStream(percorso));
    }

    /**
     * Carica un'ambientazione specificata
     */
    public void caricaAmbiente(Ambienti ambiente){
        Image sfondo = caricaImmagine(ambiente.getPercorsoSfondo());
        interfaccia.impostaSfondo(sfondo);
    }

    public void caricaPersonaggioAlleato(Personaggio personaggio){
        // TODO Implementare
    }

    public void caricaPersonaggioNemico(Personaggio personaggio){
        // TODO Implementare
    }
}
