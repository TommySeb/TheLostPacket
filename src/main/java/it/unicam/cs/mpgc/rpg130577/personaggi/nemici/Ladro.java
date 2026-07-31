package it.unicam.cs.mpgc.rpg130577.personaggi.nemici;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe concreta del personaggio nemico "Ladro"
 */
public class Ladro extends Personaggio {
    public Ladro() {
        super();
        this.hpMassimi = 180;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 30;
        this.pathImmagine = "/personaggi/alleati/ladro.png";
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {
        // TODO: annulla l'abilità speciale del nemico
    }
}
