/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Date;
import javax.ejb.Remote;

/**
 *
 * @author JJ & Baron & Marcel
 */
@Remote
public interface Stateless_SessionBeansRemote {
    public void addCustomer(String firstname, String lastname, Date dob, String address);
}
