package it.unicam.cs.mpgc.rpg130577.personaggi.nemici;

import it.unicam.cs.mpgc.rpg130577.componenti.GestoreTurno;
import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta del personaggio nemico "Ladro"
 */
public class Ladro extends Personaggio {
    public Ladro() {
        super();
        this.hpMassimi = 100;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 20;
        this.pathImmagine = "personaggi/nemici/ladro.png";
        attacchiPerAbilitaSpeciale = 4;
        inizializzaNumeroAttacchi();
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {
        avversario.inizializzaNumeroAttacchi();
    }

    public List<Attacchi> ottieniAttacchiDisponibili(){
        List<Attacchi> attacchiDisponibili = new ArrayList<>();

        attacchiDisponibili.add(Attacchi.ATTACCO_BASE);

        if(attacchiEffettuati >= attacchiPerAbilitaSpeciale)
            attacchiDisponibili.add(Attacchi.ABILITA_SPECIALE);

        return attacchiDisponibili;
    }
}
