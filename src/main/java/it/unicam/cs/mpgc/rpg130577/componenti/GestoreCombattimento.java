package it.unicam.cs.mpgc.rpg130577.componenti;

import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

import java.util.List;

public class GestoreCombattimento {
    /**
     * Costruttore
     */
    public GestoreCombattimento() {

    }

    /**
     * Esegue un attacco verso un personaggio specificato
     * @param attaccante Personaggio attaccante
     * @param numero Numero di attacco scelto dal personaggio attaccante
     * @param avversario Personaggio avversario
     */
    public void eseguiAttacco(Personaggio attaccante, int numero, Personaggio avversario){
        List<Attacchi> attacchiDisponibiliAttaccante = attaccante.ottieniAttacchiDisponibili();

        if(numero >= 0 && numero < attacchiDisponibiliAttaccante.size()){
            Attacchi attaccoScelto = attacchiDisponibiliAttaccante.get(numero);

            switch(attaccoScelto){
                case Attacchi.ATTACCO_BASE:
                    attaccante.attacca(avversario);
                    break;

                case Attacchi.ABILITA_SPECIALE:
                    attaccante.usaAbilitaSpeciale(avversario);
                    break;
            }
        }
    }
}
