package it.unicam.cs.mpgc.rpg130577.utili;

import it.unicam.cs.mpgc.rpg130577.enumerazione.Attacchi;

import java.util.List;

/**
 * Classe che si occupa di formattare le opzioni di attacco in stringa
 */
public class FormattatoreAttacchi {
    /**
     * Converte una lista di attacchi in un elenco numerato
     * @return Stringa contenente le opzioni di attacco numerate
     */
    public static String convertiAttacchiAElenco(List<Attacchi> attacchi){
        StringBuilder testo = new StringBuilder();

        for(int i = 0; i < attacchi.size(); i++){
            String preambolo = i + " - ";
            testo.append(preambolo);
            testo.append(attacchi.get(i).getDescrizione());
            testo.append("\n");
        }

        return testo.toString();
    }
}
