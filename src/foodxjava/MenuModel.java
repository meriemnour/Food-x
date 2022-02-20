/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodxjava;
import static foodxjava.MenuController.i;
import static foodxjava.MenuController.infoBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
/**
 *
 * @author Ilyes
 */
public class MenuModel {
   Connection connection;
        int aid;

    public MenuModel(){
        connection =SqlConnection.Connector();
        if(connection==null){
            System.exit(0);
            System.out.println("notconnected");
        }
    }
    public boolean isDbConnected(){
        try {
            return !connection.isClosed();
        } catch (SQLException ex) {
            System.out.println("error");
            Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
            return false;
            
        }
        
    } 
     public void MenuAdd(String menu_name, double price,String description,double poids,boolean vegetarien, String categorie) throws SQLException{
        PreparedStatement preparedStatement =null;
        String query="insert into menu (menu_name ,price,categorie,description,vegetarien,poids)"+"value(?,?,?,?,?,?)";
      try {
          preparedStatement=connection.prepareStatement(query);
          preparedStatement.setString(1,menu_name);
          preparedStatement.setDouble(2,price);
          preparedStatement.setString(3, categorie);
          preparedStatement.setString(4,description);
          preparedStatement.setBoolean(5,vegetarien);
          preparedStatement.setDouble(6,poids);

          preparedStatement.execute();
      } catch (SQLException ex) {
          Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
      }

    }
         public void MenuUpdate( String menu_name , int price,String description,double poids,boolean vegetarien, String categorie) throws SQLException{
        PreparedStatement preparedStatement =null;
        String query="Update menu SET price=? ,categorie=? ,description=? ,vegetarien=? , poids=? where  menu_name=?";
try {
          preparedStatement=connection.prepareStatement(query);
          preparedStatement.setInt(1,price);
          preparedStatement.setString(2,categorie);
          preparedStatement.setString(3,description);
          preparedStatement.setBoolean(4,vegetarien);
          preparedStatement.setDouble(5, poids);
          preparedStatement.setString(6,menu_name);

          preparedStatement.execute();
      } catch (SQLException ex) {
          Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
      }

     
    }
         public void Menudelete( String menu_name) throws SQLException{
        PreparedStatement preparedStatement =null;
        String query="Delete from  menu  where  menu_name=?";
try {
          preparedStatement=connection.prepareStatement(query);

          preparedStatement.setString(1,menu_name);

          preparedStatement.execute();
      } catch (SQLException ex) {
          Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
      }

     
    }
         
       public void cart_add(int menu_id) throws SQLException{
        PreparedStatement preparedStatement = null ;
        String query="insert into orders(menu_id,order_status)"+"values(?,'ADDED_TO_CART')";
        try {
            preparedStatement =connection.prepareStatement(query);
            preparedStatement.setInt(1, menu_id);
            preparedStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            preparedStatement.close();
        }
        
    }      
}
