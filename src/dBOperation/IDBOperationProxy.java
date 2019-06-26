package dBOperation;

import model.Operation;

import java.util.ArrayList;

/**
 * This interface contains all the available methods for the database operation
 */
public interface IDBOperationProxy {
    void addOperation(String numCalling, Operation operation);
    void removeOperation(String numCalling,String id,String number);
    Operation updateID(String numCalling,String oldID, String number,String newID);
    void updateText(String numCalling,Operation operation);
    ArrayList<Operation> getAvailableOptionToShow(String numCalling, String numCall, String numberSequence);

}
