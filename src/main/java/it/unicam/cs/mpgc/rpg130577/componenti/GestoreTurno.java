package it.unicam.cs.mpgc.rpg130577.componenti;

import it.unicam.cs.mpgc.rpg130577.giocatori.GiocatoreBot;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe che si occupa della gestione dei turni di gioco
 */
public class GestoreTurno {
    private final GestoreCombattimento combattimento;
    private final Partita partita;
    private final GiocatoreBot giocatoreBot;
    private boolean turnoAlleato;

    /**
     * Costruttore
     * @param partita Partita di cui gestire i turni
     * @param bot Giocatore bot che gioca alla partita
     */
    public GestoreTurno(Partita partita, GiocatoreBot bot){
        this.partita = partita;
        giocatoreBot = bot;

        combattimento = new GestoreCombattimento();

        turnoAlleato = true;
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
     * Effettua un turno del gioco, eseguendo prima l'azione dell'alleato poi quella dell'avversario
     * @param numeroAttaccoAlleato Numero di attacco scelto da parte dell'alleato
     */
    public void effettuaTurno(int numeroAttaccoAlleato){
        Personaggio alleato = partita.getAlleato();
        Personaggio nemico = partita.getLivelloAttuale().nemico;

        // Effettua il combattimento richiesto dall'alleato
        combattimento.eseguiAttacco(alleato, numeroAttaccoAlleato, nemico);
        cambiaTurno();

        // Controllo eventuali sconfitte
        if (partita.combattimentoTerminato())
            return;

        // Effettua il combattimento richiesto dall'avversario
        int numeroAttaccoBot = giocatoreBot.scegliAttacco();
        combattimento.eseguiAttacco(nemico, numeroAttaccoBot, alleato);
    }
}
