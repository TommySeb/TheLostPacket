package it.unicam.cs.mpgc.rpg130577.personaggi;

/**
 * Classe base per tutti i personaggi del gioco
 */
public abstract class Personaggio implements Player {
    protected String pathImmagine;
    protected int hpMassimi;
    protected int hpAttuali;
    protected int puntiAttacco;
    protected int attacchiEffettuati;   // Indica gli attacchi effettuati dall'ultimo uso dell'abilità speciale del personaggio

    public Personaggio(){
        inizializzaNumeroAttacchi();
    }

    @Override
    public void attacca(Personaggio avversario){
        avversario.subisciAttacco(this.puntiAttacco);
        registraAttacco();
    }

    @Override
    public void subisciAttacco(int hp) {
        this.hpAttuali -= hp;
    }

    @Override
    public void registraAttacco() {
        this.attacchiEffettuati++;
    }

    @Override
    public void inizializzaNumeroAttacchi() {
        this.attacchiEffettuati = 0;
    }

    /**
     * Restituisce gli health points attuali del personaggio
     * @return Health points attuali del personaggio
     */
    public int getHpAttuali(){
        return this.hpAttuali;
    }

    /**
     * Restituisce gli health points massimi del personaggio
     * @return Health points massimi del personaggio
     */
    public int getHpMassimi(){
        return this.hpMassimi;
    }

    /**
     * Restituisce il percorso dell'immagine del personaggio
     * @return Percorso dell'immagine del personaggio
     */
    public String getPercorsoImmagine(){
        return this.pathImmagine;
    }
}
