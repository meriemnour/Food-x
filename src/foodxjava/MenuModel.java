/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodxjava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     public void MenuAdd(String nom, double prix,String description,double poids,boolean vegetarien, String category) throws SQLException{
        PreparedStatement preparedStatement =null;
        String query="insert into produit (nom ,prix,description,poids,vegetarien,category)"+"value(?,?,?,?,?,?)";
      try {
          preparedStatement=connection.prepareStatement(query);
          preparedStatement.setString(1,nom);
          preparedStatement.setDouble(2,prix);
          preparedStatement.setString(3,description);
          preparedStatement.setDouble(4,poids);
          preparedStatement.setBoolean(5,vegetarien);
          preparedStatement.setString(6, category);

          preparedStatement.execute();
      } catch (SQLException ex) {
          Logger.getLogger(MenuModel.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
          connection.close();
      }

    }
}
