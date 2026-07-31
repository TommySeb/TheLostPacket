package it.unicam.cs.mpgc.rpg130577.personaggi.utili;

import com.sun.javafx.iio.ImageLoader;
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
     */
    public static Image carica(String percorso) {
        InputStream stream = ImageLoader.class.getResourceAsStream(percorso);

        if (stream == null)
            throw new IllegalArgumentException("Risorsa non trovata");

        return new Image(stream);
    }
}
