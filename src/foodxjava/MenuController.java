/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodxjava;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Ilyes
 */
public class MenuController implements Initializable {
    MenuModel menuModel=new MenuModel();
    @FXML
    private JFXTextField nomtxt ;
    @FXML
    private JFXTextField prixtxt;
    @FXML
    private JFXTextField poidstxt;
    @FXML
    private JFXTextArea descriptiontxt;
    @FXML
    private JFXComboBox Categorytxt;
    @FXML
    private JFXComboBox vegtxt;
    @FXML
    private JFXButton valider ;
        @FXML
    private JFXButton exit ;       
    @FXML
    private JFXButton back ;

        
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options = 
    FXCollections.observableArrayList(
        "Option 1",
        "Option 2",
        "Option 3"
    );
         Categorytxt.setValue("Option 1");
         Categorytxt.setItems(options);
                 ObservableList<String> options2 = 
    FXCollections.observableArrayList(
        "Yes",
        "Non"
    );
         vegtxt.setValue("Yes");
         vegtxt.setItems(options2);
          if(menuModel.isDbConnected()){
             System.out.println("Db connected");
        }else{
             System.out.println("Db not connected");
        }
    }    
    @FXML
    public void exitScreen(ActionEvent event){
        System.exit(0);
    }
    @FXML

     public void Backhome(ActionEvent event) throws Exception  {
		Stage primaryStage =new Stage();
                primaryStage.initStyle(StageStyle.UNDECORATED);
		Parent root =FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
                
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
	}
         @FXML

        public void AddMenuu(ActionEvent event){
       String nom=nomtxt.getText();
       String category= Categorytxt.getValue().toString();
       String  description=descriptiontxt.getText();
       double prix=Double.valueOf(prixtxt.getText());
       double poids=Double.valueOf(poidstxt.getText());
       boolean  vegetarien=("Yes".equals(vegtxt.getValue().toString()));
       try {
           if((nom.isEmpty()|| category.isEmpty() || description.isEmpty()  )){
               infoBox("Enter valid fields",null,"Error");
           }else{
               menuModel.MenuAdd(nom,  prix, description, poids, vegetarien, category);
               infoBox(" Added Sucessfully\n Menu Name is:"+nom,null,"Success" );
               nomtxt.clear();
               descriptiontxt.clear(); 
               prixtxt.clear();
               poidstxt.clear();
           }
           
       } catch (SQLException ex) {
           infoBox("please fill balnk fields",null,"Alert" );
           Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
       }
      }
          public static void infoBox(String infoMessage, String headerText, String title){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

}
