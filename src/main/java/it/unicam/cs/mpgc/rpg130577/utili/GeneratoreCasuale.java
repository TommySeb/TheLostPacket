package it.unicam.cs.mpgc.rpg130577.utili;

import java.util.Random;

/**
 * Classe statica che si occupa della generazione di numeri e booleani casuali
 */
public class GeneratoreCasuale {
    private static Random random = new Random();

    private GeneratoreCasuale() {

    }

    /**
     * Restituisce true con un n% di probabilità
     * @param percentuale Percentuale che venga restituito true
     * @return Risultato della probabilità
     */
    public static boolean probabilita(int percentuale){
        if(percentuale < 0 || percentuale > 100)
            throw new IllegalArgumentException("La percentuale passata deve essere compresa tra 0 e 100");

        int numeroCasuale = generaNumero(100);

        return numeroCasuale < percentuale;
    }

    /**
     * Genera un numero casuale tra 0 (incluso) e max (escluso)
     * @param max Numero massimo che può essere generato
     * @return un numero casuale tra 0 (incluso) e max (escluso)
     */
    public static int generaNumero(int max){
        if(max <= 0)
            throw new IllegalArgumentException("Il numero passato non può essere minore di 0");

        return random.nextInt(max);
    }
}
