package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta del personaggio alleato "Sistemista di rete"
 */
public class Sistemista extends Personaggio {
    public Sistemista() {
        super();
        this.hpMassimi = 120;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 20;
        this.pathImmagine = "personaggi/alleati/sistemistaRete.png";
        this.attacchiPerAbilitaSpeciale = 4;
        inizializzaNumeroAttacchi();
    }

    @Override
    public void usaAbilitaSpeciale(Partita partita, Personaggio avversario){
        avversario.subisciAttacco(50);
        inizializzaNumeroAttacchi();
    }

    public List<Attacchi> ottieniAttacchiDisponibili(){
        List<Attacchi> attacchiDisponibili = new ArrayList<>();

        attacchiDisponibili.add(Attacchi.ATTACCO_BASE);

        if(attacchiEffettuati >= attacchiPerAbilitaSpeciale)
            attacchiDisponibili.add(Attacchi.ABILITA_SPECIALE);

        return attacchiDisponibili;
    }
}
