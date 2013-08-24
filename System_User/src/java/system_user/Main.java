/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package system_user;

import Beans.Stateful_SessionBeansRemote;
import Beans.Stateless_SessionBeansRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author JJ & Baron & Marcel
 */
public class Main implements Serializable
{
    @EJB
    private static Stateless_SessionBeansRemote customerBean;
    
    @EJB
    private static Stateful_SessionBeansRemote shoppingCartBean;
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int menuSelection;
        
        
        customerBean.addCustomer("Tom", "Adrianus", java.sql.Date.valueOf("2010-01-31"), "32, Elizabeth Street Melbourne Victoria 3000");
        
        do
        {
        System.out.println("****************************");
        System.out.println("Cart:");
        List<String> cartItems = shoppingCartBean.getItemsInCart(); 
        for (String item : cartItems) 
        {
            System.out.println(item); 
        }
        System.out.println("****************************");
        System.out.println();
        System.out.println("1: Add item 1"); 
        System.out.println("2: Add item 2");
        System.out.println("3: Add item 3"); 
        System.out.println("4: Add item 4");
        System.out.println("5: View Cart");
        System.out.println("6: Empty Cart"); 
        System.out.println("7: Log Out");
        
        menuSelection = getSelection();
        
        if (menuSelection >= 1 && menuSelection <= 4) 
        {
            shoppingCartBean.addItemToCart(menuSelection); 
        }
        if (menuSelection == 5) 
        { 
            shoppingCartBean.getItemsInCart();
        }
        if (menuSelection == 6) 
        {
            shoppingCartBean.emptyCart(); 
        }
        }while(menuSelection != 7);
    }
    
    private static int getSelection() 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int output = -1;
        boolean validInput = false;

        do 
        { 
            try 
            {
                input = br.readLine(); if (input.length() > 1) 
                {
                    continue; 
                }

                output = Integer.parseInt(input); if (output < 0 || output > 9) 
                {
                    continue; 
                }
                validInput = true;
            } 
            catch (IOException ioe) 
            {
                System.out.println(ioe.getMessage()); 
                ioe.printStackTrace();
                validInput = false;
            } 
            catch (NumberFormatException nfe) 
            {   
                validInput = false;
            }
       } while (validInput == false);
       return output; 
    }
}
