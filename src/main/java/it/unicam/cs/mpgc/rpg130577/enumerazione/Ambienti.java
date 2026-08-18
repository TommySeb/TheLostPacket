package it.unicam.cs.mpgc.rpg130577.enumerazione;

/**
 * Classe enumeratore che associa gli ambienti ai relativi percorsi
 */
public enum Ambienti {
    LABORATORIO_SISTEMI("sfondi/laboratorioSistemi.jpg"),
    ARMADIETTO_RETE("sfondi/armadiettoRete.jpg"),
    TUNNEL_CAVI("sfondi/tunnelCavi.jpg"),
    BUNKER_SEGRETO("sfondi/bunkerSegreto.jpg");

    private final String percorsoSfondo;

    Ambienti(String percorsoSfondo) {
        this.percorsoSfondo = percorsoSfondo;
    }

    public String getPercorsoSfondo() {
        return percorsoSfondo;
    }
}
