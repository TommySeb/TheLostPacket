package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe concreta del personaggio alleato "Sniffer di rete"
 */
public class Sniffer extends Personaggio {
    public Sniffer() {
        this.hpAttuali = 100;
        this.puntiAttacco = 25;
        inizializzaNumeroAttacchi();
    }

    @Override
    public void attacca(Personaggio avversario) {
        avversario.subisciAttacco(this.puntiAttacco);
        registraAttacco();
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {
        recuperaPuntiVita(20);
        inizializzaNumeroAttacchi();
    }

    @Override
    public void subisciAttacco(int hp) {
        this.hpAttuali -= hp;
    }

    /**
     * Aggiunte health points al personaggio
     * @param hp numero di health point da aggiungere
     */
    public void recuperaPuntiVita(int hp){
        if(this.hpAttuali + hp > this.hpMassimi)
            this.hpAttuali = this.hpMassimi;
        else
            this.hpAttuali += hp;
    }

    @Override
    public void registraAttacco() {
        this.attacchiEffettuati++;
    }

    @Override
    public void inizializzaNumeroAttacchi() {
        this.attacchiEffettuati = 0;
    }
}
