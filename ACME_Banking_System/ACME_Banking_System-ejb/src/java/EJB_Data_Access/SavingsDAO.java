/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

/**
 *
 * @author JJ & Baron & Marcel
 */
public interface SavingsDAO 
{
    public void createSavings(Savings savings);
    
    public Savings readSavings(int acc_num);
    
    public void updateSavings(Savings savings);
    
    public void deleteSavings(Savings savings);    
}
