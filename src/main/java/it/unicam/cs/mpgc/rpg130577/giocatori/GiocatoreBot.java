package it.unicam.cs.mpgc.rpg130577.giocatori;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.GeneratoreCasuale;

/**
 * Classe che rappresenta un giocatore non reale, ossia un bot
 */
public class GiocatoreBot {
    Personaggio personaggio;

    /**
     * Costruttore
     * @param personaggio Personaggio associato al giocatore bot
     */
    public GiocatoreBot(Personaggio personaggio){
        setPersonaggio(personaggio);
    }

    /**
     * Chiede al personaggio di scegliere ed effettuare l'attacco che desidera
     */
    public int scegliAttacco(){
        int numeroAttacchi = personaggio.ottieniAttacchiDisponibili().size();
        return GeneratoreCasuale.generaNumero(numeroAttacchi);
    }

    /**
     * Permette di impostare il personaggio associato al bot
     * @param personaggio Personaggio associato al giocatore bot
     */
    public void setPersonaggio(Personaggio personaggio){
        this.personaggio = personaggio;
    }
}
