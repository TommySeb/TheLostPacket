package it.unicam.cs.mpgc.rpg130577.componenti;

import it.unicam.cs.mpgc.rpg130577.giocatori.GiocatoreBot;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.GeneratoreLivelli;
import it.unicam.cs.mpgc.rpg130577.utili.GestoreCombattimento;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che contiene le informazioni (lo stato) di una partita
 */
public class Partita {
    Personaggio alleato;
    List<Livello> livelli;
    int livelloAttuale;
    boolean turnoAlleato;
    boolean saltaTurno;
    boolean vincita;
    GestoreCombattimento combattimento;

    GiocatoreBot giocatoreBot;

    /**
     * Costruttore
     * @param alleato Personaggio alleato che gioca la partita
     */
    public Partita(Personaggio alleato){
        this.alleato = alleato;

        this.livelli = new ArrayList<>();
        addLivello(GeneratoreLivelli.generaLivello1());
        addLivello(GeneratoreLivelli.generaLivello2());
        addLivello(GeneratoreLivelli.generaLivello3());
        addLivello(GeneratoreLivelli.generaLivello4());
        livelloAttuale = 0;

        turnoAlleato = true;

        giocatoreBot = new GiocatoreBot(getLivelloAttuale().getAvversario());
    }

    /**
     * Indica se la partita è iniziata o meno
     * @return true se è iniziata, altrimenti false
     */
    public boolean isIniziata(){
        return livelloAttuale >= 0;
    }

    /**
     * Controlla se il livello è terminato e, in caso affermativo, passa al successivo
     * @return true se il livello è terminato, altrimenti false
     */
    public boolean livelloTerminato(){
        if(getLivelloAttuale().getAvversario().isMorto()){
            prossimoLivello();
            return true;
        }
        else
            return false;
    }

    /**
     * Controlla se il combattimento è terminato
     * @return true se terminato, altrimenti false
     */
    public boolean combattimentoTerminato(){
        if(alleato.isMorto()){
            vincita = false;
            return true;
        }
        else if(getLivelloAttuale().getAvversario().isMorto() && livelliFiniti()){
            vincita = true;
            return true;
        }
        else
            return false;
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
     * Restituisce il personaggio alleato che gioca la partita
     * @return Personaggio alleato che gioca la partita
     */
    public Personaggio getAlleato() {
        return alleato;
    }

    /**
     * Ritorna il personaggio di cui è il turno ora
     */
    public Personaggio getPersonaggioDiTurno(){
        if(isTurnoAlleato())
            return getAlleato();
        else
            return getLivelloAttuale().getAvversario();
    }

    /**
     * Ritorna il personaggio di cui non è il turno ora
     */
    public Personaggio getPersonaggioNonDiTurno(){
        if(isTurnoAlleato())
            return getLivelloAttuale().getAvversario();
        else
            return getAlleato();
    }

    /**
     * Imposta se il personaggio non di turno dovrà saltare il turno o meno
     */
    public void setSaltaTurno(boolean valore){
        saltaTurno = valore;
    }

    /**
     * Indica se il personaggio non di turno dovrà saltare il turno o meno
     * @return
     */
    public boolean getSaltaTurno(){
        return saltaTurno;
    }

    /**
     * Indica se la partita è stata vinta o meno
     * @return true se l'alleato ha vinto, altrimenti false
     */
    public boolean getEsito(){
        return vincita;
    }

    /**
     * Aggiunge un livello alla partita
     * @param livello Livello da aggiungere
     */
    public void addLivello(Livello livello){
        livelli.add(livello);
    }

    /**
     * Restituisce il livello attuale del gioco
     * @return Livello attuale del gioco o, se la partita non è iniziata, null
     */
    public Livello getLivelloAttuale(){
        if(isIniziata())
            return livelli.get(livelloAttuale);
        else
            return null;
    }

    /**
     * Restituisce il prossimo livello del gioco
     * @return Prossimo livello del gioco o, se finiti, null
     */
    public Livello prossimoLivello(){
        if(!livelliFiniti()){
            livelloAttuale++;
            return livelli.get(livelloAttuale);
        }
        else
            return null;
    }

    /**
     * Indica se i livelli sono finiti o meno
     * @return true se i livelli sono finiti, altrimenti false
     */
    public boolean livelliFiniti(){
        return livelloAttuale >= livelli.size() - 1;
    }

    public GestoreCombattimento getCombattimento() {
        return combattimento;
    }

    public void setCombattimento(GestoreCombattimento combattimento) {
        this.combattimento = combattimento;
    }

    /**
     * Effettua un turno del gioco, eseguendo prima l'azione dell'alleato poi quella dell'avversario
     * @param numeroAttaccoAlleato Numero di attacco scelto da parte dell'alleato
     */
    public void effettuaTurno(int numeroAttaccoAlleato){
        // Effettua il combattimento richiesto dall'alleato
        combattimento.eseguiAttacco(numeroAttaccoAlleato);

        // Controllo eventuali sconfitte
        if (combattimentoTerminato())
            return;

        // Effettua il combattimento richiesto dall'avversario
        int attaccoScelto = giocatoreBot.scegliAttacco();
        combattimento.eseguiAttacco(attaccoScelto);
    }
}
