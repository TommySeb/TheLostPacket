package it.unicam.cs.mpgc.rpg130577.ambienti.gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;


/**
 * Classe contenente l'interfaccia grafica degli ambienti di gioco
 */
public class AmbienteGUI extends Application{
    // Finestra generale
    private Stage stage;
    private BorderPane layout;
    private Scene scene;
    private ImageView sfondo;

    // Componenti panel personaggio alleato
    ImageView immaginePersonaggioAlleato;
    Label hpAttualiPersonaggioAlleato;
    Label hpTotaliPersonaggioAlleato;
    Label opzioniAttaccoAlleato;

    // Componenti personaggio nemico
    ImageView immaginePersonaggioNemico;
    Label hpAttualiPersonaggioNemico;
    Label hpTotaliPersonaggioNemico;
    Label opzioniAttaccoNemico;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
    }

    /**
     * Crea un layout (BorderPane) e ci inserisce dentro i componenti necessari
     */
    public void inizializzaLayout(){
        layout = new BorderPane();

        VBox alleato = creaPannelloPersonaggio(immaginePersonaggioAlleato, hpAttualiPersonaggioAlleato, hpTotaliPersonaggioAlleato, opzioniAttaccoAlleato);
        layout.setLeft(alleato);

        VBox nemico = creaPannelloPersonaggio(immaginePersonaggioNemico, hpAttualiPersonaggioNemico, hpTotaliPersonaggioNemico, opzioniAttaccoNemico);
        layout.setRight(nemico);
    }

    /**
     * Crea un pannello con i controlli grafici di un personaggio
     * @param immagine ImageView dell'immagine del personaggio
     * @param hpAttuali Label degli hp attuali del personaggio
     * @param hpTotali Label degli hp totali del personaggio
     * @param opzioni Label delle opzioni del personaggio
     * @return Pannello con i controlli grafici passati
     */
    private VBox creaPannelloPersonaggio(ImageView immagine, Label hpAttuali, Label hpTotali, Label opzioni) {
        VBox panel = new VBox();
        panel.getChildren().addAll(immagine, hpAttuali, hpTotali, opzioni);
        return panel;
    }

    /**
     * Inizializza la finestra e il layout
     * @param nome Titolo della finestra
     * @param lunghezza Lunghezza della finestra
     * @param altezza Altezza della finestra
     */
    public void inizializzaFinestra(String nome, int lunghezza, int altezza){
        inizializzaLayout();
        impostaNomeFinestra(nome);
        scene = new Scene(layout, lunghezza, altezza);
        stage.setScene(scene);
    }

    /**
     * Imposta il titolo della finestra
     * @param titolo Titolo della finestra
     */
    public void impostaNomeFinestra(String titolo){
        stage.setTitle(titolo);
    }

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
     * Mostra la finestra
     */
    public void mostraFinestra(){
        stage.show();
    }

    /**
     * Chiude la finestra
     */
    public void chiudiFinestra(){
        stage.close();
    }

    /**
     * Imposta l'immagine del personaggio alleato
     * @param immagine Immagine del personaggio alleato
     */
    public void setImmaginePersonaggioAlleato(Image immagine){
        immaginePersonaggioAlleato.setImage(immagine);
    }

    /**
     * Imposta il numero di hp attuali del personaggio alleato
     * @param valore Valore di hp attuali del personaggio alleato
     */
    public void setHpAttualiPersonaggioAlleato(int valore){
        hpAttualiPersonaggioAlleato.setText( String.valueOf(valore) );
    }

    /**
     * Imposta il numero di hp totali del personaggio alleato
     * @param valore Valore di hp totali del personaggio alleato
     */
    public void setHpTotaliPersonaggioAlleato(int valore){
        hpTotaliPersonaggioAlleato.setText( String.valueOf(valore) );
    }

    /**
     * Imposta l'immagine del personaggio nemico
     * @param immagine Immagine del personaggio nemico
     */
    public void setImmaginePersonaggioNemico(Image immagine){
        immaginePersonaggioNemico.setImage(immagine);
    }

    /**
     * Imposta il numero di hp attuali del personaggio nemico
     * @param valore Valore di hp attuali del personaggio nemico
     */
    public void setHpAttualiPersonaggioNemico(int valore){
        hpAttualiPersonaggioNemico.setText( String.valueOf(valore) );
    }

    /**
     * Imposta il numero di hp totali del personaggio nemico
     * @param valore Valore di hp totali del personaggio nemico
     */
    public void setHpTotaliPersonaggioNemico(int valore){
        hpTotaliPersonaggioNemico.setText( String.valueOf(valore) );
    }
}
