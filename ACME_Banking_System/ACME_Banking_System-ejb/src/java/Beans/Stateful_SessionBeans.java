/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;


/**
 *
 * @author JJ
 */
@Stateful
public class Stateful_SessionBeans implements Stateful_SessionBeansRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private List<String> cartItems = new ArrayList<>();
    private List<String> inventoryItems = new ArrayList<>();  
    public Stateful_SessionBeans() 
    {
        inventoryItems.add("Item 1"); 
        inventoryItems.add("Item 2"); 
        inventoryItems.add("Item 3"); 
        inventoryItems.add("Item 4");
    }

    @Override
    public void addItemToCart(int ID) {
        cartItems.add(inventoryItems.get(ID - 1));
    }

    @Override
    public List<String> getItemsInCart() {
        return cartItems; }

    @Override
    public void emptyCart() {
       cartItems.clear();
    }
   
}
