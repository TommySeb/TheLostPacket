package it.unicam.cs.mpgc.rpg130577.componenti;

import it.unicam.cs.mpgc.rpg130577.giocatori.GiocatoreBot;

/**
 * Classe che si occupa della gestione dei turni di gioco
 */
public class GestoreTurno {
    // TODO riferimento circolare
    private GestoreCombattimento combattimento;
    private Partita partita;
    private GiocatoreBot giocatoreBot;
    private boolean turnoAlleato;
    private boolean saltaTurno;

    /**
     * Costruttore
     * @param partita Partita di cui gestire i turni
     * @param bot Giocatore bot che gioca alla partita
     */
    public GestoreTurno(Partita partita, GiocatoreBot bot){
        this.partita = partita;
        giocatoreBot = bot;

        combattimento = new GestoreCombattimento(partita);

        turnoAlleato = true;
        saltaTurno = false;
    }

    /**
     * Indica se è il turno del personaggio alleato o meno
     * @return True se è il turno del personaggio alleato, altrimenti false
     */
    public boolean isTurnoAlleato(){
        return turnoAlleato;
    }

    /**
     * Passa il turno al personaggio opposto
     */
    public void cambiaTurno(){
        turnoAlleato = !turnoAlleato;
    }

    /**
     * Indica se il personaggio non di turno dovrà saltare il turno o meno
     * @return True se dovrà saltarlo, altrimenti false
     */
    public boolean getSaltaTurno(){
        return saltaTurno;
    }

    /**
     * Imposta se il personaggio non di turno dovrà saltare il turno o meno
     * @param valore True se dovrà saltarlo, altrimenti false
     */
    public void setSaltaTurno(boolean valore){
        saltaTurno = valore;
    }

    /**
     * Effettua un turno del gioco, eseguendo prima l'azione dell'alleato poi quella dell'avversario
     * @param numeroAttaccoAlleato Numero di attacco scelto da parte dell'alleato
     */
    public void effettuaTurno(int numeroAttaccoAlleato){
        // Effettua il combattimento richiesto dall'alleato
        combattimento.eseguiAttacco(numeroAttaccoAlleato);

        // Controllo eventuali sconfitte
        if (partita.combattimentoTerminato())
            return;

        // Effettua il combattimento richiesto dall'avversario
        int attaccoScelto = giocatoreBot.scegliAttacco();
        combattimento.eseguiAttacco(attaccoScelto);
    }
}
