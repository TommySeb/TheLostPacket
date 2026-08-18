package it.unicam.cs.mpgc.rpg130577.utili;

import java.util.List;
import it.unicam.cs.mpgc.rpg130577.componenti.Livello;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Ambienti;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.personaggi.nemici.GroviglioCavi;
import it.unicam.cs.mpgc.rpg130577.personaggi.nemici.Ladro;
import it.unicam.cs.mpgc.rpg130577.personaggi.nemici.Nefario;
import it.unicam.cs.mpgc.rpg130577.personaggi.nemici.Switch;

public class GeneratoreLivelli {
    public static Livello generaLivello1(){
        Personaggio professore = new Nefario();
        Ambienti laboratorio = Ambienti.LABORATORIO_SISTEMI;

        return new Livello(professore, laboratorio);
    }

    public static Livello generaLivello2(){
        Personaggio switchRete = new Switch();
        Ambienti armadietto = Ambienti.ARMADIETTO_RETE;

        return new Livello(switchRete, armadietto);
    }

    public static Livello generaLivello3(){
        Personaggio groviglio = new GroviglioCavi();
        Ambienti tunnel = Ambienti.TUNNEL_CAVI;

        return new Livello(groviglio, tunnel);
    }

    public static Livello generaLivello4(){
        Personaggio ladro = new Ladro();
        Ambienti bunker = Ambienti.BUNKER_SEGRETO;

        return new Livello(ladro, bunker);
    }
}
