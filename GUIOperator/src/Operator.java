public class Operator {
    private int numero;
    private String IDOperator=null;
    private String psw=null;


    public void setIDOperator(String IDOperator) {
        this.IDOperator = IDOperator;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getIDOperator() {
        return IDOperator;
    }

    public String getPsw() {
        return psw;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
