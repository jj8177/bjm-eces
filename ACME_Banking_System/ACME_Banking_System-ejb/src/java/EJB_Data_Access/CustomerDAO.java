/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

/**
 *
 * @author JJ & Baron & Marcel
 */
public interface CustomerDAO 
{
    public void createCustomer(Customer customer);
    
    public Customer readCustomer(int cID);
    
    public void updateCustomer(Customer customer);
    
    public void deleteCustomer(Customer customer);    
}
