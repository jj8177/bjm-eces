package Beans;

import java.sql.Date;
import javax.ejb.Stateless;
import EJB_Data_Access.Customer;
import EJB_Data_Access.CustomerDAO;
import EJB_Data_Access.RDBCustomerDAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author JJ & Baron & Marcel
 */
@Stateless
public class Stateless_SessionBeans implements Stateless_SessionBeansRemote, Serializable 
{
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Resource(lookup = "jdbc/ACME_DB_Datasource") 
    private DataSource dataSource;    
    private Connection connection;
       
    @PostConstruct
    public void initialize() 
    { 
        try 
        {
           connection = dataSource.getConnection();
        } 
        catch(SQLException sqle) 
        {
           sqle.printStackTrace(); 
        }
    }
    
    @PreDestroy
    public void close() 
    { 
        try 
        {
           connection.close();
        } 
        catch (SQLException sqle) 
        {
           sqle.printStackTrace(); 
        }
    }
    
       /**
     *
     * @param firstname
     * @param lastname
     * @param dob
     * @param address
     */
    @Override
       public void addCustomer(String firstname, String lastname, Date dob, String address) {
       try 
       {
          CustomerDAO dao = new RDBCustomerDAO(connection);
          Customer customer = new Customer(firstname, lastname, dob, address); 
          dao.createCustomer(customer);
       } 
       catch (Exception e) 
       {
          System.out.println("Could not create customer."); e.printStackTrace();
       }

    }
}
