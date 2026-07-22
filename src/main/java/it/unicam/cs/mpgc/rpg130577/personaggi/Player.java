package it.unicam.cs.mpgc.rpg130577.personaggi;

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
}
