package it.unicam.cs.mpgc.rpg130577.utili;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

/**
 * Classe che si occupa della riproduzione di risorse audio
 */
public class RiproduttoreMusicale {
    private static MediaPlayer riproduttore;

    /**
     * Riproduce la traccia audio specificata
     * @param percorso Percorso della risorsa audio
     */
    public static void riproduci(String percorso){
        String url = RiproduttoreMusicale.class.getResource(percorso).toExternalForm();

        Media traccia = new Media(url);

        riproduttore = new MediaPlayer(traccia);
        riproduttore.setCycleCount(MediaPlayer.INDEFINITE);
        riproduttore.play();
    }

    /**
     * Se in riproduzione, stoppa e rilascia la traccia audio attiva
     */
    public static void stop(){
        if(riproduttore != null){
            riproduttore.stop();
            riproduttore.dispose();
        }
    }
}
