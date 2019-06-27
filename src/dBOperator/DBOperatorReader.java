package dBOperator;

import model.Operator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class is used to retrieve a defined operator
 */
public class DBOperatorReader {
    public DBOperatorReader(){

    }
    /**
     * This method is used to retrieve a defined operator
     * @param connection
     * @param numCalling
     * @param number
     * @param username
     * @return operator
     */

    Operator retreiveOperator(Connection connection, String numCalling, String number, String username) {
        Operator operator = null;
        try {
            System.err.println("[DBOperatorReader] - Retrieving just a operator to check ...");
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM operator where numbe = ? and username =? ;");
            ps.setString(1, number);
            ps.setString(2, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if(rs.getString("numbe") != null && rs.getString("username") != null && rs.getString("passwor") != null) {
                operator = new Operator(rs.getString("numbe"), rs.getString("username"), rs.getString("passwor"));
                operator.setLoggedIn(rs.getBoolean("LoggedIn"));
            }
        } catch (SQLException e) {
            System.err.println("[DBOperatorReader] - Exception " + e + " encountered in method retrieveJustTheOne.");
        }
        return operator;
    }
}
