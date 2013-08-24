/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

/**
 *
 * @author JJ & Baron & Marcel
 */
public class Employee 
{
    private int eID;
    private String firstName;
    private String lastName;
    
    public Employee() 
    {
        
    }
    
    public Employee(String firstName, String lastName) 
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Employee(int eID, String firstName, String lastName) 
    {
        this.eID = eID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public int getEID() 
    {
        return eID;
    }
    
    public String getFirstName() 
    {
        return firstName;
    }
    
    public String getLastName() 
    {
        return lastName;
    }
    
    public void setEID(int newID) 
    {
        eID = newID;
    }
    
    public void setFirstName(String newFirstName) 
    {
        firstName = newFirstName;
    }
    
    public void setLastName(String newLastName) 
    {
        lastName = newLastName;
    }
    
}

