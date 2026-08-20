package it.unicam.cs.mpgc.rpg130577.componenti;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.GeneratoreLivelli;

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

    public Partita(Personaggio alleato){
        this.alleato = alleato;

        this.livelli = new ArrayList<>();
        addLivello(GeneratoreLivelli.generaLivello1());
        addLivello(GeneratoreLivelli.generaLivello2());
        addLivello(GeneratoreLivelli.generaLivello3());
        addLivello(GeneratoreLivelli.generaLivello4());
        livelloAttuale = -1;
    }

    public Personaggio getAlleato() {
        return alleato;
    }

    public void addLivello(Livello livello){
        livelli.add(livello);
    }

    public Livello prossimoLivello(){
        livelloAttuale++;
        return livelli.get(livelloAttuale);
    }

    public Livello getLivelloAttuale(){
        if(livelloAttuale > -1)
            return livelli.get(livelloAttuale);
        else
            return null;    // TODO sistemare
    }

    public boolean isTurnoAlleato(){
        return turnoAlleato;
    }

    public void cambiaTurno(){
        turnoAlleato = !turnoAlleato;
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
}
