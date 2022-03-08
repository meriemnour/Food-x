/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery;

import delivery.entity.Role;
import delivery.entity.User;
import delivery.service.UserService;
import delivery.utils.Myconnexion;
import java.time.LocalDate;
import java.util.Date;


/**
 *
 * @author asus
 */
public class Delivery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.sql.Date d =java.sql.Date.valueOf(LocalDate.now());
        User u = new User("hosni","hosni","collaborateur","collaborateur","mohamed@gmail.com","rue des camelias",50737864,Role.CLIENT,d);
        UserService su= new UserService();
        //su.ajouter(u);
        //su.modifier(2);
        //su.supprimer(1);
        //System.out.println(su.afficher());
        System.out.println(su.checklogin("admin", "admin"));
        //System.out.println(su.findByName("hosni"));
        //System.out.println(su.sortedByDate());
    }
    
}
