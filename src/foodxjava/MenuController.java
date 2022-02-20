/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodxjava;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private JFXTextField nomtxt3 ;
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
    private JFXTextField nomtxt4 ;
    @FXML
    private JFXTextField nomtxt2 ;
    @FXML
    private JFXTextField prixtxt2;
    @FXML
    private JFXTextField poidstxt2;
        @FXML
    private JFXTextField Supprimertxt;
    @FXML
    private JFXTextArea descriptiontxt2;
    @FXML
    private JFXComboBox Categorytxt2;
    @FXML
    private JFXComboBox vegtxt2;
    @FXML
    private JFXButton valider ;
        @FXML
    private JFXButton exit ;       
    @FXML
    private JFXButton back ;
        @FXML
    private JFXButton afficher ;
    @FXML
    private JFXTabPane Tabp ;
        @FXML
    private JFXButton buttongerer ;
                @FXML
    private JFXButton buttonsupprimer ;

                
                @FXML
    private TableView<ModelTable1> table1;

    @FXML
    private TableColumn<ModelTable1, String> MenuidCol1;

    @FXML
    private TableColumn<ModelTable1, String> MenuNameCol1;

    @FXML
    private TableColumn<ModelTable1, String> poidsCol1;

    @FXML
    private TableColumn<ModelTable1, String> prixCol1;
    @FXML
    private TableColumn<ModelTable1, String> descriptionCol1;
    
    @FXML
    private TableColumn<ModelTable1, String> categorieCol1;
   
    @FXML
    private TableColumn<ModelTable1, String> isvegCol1;

    

    boolean type ;
    public static int i;
    Connection con; //connection for table 
    ObservableList<ModelTable1> obList1= FXCollections.observableArrayList();

        
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
                  Categorytxt2.setValue("Option 1");
         Categorytxt2.setItems(options);
                 ObservableList<String> options2 = 
    FXCollections.observableArrayList(
        "Yes",
        "Non"
    );
         prixCol1.setCellValueFactory(new PropertyValueFactory<>("Prix"));
         MenuidCol1.setCellValueFactory(new PropertyValueFactory<>("Nom Repas"));
         poidsCol1.setCellValueFactory(new PropertyValueFactory<>("Poids"));
         descriptionCol1.setCellValueFactory(new PropertyValueFactory<>("Description"));
         MenuNameCol1.setCellValueFactory(new PropertyValueFactory<>("menuname"));  
         categorieCol1.setCellValueFactory(new PropertyValueFactory<>("quantity_item"));
         isvegCol1.setCellValueFactory(new PropertyValueFactory<>("status"));/*
tableConnection1();
       table1.setItems(obList1);
       table1.refresh();*/
        
         vegtxt.setValue("Yes");
         vegtxt.setItems(options2);
         vegtxt2.setValue("Yes");
         vegtxt2.setItems(options2);
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
       }
      }  
        public void UpdateMenu(ActionEvent event){
       String menu_name=nomtxt2.getText();
       String categorie= Categorytxt2.getValue().toString();
       String  description=descriptiontxt2.getText();
       int price=Integer.valueOf(prixtxt2.getText());
       double poids=Double.valueOf(poidstxt2.getText());
       boolean  vegetarien=("Yes".equals(vegtxt2.getValue().toString()));
       try {
              if((menu_name.isEmpty()|| categorie.isEmpty() || description.isEmpty()  )){
               infoBox("Enter valid fields",null,"Error");
           }else{
               menuModel.MenuUpdate(menu_name,  price, description, poids, vegetarien, categorie);
               infoBox(" updated Sucessfully\n Menu Name is:"+menu_name,null,"Success" );
               nomtxt2.clear();
               descriptiontxt2.clear(); 
               prixtxt2.clear();
               poidstxt2.clear();
           }
         } catch (SQLException ex) {
           infoBox("please fill balnk fields",null,"Alert" );
       }
            
        
    }
        public void DeleteMenu(ActionEvent event){
       String nom=nomtxt3.getText();
       try {
              if(nom.isEmpty() ){
               infoBox("Enter valid fields",null,"Error");
           }else{
               menuModel.Menudelete(nom);
               infoBox(" deleted Sucessfully\n Menu Name is:"+nom,null,"Success" );
               nomtxt3.clear();
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

    public void tableConnection1(){
        
        
         table1.getItems().clear();
        try {
             
            String query="SELECT menu.price as Price ,menu.menu_id,menu.menu_name as Name,quantity FROM orders JOIN menu ON orders.menu_id=menu.menu_id WHERE orders.customer_id="+i+" and order_status='ADDED_TO_CART'";
            ResultSet rs =con.createStatement().executeQuery(query);
            while(rs.next()){
                obList1.add(new ModelTable1(rs.getString("Name"), rs.getInt("menu_id"),rs.getInt("quantity"), rs.getInt("Price")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void AddOrder(ActionEvent event){
       int nom=Integer.valueOf(nomtxt4.getText());
       try {
              if(nom==0){
               infoBox("Enter valid fields",null,"Error");
           }else{
               menuModel.cart_add(nom);
               infoBox(" deleted Sucessfully\n Menu Name is:"+nom,null,"Success" );
               nomtxt4.clear();
           }
         } catch (SQLException ex) {
           infoBox("please fill balnk fields",null,"Alert" );
           Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }








}