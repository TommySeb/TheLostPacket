package it.unicam.cs.mpgc.rpg130577.personaggi;

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
     * Utilizza, se possibile, la sua abilità speciale verso un personaggio specificato
     * @param avversario Personaggio da attaccare
     */
    void usaAbilitaSpeciale(Personaggio avversario);

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
     * Trova e restituisce la lista di attacchi che il personaggio può compiere
     */
    List<Attacchi> ottieniAttacchiDisponibili();

    /**
     * Indica se il personaggio è morto o meno
     * @return true se è morto, altrimenti false
     */
    boolean isMorto();

    int scegliAttacco();
}
