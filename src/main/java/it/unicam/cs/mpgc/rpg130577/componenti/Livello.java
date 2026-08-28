package it.unicam.cs.mpgc.rpg130577.componenti;

import it.unicam.cs.mpgc.rpg130577.enumerazione.Ambienti;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

/**
 * Classe che rappresenta un livello del gioco
 */
public class Livello {
    private final Personaggio nemico;
    private final Ambienti ambiente;

    /**
     * Costruttore
     * @param nemico Personaggio nemico associato al livello
     * @param ambiente Ambiente associato al livello
     */
    public Livello(Personaggio nemico, Ambienti ambiente){
        this.nemico = nemico;
        this.ambiente = ambiente;
    }

    /**
     * Getter del personaggio nemico associato al livello
     * @return Personaggio nemico associato al livello
     */
    public Personaggio getNemico(){
        return nemico;
    }

    /**
     * Getter dell'ambiente associato al livello
     * @return Ambiente associato al livello
     */
    public Ambienti getAmbiente(){
        return ambiente;
    }
}
