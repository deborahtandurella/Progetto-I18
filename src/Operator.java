public class Operator {
    //a questi attributi possiamo inserirne altri successivamente, in base alle necessità
    private String pIva;
    private String commercialName;
    private String address;

    public Operator(String pIva, String commercialName, String address) {
        this.pIva = pIva;
        this.commercialName = commercialName;
        this.address = address;
    }

    public String getpIva() {
        return pIva;
    }
    public String getCommercialName() {
        return commercialName;
    }
    public String getAddress() {
        return address;
    }
}
