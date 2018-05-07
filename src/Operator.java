import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

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

    //metodo per aggiungere un nuovo oggetto Answer
    public boolean addAnswer(String inputAnswer){
        if (inputAnswer != null) {
            Answer newAnswer = new Answer(this.commercialName, inputAnswer);
            return true;
        }
        else return false;
    }

    //metodo per aggiungere una nuova list da stringa
    public boolean addList (String answers){
        if(answers != null){
            ArrayList<Answer> a = new ArrayList();
            StringTokenizer singleAnswer = new StringTokenizer(answers, "\n");
            while(singleAnswer.hasMoreTokens()){
                Answer x = new Answer(this.commercialName, singleAnswer.nextToken());
                a.add(x);
            }
            Lista newLista = new Lista(a);
            return true;
        }
        return false;
    }



}
