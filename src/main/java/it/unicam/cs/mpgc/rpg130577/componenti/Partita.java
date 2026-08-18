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

    public Partita(Personaggio alleato){
        this.alleato = alleato;

        this.livelli = new ArrayList<>();
        addLivello(GeneratoreLivelli.generaLivello1());
        addLivello(GeneratoreLivelli.generaLivello2());
        addLivello(GeneratoreLivelli.generaLivello3());
        addLivello(GeneratoreLivelli.generaLivello4());
        livelloAttuale = -1;
    }

    public void addLivello(Livello livello){
        livelli.add(livello);
    }

    public Livello prossimoLivello(){
        livelloAttuale++;
        return livelli.get(livelloAttuale);
    }
}
