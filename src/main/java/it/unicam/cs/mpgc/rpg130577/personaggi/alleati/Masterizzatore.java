package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

public class Masterizzatore extends Personaggio {
    public Masterizzatore() {
        this.hpAttuali = 100;
        this.puntiAttacco = 25;
        inizializzaNumeroAttacchi();
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {
        // TODO: far saltare il turno all'avversario
    }
}
