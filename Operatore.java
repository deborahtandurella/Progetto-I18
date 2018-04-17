public class Operatore {
    //a questi attributi possiamo inserirne altri successivamente, in base alle necessità
    private String pIva;
    private String nomeCommerciale;
    private String indirizzo;

    public Operatore(String pIva, String nomeCommerciale, String indirizzo) {
        this.pIva = pIva;
        this.nomeCommerciale = nomeCommerciale;
        this.indirizzo = indirizzo;
    }

    public String getpIva() {
        return pIva;
    }

    public String getNomeCommerciale() {
        return nomeCommerciale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
}
