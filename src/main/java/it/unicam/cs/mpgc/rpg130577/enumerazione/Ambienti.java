package it.unicam.cs.mpgc.rpg130577.enumerazione;

/**
 * Classe enumeratore che associa gli ambienti ai relativi percorsi
 */
public enum Ambienti {
    LABORATORIO_SISTEMI("/sfondi/laboratorioSistemi.jpg", "/sottofondi/laboratorioSistemi.mp3"),
    ARMADIETTO_RETE("/sfondi/armadiettoRete.jpg", "/sottofondi/armadiettoRete.mp3"),
    TUNNEL_CAVI("/sfondi/tunnelCavi.jpg", "/sottofondi/tunnelCavi.mp3"),
    BUNKER_SEGRETO("/sfondi/bunkerSegreto.jpg", "/sottofondi/bunkerSegreto.mp3");

    private final String percorsoSfondo;
    private final String percorsoSottofondo;

    Ambienti(String percorsoSfondo, String percorsoSottofondo) {
        this.percorsoSfondo = percorsoSfondo;
        this.percorsoSottofondo = percorsoSottofondo;
    }

    public String getPercorsoSfondo() {
        return percorsoSfondo;
    }

    public String getPercorsoSottofondo(){
        return percorsoSottofondo;
    }
}
