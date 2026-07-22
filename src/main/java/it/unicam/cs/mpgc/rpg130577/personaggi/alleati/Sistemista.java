package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe concreta del personaggio alleato "Sistemista di rete"
 */
public class Sistemista extends Personaggio {
    public Sistemista() {
        this.hpMassimi = 120;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 20;
        inizializzaNumeroAttacchi();
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario){
        avversario.subisciAttacco(50);
        inizializzaNumeroAttacchi();
    }
}
