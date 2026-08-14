package it.unicam.cs.mpgc.rpg130577.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Classe che si occupa 
 */
public class GiocoController{
    @FXML
    private BorderPane layout;

    @FXML
    private ImageView immagineAlleato;

    @FXML
    private Label hpAttualiAlleato;

    @FXML
    private Label hpTotaliAlleato;

    @FXML
    private ImageView immagineAvversario;

    @FXML
    private Label hpAttualiAvversario;

    @FXML
    private Label hpTotaliAvversario;

    /**
     * Imposta l'immagine di sfondo della finestra
     * @param sfondo Sfondo da impostare
     */
    public void impostaSfondo(Image sfondo){
        BackgroundImage bg = new BackgroundImage(
                sfondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        layout.setBackground(new Background(bg));
    }

    /**
     * Imposta l'immagine del personaggio alleato
     * @param immagine Immagine del personaggio alleato
     */
    public void setImmaginePersonaggioAlleato(Image immagine){
        immagineAlleato.setImage(immagine);
    }

    /**
     * Imposta il numero di hp attuali del personaggio alleato
     * @param valore Valore di hp attuali del personaggio alleato
     */
    public void setHpAttualiPersonaggioAlleato(int valore){
        hpAttualiAlleato.setText( String.valueOf(valore) );
    }

    /**
     * Imposta il numero di hp totali del personaggio alleato
     * @param valore Valore di hp totali del personaggio alleato
     */
    public void setHpTotaliPersonaggioAlleato(int valore){
        hpTotaliAlleato.setText( String.valueOf(valore) );
    }

    /**
     * Imposta l'immagine del personaggio avversario
     * @param immagine Immagine del personaggio avversario
     */
    public void setImmaginePersonaggioAvversario(Image immagine){
        immagineAvversario.setImage(immagine);
    }

    /**
     * Imposta il numero di hp attuali del personaggio avversario
     * @param valore Valore di hp attuali del personaggio avversario
     */
    public void setHpAttualiPersonaggioAvversario(int valore){
        hpAttualiAvversario.setText( String.valueOf(valore) );
    }

    /**
     * Imposta il numero di hp totali del personaggio avversario
     * @param valore Valore di hp totali del personaggio avversario
     */
    public void setHpTotaliPersonaggioAvversario(int valore){
        hpTotaliAvversario.setText( String.valueOf(valore) );
    }
}