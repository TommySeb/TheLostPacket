package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe concreta del personaggio alleato "Masterizzatore di CD"
 */
public class Masterizzatore extends Personaggio {
    public Masterizzatore() {
        super();
        this.hpMassimi = 100;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 25;
        this.pathImmagine = "/personaggi/alleati/masterizzatore.png";
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {
        // TODO: far saltare il turno all'avversario
    }
}
