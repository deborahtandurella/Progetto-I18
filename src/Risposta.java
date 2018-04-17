public class Risposta {
    private Risposta discendenza[]; //vettore di risposte che rappresentano il percorso svolto per arrivare a quella risposta
    private String operatore;
    private String testo;

    public Risposta(String operatore, String testo) {
        this.operatore = operatore;
        this.testo = testo;
    }

    public Risposta[] getDiscendenza() {
        return discendenza;
    }

    public String getOperatore() {
        return operatore;
    }

    public String getTesto() {
        return testo;
    }
}
