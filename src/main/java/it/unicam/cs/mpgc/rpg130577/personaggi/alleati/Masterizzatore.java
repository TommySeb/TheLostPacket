package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta del personaggio alleato "Masterizzatore di CD"
 */
public class Masterizzatore extends Personaggio {
    public Masterizzatore() {
        super();
        this.hpMassimi = 170;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 25;
        this.pathImmagine = "personaggi/alleati/masterizzatore.png";
        attacchiPerAbilitaSpeciale = 4;
        inizializzaNumeroAttacchi();
    }

    @Override
    public void usaAbilitaSpeciale(Partita partita, Personaggio avversario) {
        partita.getGestoreTurni().setSaltaTurno(true);
    }

    public List<Attacchi> ottieniAttacchiDisponibili(){
        List<Attacchi> attacchiDisponibili = new ArrayList<>();

        attacchiDisponibili.add(Attacchi.ATTACCO_BASE);

        if(attacchiEffettuati >= attacchiPerAbilitaSpeciale)
            attacchiDisponibili.add(Attacchi.ABILITA_SPECIALE);

        return attacchiDisponibili;
    }
}
