package clientServer;

import dBOperation.DBOperationDAO;
import dBOperator.DBOperatorDAO;
import dataHistory.DataWriterServer;
import model.Operation;
import model.Operator;

import java.util.ArrayList;

public class Server implements IServerProxy {
    // variables
    private DBOperatorDAO operatorDAO;
    private DBOperationDAO operationDAO;
    // messages
    private final String ADDOPERATIONREQUEST = "received addOperation request";
    private final String ADDOPERATORREQUEST = "received addAndRetrieveOperator request";
    private final String RETRIEVEOPERATIONREQUEST = "received retrieveJustTheRightOption request";
    private final String CHANGEUSERNAMEREQUEST = "received changeUsername request";
    private final String CHANGEPASSWORDREQUEST = "received changePassword request";
    private final String REMOVEOPERATIONREQUEST = "received removeOperation request";
    private final String CHANGEIDREQUEST = "received changeID request";
    private final String CHANGETEXTREQUEST= "received changeText request";
    private final String REMOVEOPERATORREQUEST= "received removeOperator request";
    private final String FINDOPERATORREQUEST = "received findOperator request ";
    private final String LOGINREQUEST = "received request to login";
    private final String LOGOUTREQUEST = "received request to logout";

    public Server() {
        operatorDAO = DBOperatorDAO.getInstance();
        operationDAO = DBOperationDAO.getInstance();
    }

    /**
     * This method is used to add a new operator
     * @param messageServer
     */
    public synchronized void addOperation(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), ADDOPERATIONREQUEST);
        operationDAO.addOperation(messageServer.getNumCalling(), messageServer.getOperation());
    }

    /**
     * This method is used to return only the available choices to show when an user is calling a number
     * @param messageServer
     * @return the available operations
     */
    public ArrayList<Operation> retrieveJustTheRightOption(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), RETRIEVEOPERATIONREQUEST);
        ArrayList<Operation> operations = operationDAO.getAvailableOptionToShow(messageServer.getNumCalling(), messageServer.getNumber(), messageServer.getNumSequence());
        return operations;
    }

    /**
     * This method add a new operator and returns it
     * @param messageServer
     * @return
     */
    public synchronized Operator addAndRetrieveOperator(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), ADDOPERATORREQUEST);
        Operator newOperator = operatorDAO.addOperatorToDatabase(messageServer.getNumCalling(), messageServer.getOperator());
        return newOperator;
    }

    /**
     * This method is used to change the username af an operator
     * @param messageServer
     */
    public synchronized Operator changeUsername(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), CHANGEUSERNAMEREQUEST);
        Operator updatedOperator = operatorDAO.updateUsername(messageServer.getNumCalling(), messageServer.getId(), messageServer.getNumber(), messageServer.getText());
        return updatedOperator;
    }

    /**
     * This method is used to change the password of an operator
     * @param messageServer
     */
    public synchronized Operator changePassword(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), CHANGEPASSWORDREQUEST);
        Operator updatedOperator = operatorDAO.updatePassword(messageServer.getNumCalling(), messageServer.getOperator());
        return updatedOperator;
    }

    /**
     * This method is used to delete an operation
     * @param messageServer
     */
    public synchronized void removeOperation(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), REMOVEOPERATIONREQUEST);
        operationDAO.removeOperation(messageServer.getNumCalling(), messageServer.getNumber(), messageServer.getNumSequence());
    }

    /**
     * This method is used to change the id of an operation
     * @param messageServer
     */
    public synchronized Operation changeID(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), CHANGEIDREQUEST);
        Operation operationUpdated = operationDAO.updateID(messageServer.getNumCalling(), messageServer.getId(), messageServer.getNumber(), messageServer.getText());
        return operationUpdated;
    }

    /**
     * This method is used to change the text of an operation
     * @param messageServer
     */
    public synchronized void changeText(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), CHANGETEXTREQUEST);
        operationDAO.updateText(messageServer.getNumCalling(), messageServer.getOperation());
    }

    /**
     * This method is used to delete the current account logged in
     * @param messageServer
     */
    public synchronized void removeOperator(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), REMOVEOPERATORREQUEST);
        operatorDAO.removeOperator(messageServer.getNumCalling(), messageServer.getNumber(), messageServer.getNumSequence());
    }

    /**
     * This method is used to retreive a defined operator
     * @param messageServer
     * @return
     */
    public Operator findOperator(MessageServer messageServer) {
        logOperation(new DataWriterServer(messageServer.getNumCalling()), FINDOPERATORREQUEST);
        Operator operator = operatorDAO.findOperator(messageServer.getNumCalling(), messageServer.getNumber(),messageServer.getNumSequence());
        return operator;
    }

    /**
     * This method is used to change the status (logged in or logged out) of an operator
     * @param messageServer
     */
    public synchronized void changeStatus(MessageServer messageServer) {
        if (messageServer.getOperator().isLoggedIn()) {
            logOperation(new DataWriterServer(messageServer.getNumCalling()), LOGINREQUEST);
        } else {
            logOperation(new DataWriterServer(messageServer.getNumCalling()), LOGOUTREQUEST);
        }
        operatorDAO.logged(messageServer.getNumCalling(), messageServer.getOperator());
    }

    private void logOperation(DataWriterServer dataWriter, String operation) {
        System.err.println(operation);
        dataWriter.updateHistory(operation);
    }

}
