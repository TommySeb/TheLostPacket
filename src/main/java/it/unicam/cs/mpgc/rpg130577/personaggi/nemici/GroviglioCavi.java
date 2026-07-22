package it.unicam.cs.mpgc.rpg130577.personaggi.nemici;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe concreta del personaggio nemico "Groviglio di cavi"
 */
public class GroviglioCavi extends Personaggio {
    public GroviglioCavi() {
        super();
        this.hpMassimi = 100;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 23;
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {
        avversario.subisciAttacco(30);
        inizializzaNumeroAttacchi();
    }
}
