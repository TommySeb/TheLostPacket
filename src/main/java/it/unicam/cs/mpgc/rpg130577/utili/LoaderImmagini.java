package it.unicam.cs.mpgc.rpg130577.utili;

import javafx.scene.image.Image;
import java.io.InputStream;

/**
 * Classe statica che si occupa del caricamento delle immagini dalle risorse di progetto
 */
public class LoaderImmagini {
    private LoaderImmagini() {

    }

    /**
     * Carica un'immagine dalle risorse di progetto
     * @param percorso Percorso della risorsa
     * @return Immagine corrispondente
     * @throws IllegalArgumentException Se l'immagine richiesta non esiste
     */
    public static Image carica(String percorso) {
        // Conversione del percorso in uno compatibile con lo stream
        percorso = percorso.replaceFirst("^/", "");

        InputStream stream = ClassLoader.getSystemResourceAsStream(percorso);

        if(stream == null)
            throw new IllegalArgumentException("L'immagine richiesta è inesistente.");
        else
            return new Image(stream);
    }
}
