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
public class RDBEmployeeDAO implements EmployeeDAO{

    private Connection dbConnection = null;
    
    public RDBEmployeeDAO(Connection connection) {
        this.dbConnection = connection;
    }
    
    @Override
    public void createEmployee(Employee employee) {
        try {
            PreparedStatement sqlStatement;
            sqlStatement = dbConnection.prepareStatement(
                "INSERT INTO ACMEDB.EMPLOYEE(FIRST_NAME, LAST_NAME)"
                +"VALUES(?,?)",Statement.RETURN_GENERATED_KEYS);
            
            sqlStatement.setString(1, employee.getFirstName());
            sqlStatement.setString(2, employee.getLastName());
      
            sqlStatement.executeUpdate();
            
            ResultSet result = sqlStatement.getGeneratedKeys();
            result.next();
            employee.setEID(result.getInt(1));
        }
        catch(SQLException sqle) {
            System.out.println("Employee creation failed.");
            sqle.printStackTrace();
        }
    }
    
    @Override
    public Employee readEmployee(int e_id) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "SELECT * FROM ACMEDB.EMPLOYEE WHERE E_ID="+e_id);
            
            sqlStatement.executeQuery();
            
            ResultSet result = sqlStatement.getResultSet();
            
            int em_id = result.getInt("E_ID");
            String first_name = result.getString("FIRST_NAME");
            String last_name = result.getString("LAST_NAME");
            
            Employee employee = new Employee(em_id, first_name, last_name);
            
            return employee;
        }
        catch(SQLException sqle) {
            System.out.println("Employee reading failed.");
            sqle.printStackTrace();
        }
        
        return null;
    }
    
    @Override
    public void updateEmployee(Employee employee) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "UPDATE ACMEDB.EMPLOYEE"+
                    "SET FIRST_NAME = ?, LAST_NAME = ?"+
                    "WHERE E_ID = "+employee.getEID());
            
            sqlStatement.setString(1, employee.getFirstName());
            sqlStatement.setString(2, employee.getLastName());
            
            sqlStatement.executeUpdate();
            
        }
        catch(SQLException sqle) {
            System.out.println("Employee updating failed.");
            sqle.printStackTrace();
        }
    }
    
    @Override
    public void deleteEmployee(Employee employee) {
        try {
            PreparedStatement sqlStatement = dbConnection.prepareStatement(
                    "DELETE FROM ACMEDB.EMPLOYEE"+
                    "WHERE E_ID = "+employee.getEID());
            
            sqlStatement.executeUpdate();
        }
        catch(SQLException sqle) {
            System.out.println("Employee deleting failed.");
            sqle.printStackTrace();
        }
    }
    
    public void getAllEmployees()
    {
       try
        {   
           PreparedStatement sqlStatement;
           sqlStatement = dbConnection.prepareStatement(
           "SELECT * FROM ACMEDB.EMPLOYEE");
           sqlStatement.executeUpdate();
     
        }
        catch (SQLException sqlException) 
        { 
           System.out.println("Could not find any employee.");
           sqlException.printStackTrace(); 
        } 
    }
    
}
