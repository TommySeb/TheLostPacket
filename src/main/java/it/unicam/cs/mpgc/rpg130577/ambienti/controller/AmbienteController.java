package it.unicam.cs.mpgc.rpg130577.ambienti.controller;

import it.unicam.cs.mpgc.rpg130577.ambienti.enumerazione.Ambienti;
import it.unicam.cs.mpgc.rpg130577.ambienti.gui.AmbienteGUI;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.personaggi.utili.LoaderImmagini;
import javafx.scene.image.Image;

/**
 * Classe che controlla l'interfaccia grafica degli ambienti di gioco
 */
public class AmbienteController {
    private AmbienteGUI interfaccia;

    public AmbienteController(AmbienteGUI gui){
        interfaccia = gui;
    }

    /**
     * Carica un'ambientazione specificata
     */
    public void caricaAmbiente(Ambienti ambiente){
        Image sfondo = LoaderImmagini.carica(ambiente.getPercorsoSfondo());
        interfaccia.impostaSfondo(sfondo);
    }

    /**
     * Carica le informazioni del personaggio alleato specificato
     * @param personaggio Personaggio da caricare
     */
    public void caricaPersonaggioAlleato(Personaggio personaggio){
        interfaccia.setHpAttualiPersonaggioAlleato(personaggio.getHpAttuali());
        interfaccia.setHpTotaliPersonaggioAlleato(personaggio.getHpMassimi());

        Image sfondo = LoaderImmagini.carica(personaggio.getPercorsoImmagine());
        interfaccia.setImmaginePersonaggioAlleato(sfondo);
    }

    /**
     * Carica le informazioni del personaggio nemico specificato
     * @param personaggio Personaggio da caricare
     */
    public void caricaPersonaggioNemico(Personaggio personaggio){
        interfaccia.setHpAttualiPersonaggioNemico(personaggio.getHpAttuali());
        interfaccia.setHpTotaliPersonaggioNemico(personaggio.getHpMassimi());

        Image sfondo = LoaderImmagini.carica(personaggio.getPercorsoImmagine());
        interfaccia.setImmaginePersonaggioNemico(sfondo);
    }
}
