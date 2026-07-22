package it.unicam.cs.mpgc.rpg130577.personaggi.nemici;

import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.personaggi.utili.RandomGenerator;

/**
 * Classe concreta del personaggio nemico "Switch di rete"
 */
public class Switch extends Personaggio {
    public Switch() {
        super();
        this.hpMassimi = 70;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 20;
    }

    @Override
    public void attacca(Personaggio avversario){
        if(RandomGenerator.probabilita(20))
            avversario.subisciAttacco(25);
        else
            avversario.subisciAttacco(20);
    }

    @Override
    public void usaAbilitaSpeciale(Personaggio avversario) {

    }
}
