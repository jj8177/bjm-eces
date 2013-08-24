/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author JJ & Baron & Marcel
 */
public class Customer implements Serializable
{
    private int cID;
    private String firstName;
    private String lastName;
    private Date dob;
    private String address;
    
    public Customer() 
    {
        
    }
    
    public Customer(String firstName, String lastName, Date dob, String address) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }
    
    public Customer(int cID, String firstName, String lastName, Date dob, String address) 
    {
        this.cID = cID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
    }
    
    public int getCID() 
    {
        return cID;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }
    
    public String getLastName() 
    {
        return lastName;
    }
    
    public Date getDOB()
    {
        return dob;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setCID(int newID) 
    {
        cID = newID;
    }
    
    public void setFirstName(String newFirstName) 
    {
        firstName = newFirstName;
    }
    
    public void setLastName(String newLastName) 
    {
        lastName = newLastName;
    }
    
    public void setDOB(Date newDOB) 
    {
        dob = newDOB;
    }
    
    public void setAddress(String newAddress) 
    {
        address = newAddress;
    }
}

