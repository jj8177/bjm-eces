/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB_Data_Access;

/**
 *
 * @author JJ & Baron & Marcel
 */
public class Transactions 
{
    private int tID;
    private int acc_num;
    private float amount;
    private String description;
    
    public Transactions() 
    {
        
    }
    
    public Transactions(int acc_num, float amount, String description) 
    {
        this.acc_num = acc_num;
        this.amount = amount;
        this.description = description;
    }
    
    public Transactions(int tID, int acc_num, float amount, String description) 
    {
        this.tID = tID;
        this.acc_num = acc_num;
        this.amount = amount;
        this.description = description;
    }
    
    public int getTID() 
    {
        return tID;
    }
    
    public int getAccNum() 
    {
        return acc_num;
    }
    
    public float getAmount() 
    {
        return amount;
    }
    
    public String getDescription() 
    {
        return description;
    }
    
    public void setTID(int newID) 
    {
        tID = newID;
    }
    
    public void setAccNum(int newAccNum) 
    {
        acc_num = newAccNum;
    }
    
    public void setAmount(float newAmount) 
    {
        amount = newAmount;
    }
    
    public void setDescription(String newDescription)
    {
        description = newDescription;
    }
    
}

