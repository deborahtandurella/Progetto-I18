public class Answer {
    private Answer[] treeAnswer; //vettore di risposte che rappresentano il percorso svolto per arrivare a quella risposta
    private String operator;
    private String bodyAnswer;

    public Answer(/*Answer[] treeAnswer,*/ String operator, String bodyAnswer) {
        //this.treeAnswer = treeAnswer;
        this.operator = operator;
        this.bodyAnswer = bodyAnswer;
    }

    public Answer[] getTreeAnswer() {
        return treeAnswer;
    }
    public String getOperator() {
        return operator;
    }
    public String getBodyAnswer() {
        return bodyAnswer;
    }
}
//jfkdsfjsdkfsdk