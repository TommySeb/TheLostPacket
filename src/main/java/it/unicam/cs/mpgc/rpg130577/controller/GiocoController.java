package it.unicam.cs.mpgc.rpg130577.controller;

import it.unicam.cs.mpgc.rpg130577.componenti.Livello;
import it.unicam.cs.mpgc.rpg130577.componenti.Partita;
import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;
import it.unicam.cs.mpgc.rpg130577.personaggi.Personaggio;
import it.unicam.cs.mpgc.rpg130577.utili.GestoreCombattimento;
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
    private ImageView immagineAvversario;

    @FXML
    private Label hpAttualiAvversario;

    @FXML
    private Label hpMassimiAvversario;

    @FXML
    private Label attacchiDisponibiliAvversario;

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
            partita.effettuaTurno(numero);

            aggiornaHpAlleato();
            aggiornaHpAvversario();

            if(partita.combattimentoTerminato()){
                EsitoController controller = GestoreFinestre.apriDaFXML("/fxml/esito.fxml", "Esito", false);
                controller.setLabelEsito( partita.getEsito() );
            }
            else if(partita.livelloTerminato()){
                caricaLivello();
                caricaAttacchi();
            }
        }
    }

    /**
     * Inizializza la partita
     * @param alleato Personaggio alleato scelto
     */
    public void inizializzaPartita(Personaggio alleato){
        partita = new Partita(alleato);
        partita.setCombattimento(new GestoreCombattimento(partita));

        caricaPersonaggioAlleato();
        caricaLivello();
        caricaAttacchi();
    }

    /**
     * Carica le informaazioni sul personaggio alleato nella GUI
     */
    private void caricaPersonaggioAlleato(){
        aggiornaHpAlleato();
        caricaImmagineAlleato();
    }

    private void aggiornaHpAlleato(){
        Personaggio alleato = getAlleato();

        setHpAttualiPersonaggioAlleato(alleato.getHpAttuali());
        setHpMassimiPersonaggioAlleato(alleato.getHpMassimi());
    }

    private void caricaImmagineAlleato(){
        Personaggio alleato = getAlleato();

        Image immagineAlleato = LoaderImmagini.carica(alleato.getPercorsoImmagine());
        setImmaginePersonaggioAlleato(immagineAlleato);
    }

    /**
     * Carica le informazioni sul personaggio avversario nella GUI
     */
    public void caricaPersonaggioAvversario(){
        aggiornaHpAvversario();
        caricaImmagineAvversario();
    }

    private void aggiornaHpAvversario(){
        Personaggio avversario = getAvversario();

        setHpAttualiPersonaggioAvversario(avversario.getHpAttuali());
        setHpMassimiPersonaggioAvversario(avversario.getHpMassimi());
    }

    private void caricaImmagineAvversario(){
        Personaggio avversario = getAvversario();

        Image sfondoAvversario = LoaderImmagini.carica(avversario.getPercorsoImmagine());
        setImmaginePersonaggioAvversario(sfondoAvversario);
    }

    /**
     * Carica nella GUI gli attacchi del personaggio alleato, se di turno
     */
    private void caricaAttacchi(){
        if(partita.isTurnoAlleato()){
            resetAttacchiPersonaggioAvversario();
            caricaAttacchiPersonaggioAlleato();
        }
    }

    /**
     * Carica nella GUI gli attacchi che possono essere compiuti dal personaggio alleato
     */
    private void caricaAttacchiPersonaggioAlleato(){
        List<Attacchi> attacchiDisponibili = getAlleato().ottieniAttacchiDisponibili();
        String testo = formattaAttacchi(attacchiDisponibili);
        setAttacchiDisponibiliAlleato(testo);
    }

    /**
     * Converte una lista di attacchi in una stringa da poter stampare nella GUI
     * @return
     */
    private String formattaAttacchi(List<Attacchi> attacchi){
        StringBuilder testo = new StringBuilder();

        for(int i = 0; i < attacchi.size(); i++){
            String preambolo = i + " - ";
            testo.append(preambolo);
            testo.append(attacchi.get(i).getDescrizione());
            testo.append("\n");
        }

        return testo.toString();
    }

    /**
     * Carica nella GUI le informazioni sul livello attuale
     */
    private void caricaLivello(){
        Livello livelloAttuale = partita.getLivelloAttuale();

        Image sfondo = LoaderImmagini.carica(livelloAttuale.getAmbiente().getPercorsoSfondo());
        impostaSfondo(sfondo);

        String sottofondo = livelloAttuale.getAmbiente().getPercorsoSottofondo();
        RiproduttoreMusicale.stop();
        RiproduttoreMusicale.riproduci(sottofondo);

        Personaggio avversario = livelloAttuale.getAvversario();
        caricaPersonaggioAvversario();
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
     * Imposta il testo delle opzioni di attacco disponibili per l'alleato
     * @param valore Opzioni di attacco per l'alleato
     */
    public void setAttacchiDisponibiliAlleato(String valore){
        attacchiDisponibiliAlleato.setText(valore);
    }

    /**
     * Elimina dalla GUI le opzioni di attacco disponibili per l'alleato
     */
    private void resetAttacchiPersonaggioAlleato(){
        attacchiDisponibiliAlleato.setText("");
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

    /**
     * Imposta il testo delle opzioni di attacco disponibili per l'avversario
     * @param valore Opzioni di attacco per l'avversario
     */
    public void setAttacchiDisponibiliAvversario(String valore){
        attacchiDisponibiliAvversario.setText(valore);
    }

    /**
     * Elimina dalla GUI le opzioni di attacco disponibili per l'avversario
     */
    private void resetAttacchiPersonaggioAvversario(){
        attacchiDisponibiliAvversario.setText("");
    }
}