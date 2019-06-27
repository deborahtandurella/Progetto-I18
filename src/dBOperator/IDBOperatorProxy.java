package dBOperator;

import model.Operator;

public interface IDBOperatorProxy {
    Operator addOperatorToDatabase(String numCalling, Operator operator);
    void removeOperator(String numCalling, String number, String username);
    Operator updatePassword(String numCalling, Operator operator);
    Operator updateUsername(String numCalling, String number, String oldUsername, String newUsername);
    Operator findOperator(String numCalling, String number,String username);
    void logged(String numCalling, Operator operator);

}
