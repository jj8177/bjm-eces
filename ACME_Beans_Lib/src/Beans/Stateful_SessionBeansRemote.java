/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author JJ & Baron & Marcel
 */
@Remote
public interface Stateful_SessionBeansRemote {
    public void addItemToCart(int ID); 
    public List<String> getItemsInCart(); 
    public void emptyCart();
}
