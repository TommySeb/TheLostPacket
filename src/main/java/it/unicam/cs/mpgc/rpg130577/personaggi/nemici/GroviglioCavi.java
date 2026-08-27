package it.unicam.cs.mpgc.rpg130577.personaggi.nemici;

import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta del personaggio nemico "Groviglio di cavi"
 */
public class GroviglioCavi extends Personaggio {
    public GroviglioCavi() {
        super();
        this.hpMassimi = 60;
        this.hpAttuali = this.hpMassimi;
        this.puntiAttacco = 17;
        this.pathImmagine = "personaggi/nemici/groviglioCavi.png";
        attacchiPerAbilitaSpeciale = 4;
        inizializzaNumeroAttacchi();
    }

    @Override
    public void usaAbilitaSpeciale(Partita partita, Personaggio avversario) {
        avversario.subisciAttacco(30);
        inizializzaNumeroAttacchi();
    }

    public List<Attacchi> ottieniAttacchiDisponibili(){
        List<Attacchi> attacchiDisponibili = new ArrayList<>();

        attacchiDisponibili.add(Attacchi.ATTACCO_BASE);

        if(attacchiEffettuati >= attacchiPerAbilitaSpeciale)
            attacchiDisponibili.add(Attacchi.ABILITA_SPECIALE);

        return attacchiDisponibili;
    }
}
