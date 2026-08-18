package it.unicam.cs.mpgc.rpg130577.componenti;

import it.unicam.cs.mpgc.rpg130577.enumerazione.Ambienti;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;

public class Livello {
    Personaggio avversario;
    Ambienti ambiente;

    public Livello(Personaggio avversario, Ambienti ambiente){
        this.avversario = avversario;
        this.ambiente = ambiente;
    }

    public Personaggio getAvversario(){
        return avversario;
    }

    public Ambienti getAmbiente(){
        return ambiente;
    }
}
