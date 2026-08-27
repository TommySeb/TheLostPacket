package it.unicam.cs.mpgc.rpg130577.componenti;

import it.unicam.cs.mpgc.rpg130577.giocatori.GiocatoreBot;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.GeneratoreLivelli;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che si occupa della gestione della partita
 */
public class Partita {
    Personaggio alleato;
    List<Livello> livelli;
    int livelloAttuale;
    boolean vincita;
    GestoreCombattimento combattimento;

    GiocatoreBot giocatoreBot;
    GestoreTurno turno;

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

        giocatoreBot = new GiocatoreBot(getLivelloAttuale().getNemico());
        turno = new GestoreTurno(this, giocatoreBot);
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
        if(getLivelloAttuale().getNemico().isMorto()){
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
        else if(getLivelloAttuale().getNemico().isMorto() && livelliFiniti()){
            vincita = true;
            return true;
        }
        else
            return false;
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
        if(getGestoreTurni().isTurnoAlleato())
            return getAlleato();
        else
            return getLivelloAttuale().getNemico();
    }

    /**
     * Ritorna il personaggio di cui non è il turno ora
     */
    public Personaggio getPersonaggioNonDiTurno(){
        if(getGestoreTurni().isTurnoAlleato())
            return getLivelloAttuale().getNemico();
        else
            return getAlleato();
    }

    /**
     * Indica se il personaggio non di turno dovrà saltare il turno o meno
     * @return true se il personaggio non di turno dovrà saltare il turno, altrimenti false
     */
    public boolean getSaltaTurno(){
        return getGestoreTurni().getSaltaTurno();
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
     * Passa al prossimo livello del gioco
     */
    public void prossimoLivello(){
        if(!livelliFiniti())
            livelloAttuale++;
    }

    /**
     * Indica se i livelli sono finiti o meno
     * @return true se i livelli sono finiti, altrimenti false
     */
    public boolean livelliFiniti(){
        return livelloAttuale >= livelli.size() - 1;
    }

    public void setCombattimento(GestoreCombattimento combattimento) {
        this.combattimento = combattimento;
    }

    /**
     * Restituisce il gestore dei turni di questa partita
     * @return Gestore dei turni di questa partita
     */
    public GestoreTurno getGestoreTurni(){
        return turno;
    }
}
