package it.unicam.cs.mpgc.rpg130577.personaggi;

import it.unicam.cs.mpgc.rpg130577.componenti.GestoreTurno;
import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;

import java.util.List;

/**
 * Rappresenta un personaggio del videogioco
 */
public interface Player {
    /**
     * Effettua un attacco verso un personaggio specificato
     * @param avversario Personaggio da attaccare
     */
    void attacca(Personaggio avversario);

    /**
     * Diminuisce la vita del personaggio di un punteggio specificato
     * @param hp "Health Points" da diminuire
     */
    void subisciAttacco(int hp);

    /**
     * Aumenta il contatore del numero di attacchi
     */
    void registraAttacco();

    /**
     * Inizializza il contatore del numero di attacchi
     */
    void inizializzaNumeroAttacchi();

    /**
     * Utilizza l'abilità speciale di un personaggio
     * @param avversario Avversario verso il quale viene applicata l'abilità speciale
     */
    void usaAbilitaSpeciale(Personaggio avversario);

    /**
     * Trova e restituisce la lista di attacchi che il personaggio può compiere
     */
    List<Attacchi> ottieniAttacchiDisponibili();

    /**
     * Indica se il personaggio è morto o meno
     * @return true se è morto, altrimenti false
     */
    boolean isMorto();
}
