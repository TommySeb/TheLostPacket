package it.unicam.cs.mpgc.rpg130577.controller;

import it.unicam.cs.mpgc.rpg130577.componenti.Livello;
import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.GestoreCombattimento;
import it.unicam.cs.mpgc.rpg130577.utili.LoaderImmagini;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

import java.util.List;

/**
 * Classe controller della gui della finestra di gioco
 */
public class GiocoController{
    Partita partita;
    GestoreCombattimento combattimento;

    @FXML
    private BorderPane layout;

    @FXML
    private ImageView immagineAlleato;

    @FXML
    private Label hpAttualiAlleato;

    @FXML
    private Label hpMassimiAlleato;

    @FXML
    private Label mosseAlleato;

    @FXML
    private ImageView immagineAvversario;

    @FXML
    private Label hpAttualiAvversario;

    @FXML
    private Label hpMassimiAvversario;

    @FXML
    private Label mosseAvversario;

    @FXML
    public void initialize() {
        layout.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(event -> {
                    KeyCode key = event.getCode();

                    if (key.isDigitKey()) {
                        int numero = key.getName().charAt(0) - '0';
                        combattimento.eseguiAttacco(numero);


                        aggiornaHpAlleato( getAlleato() );
                        aggiornaHpAvversario( getAvversario() );
                    }
                });
            }
        });
    }

    /**
     * Inizializza la partita
     * @param alleato Personaggio alleato scelto
     */
    public void inizializzaPartita(Personaggio alleato){
        partita = new Partita(alleato);
        combattimento = new GestoreCombattimento(partita);

        caricaPersonaggioAlleato(alleato);
        caricaProssimoLivello();

        caricaAttacchiPersonaggioAlleato();
    }

    /**
     * Carica le informaazioni sul personaggio alleato nella GUI
     * @param alleato Alleato da caricare
     */
    private void caricaPersonaggioAlleato(Personaggio alleato){
        aggiornaHpAlleato(alleato);

        Image sfondoAlleato = LoaderImmagini.carica(alleato.getPercorsoImmagine());
        setImmaginePersonaggioAlleato(sfondoAlleato);
    }

    private void aggiornaHpAlleato(Personaggio alleato){
        setHpAttualiPersonaggioAlleato(alleato.getHpAttuali());
        setHpMassimiPersonaggioAlleato(alleato.getHpMassimi());
    }

    /**
     * Carica le informazioni sul personaggio avversario nella GUI
     * @param avversario Avversario da caricare
     */
    public void caricaPersonaggioAvversario(Personaggio avversario){
        aggiornaHpAvversario(avversario);

        Image sfondoAvversario = LoaderImmagini.carica(avversario.getPercorsoImmagine());
        setImmaginePersonaggioAvversario(sfondoAvversario);
    }

    private void aggiornaHpAvversario(Personaggio avversario){
        setHpAttualiPersonaggioAvversario(avversario.getHpAttuali());
        setHpMassimiPersonaggioAvversario(avversario.getHpMassimi());
    }

    /**
     * Carica gli attacchi che possono essere compiuti dal personaggio alleato
     */
    public void caricaAttacchiPersonaggioAlleato(){
        List<Attacchi> attacchiDisponibili = partita.getAlleato().ottieniAttacchiDisponibili();
        String testo = formattaAttacchi(attacchiDisponibili);
        mosseAlleato.setText(testo);
    }

    /**
     * Carica gli attacchi che possono essere compiuti dal personaggio avversario
     */
    public void caricaAttacchiPersonaggioAvversario(){
        List<Attacchi> attacchiDisponibili = partita.getLivelloAttuale().getAvversario().ottieniAttacchiDisponibili();
        String testo = formattaAttacchi(attacchiDisponibili);
        mosseAvversario.setText(testo);
    }

    /**
     * Converte una lista di attacchi in una stringa da poter stampare nella GUI
     * @return
     */
    private String formattaAttacchi(List<Attacchi> attacchi){
        StringBuilder testo = new StringBuilder();

        for(int i = 0; i < attacchi.size(); i++){
            String preambolo = i + " - ";
            testo.append(preambolo).append(attacchi.get(i).getDescrizione());
        }

        return testo.toString();
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

    private Personaggio getAlleato(){
        return partita.getAlleato();
    }

    private Personaggio getAvversario(){
        return partita.getLivelloAttuale().getAvversario();
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