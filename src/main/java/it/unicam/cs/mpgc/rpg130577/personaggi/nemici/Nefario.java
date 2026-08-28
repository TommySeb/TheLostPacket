package it.unicam.cs.mpgc.rpg130577.personaggi.nemici;

import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta del personaggio nemico "Professor Nefario"
 */
public class Nefario extends Personaggio {
    public Nefario() {
        super();
        this.hpMassimi = 40;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 10;
        this.pathImmagine = "personaggi/nemici/nefario.png";
        attacchiPerAbilitaSpeciale = -1;
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {

    }

    public List<Attacchi> ottieniAttacchiDisponibili(){
        List<Attacchi> attacchiDisponibili = new ArrayList<>();

        attacchiDisponibili.add(Attacchi.ATTACCO_BASE);

        return attacchiDisponibili;
    }
}
