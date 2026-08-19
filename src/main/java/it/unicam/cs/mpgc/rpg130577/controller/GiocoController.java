package it.unicam.cs.mpgc.rpg130577.controller;

import it.unicam.cs.mpgc.rpg130577.componenti.Livello;
import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.LoaderImmagini;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * Classe controller della gui della finestra di gioco
 */
public class GiocoController{
    Partita partita;

    @FXML
    private BorderPane layout;

    @FXML
    private ImageView immagineAlleato;

    @FXML
    private Label hpAttualiAlleato;

    @FXML
    private Label hpMassimiAlleato;

    @FXML
    private ImageView immagineAvversario;

    @FXML
    private Label hpAttualiAvversario;

    @FXML
    private Label hpMassimiAvversario;

    /**
     * Inizializza la partita
     * @param alleato Personaggio alleato scelto
     */
    public void inizializzaPartita(Personaggio alleato){
        partita = new Partita(alleato);
        caricaPersonaggioAlleato(alleato);
        caricaProssimoLivello();
    }

    /**
     * Carica le informaazioni sul personaggio alleato nella GUI
     * @param alleato Alleato da caricare
     */
    private void caricaPersonaggioAlleato(Personaggio alleato){
        setHpAttualiPersonaggioAlleato(alleato.getHpAttuali());
        setHpMassimiPersonaggioAlleato(alleato.getHpMassimi());

        Image sfondoAlleato = LoaderImmagini.carica(alleato.getPercorsoImmagine());
        setImmaginePersonaggioAlleato(sfondoAlleato);
    }

    /**
     * Carica le informazioni sul personaggio avversario nella GUI
     * @param avversario Avversario da caricare
     */
    public void caricaPersonaggioAvversario(Personaggio avversario){
        setHpAttualiPersonaggioAvversario(avversario.getHpAttuali());
        setHpMassimiPersonaggioAvversario(avversario.getHpMassimi());

        Image sfondoAvversario = LoaderImmagini.carica(avversario.getPercorsoImmagine());
        setImmaginePersonaggioAvversario(sfondoAvversario);
    }

    /**
     * Ottiene le informazioni sul prossimo livello e le carica nella GUI
     */
    private void caricaProssimoLivello(){
        Livello prossimoLivello = partita.prossimoLivello();

        Image sfondo = LoaderImmagini.carica(prossimoLivello.getAmbiente().getPercorsoSfondo());
        impostaSfondo(sfondo);

        Personaggio avversario = prossimoLivello.getAvversario();
        caricaPersonaggioAvversario(avversario);
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
     * Imposta il numero di hp massimi del personaggio alleato
     * @param valore Valore di hp Massimi del personaggio alleato
     */
    public void setHpMassimiPersonaggioAlleato(int valore){
        hpMassimiAlleato.setText( String.valueOf(valore) );
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
     * Imposta il numero di hp massimi del personaggio avversario
     * @param valore Valore di hp Massimi del personaggio avversario
     */
    public void setHpMassimiPersonaggioAvversario(int valore){
        hpMassimiAvversario.setText( String.valueOf(valore) );
    }
}