package it.unicam.cs.mpgc.rpg130577.utili;

import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.personaggi.alleati.Masterizzatore;
import it.unicam.cs.mpgc.rpg130577.personaggi.alleati.Sistemista;
import it.unicam.cs.mpgc.rpg130577.personaggi.alleati.Sniffer;
import it.unicam.cs.mpgc.rpg130577.personaggi.nemici.GroviglioCavi;
import it.unicam.cs.mpgc.rpg130577.personaggi.nemici.Ladro;

import java.util.List;

public class GestoreCombattimento {
    Partita partita;

    public GestoreCombattimento(Partita partita) {
        this.partita = partita;
    }

    /**
     * Esegue un attacco verso un personaggio specificato
     * @param numero Indice dell'attacco da effettuare per il personaggio di turno tra quelli disponibili
     */
    public void eseguiAttacco(int numero){
        Personaggio attaccante = partita.getPersonaggioDiTurno();
        List<Attacchi> attacchiDisponibiliAttaccante = attaccante.ottieniAttacchiDisponibili();
        Personaggio avversario = partita.getPersonaggioNonDiTurno();

        if(numero >= 0 && numero < attacchiDisponibiliAttaccante.size()){
            Attacchi attaccoScelto = attacchiDisponibiliAttaccante.get(numero);

            switch(attaccoScelto){
                case Attacchi.ATTACCO_BASE:
                    attaccante.attacca(avversario);
                    break;

                case Attacchi.ABILITA_SPECIALE:
                    switch (attaccante) {
                        case Masterizzatore masterizzatore -> masterizzatore.usaAbilitaSpeciale(partita);
                        case Sistemista sistemista -> sistemista.usaAbilitaSpeciale(avversario);
                        case Sniffer sniffer -> sniffer.usaAbilitaSpeciale(avversario);
                        case GroviglioCavi groviglioCavi -> groviglioCavi.usaAbilitaSpeciale(avversario);
                        case Ladro ladro -> ladro.usaAbilitaSpeciale(avversario);
                        default -> {
                        }
                    }
                    break;
            }
        }

        if(partita.getSaltaTurno())
            partita.setSaltaTurno(false);
        else
            partita.cambiaTurno();
    }
}
