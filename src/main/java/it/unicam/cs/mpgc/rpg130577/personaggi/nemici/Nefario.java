package it.unicam.cs.mpgc.rpg130577.personaggi.nemici;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe concreta del personaggio nemico "Professor Nefario"
 */
public class Nefario extends Personaggio {
    public Nefario() {
        super();
        this.hpMassimi = 50;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 15;
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {

    }
}
