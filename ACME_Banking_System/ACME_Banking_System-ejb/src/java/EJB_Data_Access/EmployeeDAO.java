/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

/**
 *
 * @author JJ & Baron & Marcel
 */
public interface EmployeeDAO 
{
    public void createEmployee(Employee employee);
    
    public Employee readEmployee(int eID);
    
    public void updateEmployee(Employee employee);
    
    public void deleteEmployee(Employee employee);    
}
