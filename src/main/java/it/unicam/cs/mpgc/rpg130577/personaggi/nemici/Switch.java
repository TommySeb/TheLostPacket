package it.unicam.cs.mpgc.rpg130577.personaggi.nemici;

import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.GeneratoreCasuale;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta del personaggio nemico "Switch di rete"
 */
public class Switch extends Personaggio {
    public Switch() {
        super();
        this.hpMassimi = 70;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 20;
        this.pathImmagine = "personaggi/nemici/switchRete.png";
        attacchiPerAbilitaSpeciale = -1;
    }

    @Override
    public void attacca(Personaggio avversario){
        if(GeneratoreCasuale.probabilita(20))
            avversario.subisciAttacco(25);
        else
            avversario.subisciAttacco(20);
    }

    public List<Attacchi> ottieniAttacchiDisponibili(){
        List<Attacchi> attacchiDisponibili = new ArrayList<>();

        attacchiDisponibili.add(Attacchi.ATTACCO_BASE);

        return attacchiDisponibili;
    }
}
