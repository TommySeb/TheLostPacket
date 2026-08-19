package it.unicam.cs.mpgc.rpg130577.enumerazione;

public enum Attacchi {
    ATTACCO_BASE("Effettua un attacco base"),
    ABILITA_SPECIALE("Usa l'abilità speciale del personaggio");

    private final String descrizione;

    Attacchi(String descrizione){
        this.descrizione = descrizione;
    }

    public String getDescrizione(){
        return descrizione;
    }
}
