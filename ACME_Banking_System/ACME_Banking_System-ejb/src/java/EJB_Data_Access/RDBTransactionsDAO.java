/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author JJ & Baron & Marcel
 */
public class RDBTransactionsDAO implements TransactionsDAO{

    private Connection dbConnection = null;
    
    public RDBTransactionsDAO(Connection connection) {
        this.dbConnection = connection;
    }
    
    @Override
    public void createTransactions(Transactions transactions) {
        try {
            PreparedStatement sqlStatement;
            sqlStatement = dbConnection.prepareStatement(
                "INSERT INTO ACMEDB.TRANSACTIONS(ACC_NUM, AMOUNT, DESCRIPTION)"
                +"VALUES(?,?,?)",Statement.RETURN_GENERATED_KEYS);
            
            sqlStatement.setInt(1, transactions.getAccNum());
            sqlStatement.setFloat(2, transactions.getAmount());
            sqlStatement.setString(3, transactions.getDescription());
      
            sqlStatement.executeUpdate();
            
            ResultSet result = sqlStatement.getGeneratedKeys();
            result.next();
            transactions.setTID(result.getInt(1));
        }
        catch(SQLException sqle) {
            System.out.println("Transaction failed.");
            sqle.printStackTrace();
        }
    }
    
    @Override
    public Transactions readTransactions(int tID) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "SELECT * FROM ACMEDB.TRANSACTIONS WHERE T_ID="+tID);
            
            sqlStatement.executeQuery();
            
            ResultSet result = sqlStatement.getResultSet();
            
            int tranID = result.getInt("T_ID");
            int accNum = result.getInt("ACC_NUM");
            float amount = result.getFloat("AMOUNT");
            String description = result.getString("DESCRIPTION");
            
            Transactions transactions = new Transactions(tranID, accNum, amount, description);
            
            return transactions;
        }
        catch(SQLException sqle) {
            System.out.println("Transaction failed");
            sqle.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public void updateTransactions(Transactions transactions) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "UPDATE ACMEDB.TRANSACTIONS"+
                    "SET ACC_NUM = ?, AMOUNT = ?, DESCRIPTION = ?"+
                    "WHERE T_ID = "+transactions.getTID());
            
            sqlStatement.setInt(1, transactions.getAccNum());
            sqlStatement.setFloat(2, transactions.getAmount());
            sqlStatement.setString(3, transactions.getDescription());
            
            sqlStatement.executeUpdate();
            
        }
        catch(SQLException sqle) {
            System.out.println("Transaction failed.");
            sqle.printStackTrace();
        }
    }
    
    @Override
    public void deleteTransactions(Transactions transactions) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "DELETE FROM ACMEDB.TRANSACTIONS"+
                    "WHERE T_ID = "+transactions.getTID());
            
            sqlStatement.executeUpdate();
        }
        catch(SQLException sqle) {
            System.out.println("Transaction failed.");
            sqle.printStackTrace();
        }
    }
    
    public void getAllTransactions()
    {
       try
        {   
           PreparedStatement sqlStatement;
           sqlStatement = dbConnection.prepareStatement(
           "SELECT * FROM ACMEDB.TRANSACTIONS");
           sqlStatement.executeUpdate();
     
        }
        catch (SQLException sqlException) 
        { 
           System.out.println("Could not find any transaction.");
           sqlException.printStackTrace(); 
        } 
    }
    
}
