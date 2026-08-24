package it.unicam.cs.mpgc.rpg130577.personaggi.alleati;

import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concreta del personaggio alleato "Sniffer di rete"
 */
public class Sniffer extends Personaggio {
    public Sniffer() {
        hpMassimi = 100;
        hpAttuali = hpMassimi;
        puntiAttacco = 25;
        pathImmagine = "personaggi/alleati/snifferRete.png";
        attacchiPerAbilitaSpeciale = 4;
        inizializzaNumeroAttacchi();
    }

    public void usaAbilitaSpeciale(Personaggio avversario) {
        recuperaPuntiVita(20);
        inizializzaNumeroAttacchi();
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

    public List<Attacchi> ottieniAttacchiDisponibili(){
        List<Attacchi> attacchiDisponibili = new ArrayList<>();

        attacchiDisponibili.add(Attacchi.ATTACCO_BASE);

        if(attacchiEffettuati >= attacchiPerAbilitaSpeciale)
            attacchiDisponibili.add(Attacchi.ABILITA_SPECIALE);

        return attacchiDisponibili;
    }
}
