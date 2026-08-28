package it.unicam.cs.mpgc.rpg130577.controller;

import it.unicam.cs.mpgc.rpg130577.componenti.Livello;
import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.FormattatoreAttacchi;
import it.unicam.cs.mpgc.rpg130577.utili.GestoreFinestre;
import it.unicam.cs.mpgc.rpg130577.utili.LoaderImmagini;
import it.unicam.cs.mpgc.rpg130577.utili.RiproduttoreMusicale;
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

    @FXML
    private BorderPane layout;

    @FXML
    private ImageView immagineAlleato;

    @FXML
    private Label hpAttualiAlleato;

    @FXML
    private Label hpMassimiAlleato;

    @FXML
    private Label attacchiDisponibiliAlleato;

    @FXML
    private ImageView immagineNemico;

    @FXML
    private Label hpAttualiNemico;

    @FXML
    private Label hpMassimiNemico;

    @FXML
    private Label attacchiDisponibiliNemico;

    /**
     * Inizializza la partita
     * @param alleato Personaggio alleato scelto
     */
    public void inizializzaPartita(Personaggio alleato){
        partita = new Partita(alleato);

        caricaPersonaggioAlleato();
        caricaLivello();
        caricaAttacchiPersonaggioAlleato();
    }

    // Shortcuts livelli
    /**
     * Carica nella GUI le informazioni sul livello attuale
     */
    private void caricaLivello(){
        Livello livelloAttuale = partita.getLivelloAttuale();

        aggiornaSfondo();

        String sottofondo = livelloAttuale.getAmbiente().getPercorsoSottofondo();
        RiproduttoreMusicale.stop();
        RiproduttoreMusicale.riproduci(sottofondo);

        caricaPersonaggioNemico();
    }

    /**
     * Carica l'immagine di sfondo del livello attuale
     * @return Immagine di sfondo del livello attuale
     */
    private Image ottieniSfondo(){
        return LoaderImmagini.carica(partita.getLivelloAttuale().getAmbiente().getPercorsoSfondo());
    }

    // Shortcuts alleato
    /**
     * Getter del personaggio alleato
     * @return Personaggio alleato
     */
    private Personaggio getAlleato(){
        return partita.getAlleato();
    }

    /**
     * Carica l'immagine del personaggio alleato
     */
    private void caricaImmagineAlleato(){
        Personaggio alleato = getAlleato();

        Image immagineAlleato = LoaderImmagini.carica(alleato.getPercorsoImmagine());
        setImmaginePersonaggioAlleato(immagineAlleato);
    }

    /**
     * Aggiorna gli HP del personaggio alleato
     */
    private void aggiornaHpAlleato(){
        Personaggio alleato = getAlleato();

        setHpAttualiPersonaggioAlleato( alleato.getHpAttuali() );
        setHpMassimiPersonaggioAlleato( alleato.getHpMassimi() );
    }

    /**
     * Carica le informazioni sul personaggio alleato nella GUI
     */
    private void caricaPersonaggioAlleato(){
        aggiornaHpAlleato();
        caricaImmagineAlleato();
    }

    // Shortcuts nemico
    /**
     * Getter del personaggio nemico
     * @return Personaggio nemico
     */
    private Personaggio getNemico(){
        return partita.getLivelloAttuale().getNemico();
    }

    /**
     * Aggiorna gli HP del personaggio nemico
     */
    private void aggiornaHpNemico(){
        Personaggio nemico = getNemico();

        setHpAttualiPersonaggioNemico( nemico.getHpAttuali() );
        setHpMassimiPersonaggioNemico( nemico.getHpMassimi() );
    }

    /**
     *
     */
    private void caricaImmagineNemico(){
        Personaggio avversario = getNemico();
        Image sfondoAvversario = LoaderImmagini.carica(avversario.getPercorsoImmagine());
        setImmaginePersonaggioNemico(sfondoAvversario);
    }

    /**
     * Carica le informazioni sul personaggio avversario nella GUI
     */
    private void caricaPersonaggioNemico(){
        aggiornaHpNemico();
        caricaImmagineNemico();
    }

    // Sfondo
    /**
     * Imposta lo sfondo del livello attuale sulla GUI
     */
    private void aggiornaSfondo(){
        Image sfondo = ottieniSfondo();

        BackgroundImage bg = new BackgroundImage(
                sfondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );

        layout.setBackground(new Background(bg));
    }

    // Personaggio alleato
    /**
     * Imposta l'immagine del personaggio alleato
     * @param immagine Immagine del personaggio alleato
     */
    private void setImmaginePersonaggioAlleato(Image immagine){
        immagineAlleato.setImage(immagine);
    }

    /**
     * Imposta il numero di hp attuali del personaggio alleato
     * @param valore HP attuali del personaggio alleato
     */
    private void setHpAttualiPersonaggioAlleato(int valore){
        hpAttualiAlleato.setText( String.valueOf(valore) );
    }

    /**
     * Imposta il numero di hp massimi del personaggio alleato
     * @param valore HP massimi personaggio alleato
     */
    private void setHpMassimiPersonaggioAlleato(int valore){
        hpMassimiAlleato.setText( String.valueOf(valore) );
    }

    /**
     * Imposta il testo delle opzioni di attacco disponibili per l'alleato
     * @param valore Opzioni di attacco per l'alleato
     */
    private void setAttacchiDisponibiliAlleato(String valore){
        attacchiDisponibiliAlleato.setText(valore);
    }

    /**
     * Carica nella GUI gli attacchi che possono essere compiuti dal personaggio alleato
     */
    private void caricaAttacchiPersonaggioAlleato(){
        List<Attacchi> attacchiDisponibili = getAlleato().ottieniAttacchiDisponibili();
        String testo = FormattatoreAttacchi.convertiAttacchiAElenco(attacchiDisponibili);
        setAttacchiDisponibiliAlleato(testo);
    }

    // Personaggio nemico
    /**
     * Imposta l'immagine del personaggio nemico
     * @param immagine Immagine del personaggio nemico
     */
    private void setImmaginePersonaggioNemico(Image immagine){
        immagineNemico.setImage(immagine);
    }

    /**
     * Imposta il numero di hp attuali del personaggio nemico
     * @param valore HP attuali personaggio nemico
     */
    private void setHpAttualiPersonaggioNemico(int valore){
        hpAttualiNemico.setText( String.valueOf(valore) );
    }

    /**
     * Imposta il numero di hp massimi del personaggio nemico
     * @param valore HP massimi personaggio nemico
     */
    private void setHpMassimiPersonaggioNemico(int valore){
        hpMassimiNemico.setText( String.valueOf(valore) );
    }

    // Eventi tastiera
    @FXML
    public void initialize() {
        layout.sceneProperty().addListener((obs, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.setOnKeyPressed(event -> {
                    KeyCode key = event.getCode();
                    gestisciTastoPremuto(key);
                });
            }
        });
    }

    /**
     * Gestisce l'evento quando si preme un tasto della tastiera, decidendo che azione intraprendere
     * @param key Tasto della tastiera
     */
    private void gestisciTastoPremuto(KeyCode key){
        if (key.isDigitKey()) {
            int numero = key.getName().charAt(0) - '0';
            partita.getGestoreTurni().effettuaTurno(numero);

            aggiornaHpAlleato();
            aggiornaHpNemico();

            if(partita.combattimentoTerminato()){
                EsitoController controller = GestoreFinestre.apriDaFXML("/fxml/esito.fxml", "Esito", false);
                controller.setLabelEsito( partita.getEsito() );
            }
            else if(partita.livelloTerminato())
                caricaLivello();

            if(partita.getGestoreTurni().isTurnoAlleato())
                caricaAttacchiPersonaggioAlleato();
        }
    }
}