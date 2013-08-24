/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

/**
 *
 * @author JJ & Baron & Marcel
 */
public interface TransactionsDAO 
{
    public void createTransactions(Transactions transactions);
    
    public Transactions readTransactions(int tID);
    
    public void updateTransactions(Transactions transactions);
    
    public void deleteTransactions(Transactions transactions);    
}
