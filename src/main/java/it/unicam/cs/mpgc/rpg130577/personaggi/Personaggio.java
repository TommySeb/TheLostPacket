package it.unicam.cs.mpgc.rpg130577.personaggi;

/**
 * Classe base per tutti i personaggi del gioco
 */
public abstract class Personaggio implements Player {
    protected int hpMassimi;
    protected int hpAttuali;
    protected int puntiAttacco;
    protected int attacchiEffettuati;   // Indica gli attacchi effettuati dall'ultimo uso dell'abilità speciale del personaggio

    public Personaggio(){
    }
}
