/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

/**
 *
 * @author JJ & Baron & Marcel
 */
public class Savings 
{
    private int acc_num;
    private int cID;
    private float balance;
    
    public Savings() 
    {
        
    }
    
    public Savings(int cID, float balance) 
    {
        this.cID = cID;
        this.balance = balance;
    }
    
    public Savings(int acc_num, int cID, float balance) 
    {
        this.acc_num = acc_num;
        this.cID = cID;
        this.balance = balance;
    }
    
    public int getAccNum() 
    {
        return acc_num;
    }
    
    public int getCID() 
    {
        return cID;
    }
    
    public float getBalance() 
    {
        return balance;
    }
    
    public void setAccNum(int newAccNum) 
    {
        acc_num = newAccNum;
    }
    
    public void setCID(int newID) 
    {
        cID = newID;
    }
    
    public void setBalance(float newBalance) 
    {
        balance = newBalance;
    }
    
}

