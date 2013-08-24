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
public class RDBSavingsDAO implements SavingsDAO{

    private Connection dbConnection = null;
    
    public RDBSavingsDAO(Connection connection) {
        this.dbConnection = connection;
    }
    
    @Override
    public void createSavings(Savings savings) {
        try {
            PreparedStatement sqlStatement;
            sqlStatement = dbConnection.prepareStatement(
                "INSERT INTO ACMEDB.SAVINGS(C_ID, BALANCE)"
                +"VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
            
            sqlStatement.setInt(1, savings.getAccNum());
            sqlStatement.setFloat(2, savings.getBalance());
      
            sqlStatement.executeUpdate();
            
            ResultSet result = sqlStatement.getGeneratedKeys();
            result.next();
            savings.setAccNum(result.getInt(1));
        }
        catch(SQLException sqle) {
            System.out.println("Savings account creation failed.");
            sqle.printStackTrace();
        }
    }
    
    @Override
    public Savings readSavings(int acc_num) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "SELECT * FROM ACMEDB.SAVINGS WHERE ACC_NUM="+acc_num);
            
            sqlStatement.executeQuery();
            
            ResultSet result = sqlStatement.getResultSet();
            
            int accNum = result.getInt("ACC_NUM");
            int cID = result.getInt("C_ID");
            float balance = result.getFloat("BALANCE");
            
            Savings savings = new Savings(accNum, cID, balance);
            
            return savings;
        }
        catch(SQLException sqle) {
            System.out.println("Saving account reading failed.");
            sqle.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public void updateSavings(Savings savings) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "UPDATE ACMEDB.SAVINGS"+
                    "SET C_ID = ?, BALANCE = ?"+
                    "WHERE ACC_NUM = "+savings.getAccNum());
            
            sqlStatement.setInt(1, savings.getCID());
            sqlStatement.setFloat(2, savings.getBalance());
            
            sqlStatement.executeUpdate();
            
        }
        catch(SQLException sqle) {
            System.out.println("Saving account updating failed.");
            sqle.printStackTrace();
        }
    }
    
    @Override
    public void deleteSavings(Savings savings) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "DELETE FROM ACMEDB.SAVINGS"+
                    "WHERE ACC_NUM = "+savings.getAccNum());
            
            sqlStatement.executeUpdate();
        }
        catch(SQLException sqle) {
            System.out.println("Saving account deleting failed.");
            sqle.printStackTrace();
        }
    }
    
    public void getAllSavings()
    {
       try
        {   
           PreparedStatement sqlStatement;
           sqlStatement = dbConnection.prepareStatement(
           "SELECT * FROM ACMEDB.SAVINGS");
           sqlStatement.executeUpdate();
     
        }
        catch (SQLException sqlException) 
        { 
           System.out.println("Could not find any saving account.");
           sqlException.printStackTrace(); 
        } 
    }
    
}
