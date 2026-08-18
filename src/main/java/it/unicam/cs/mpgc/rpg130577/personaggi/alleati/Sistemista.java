package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe concreta del personaggio alleato "Sistemista di rete"
 */
public class Sistemista extends Personaggio {
    public Sistemista() {
        super();
        this.hpMassimi = 120;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 20;
        this.pathImmagine = "personaggi/alleati/sistemistaRete.png";
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario){
        avversario.subisciAttacco(50);
        inizializzaNumeroAttacchi();
    }
}
