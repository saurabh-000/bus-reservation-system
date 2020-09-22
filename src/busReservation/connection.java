/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busReservation;

/**
 *
 * @author hp
 */
public class connection {
    connection() throws ClassNotFoundException
    {
         Class.forName("com.mysql.jdbc.Driver");
    }
    
}
