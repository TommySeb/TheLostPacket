package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

public class Masterizzatore extends Personaggio {
    public Masterizzatore() {
        super();
        this.hpMassimi = 100;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 25;
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {
        // TODO: far saltare il turno all'avversario
    }
}
