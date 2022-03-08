/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.GUI;

import delivery.entity.Role;
import delivery.entity.User;
import delivery.service.UserService;
import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class AdminBack_EndController implements Initializable {

    @FXML
    private TextField tfname;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfusername;
    @FXML
    private TextField tfemail;
    @FXML
    private PasswordField pfpwd;
    @FXML
    private TextField tfaddress;
    @FXML
    private TextField tfnumero;
    @FXML
    private ComboBox<Role> comborole;
    UserService us=new UserService();
    @FXML
    private DatePicker dpdate;
    @FXML
    private ListView<User> listviewuser;
    @FXML
    private CheckBox checkbox;
    @FXML
    private TextField tfrecherhe;
    ObservableList<User> data=FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        refreshlist();
        comborole.getItems().setAll(Role.values());
        recherche_avance();
        //fillforum();
        
        
    }    
    
        @FXML
    private void ajouter(ActionEvent event) {
        StringBuilder errors=new StringBuilder();
        //.trim ==> tna7ili les espace khater ken fama espace twali ma aadech empty hors lezem tkoun empty donc naamlou trim
        //.append ==> ken par exemple ma ktebtech adresse w email donc ijibli ken lekhrenya donc .append yaamle aala l lkoll 
        //kima une list kol ma nektebech tzid'ha f lista w baeed yaffichili ili ma ktebtech fih
        if(tfaddress.getText().trim().isEmpty()){
            errors.append("Please enter an adress\n");
        }
        if(tfemail.getText().trim().isEmpty() ){
            errors.append("Please enter an email\n");
        }
        if(tfname.getText().trim().isEmpty()){
            errors.append("Please enter a lastname\n");
        }
        if(tfprenom.getText().trim().isEmpty()){
            errors.append("Please enter a firstname\n");
        }
        if(tfusername.getText().trim().isEmpty()){
            errors.append("Please enter a username\n");
        }
        if(tfnumero.getText().trim().isEmpty() ){
            errors.append("Please enter a phone number\n");
        }
        if(pfpwd.getText().trim().isEmpty()){
            errors.append("Please enter a password\n");
        }
        if(dpdate.getValue()==null){
            errors.append("Pleanse enter a birthday");
        }
        if(errors.length()>0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(errors.toString());
            alert.showAndWait();
        }
        else{
            User u =new User();
            u.setNom(tfname.getText());
            u.setPrenom(tfprenom.getText());
            u.setUsername(tfusername.getText());
            u.setAdresse(tfaddress.getText());
            u.setEmail(tfemail.getText());
            u.setPassword(pfpwd.getText());
            u.setNumTel(Integer.parseInt(tfnumero.getText()));
            u.setDate_naissance(Date.valueOf(dpdate.getValue()));
            u.setRole(comborole.getValue());
            u.setStatus(checkbox.isSelected());
            us.ajouter(u);
            refreshlist();
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
       User u=new User();
            u.setNom(tfname.getText());
            u.setPrenom(tfprenom.getText());
            u.setUsername(tfusername.getText());
            u.setAdresse(tfaddress.getText());
            u.setEmail(tfemail.getText());
            u.setPassword(pfpwd.getText());
            u.setNumTel(Integer.parseInt(tfnumero.getText()));
            u.setDate_naissance(Date.valueOf(dpdate.getValue()));
            u.setRole(comborole.getValue());
            u.setStatus(checkbox.isSelected());
            //System.out.println(checkboxapp.isSelected());
            us.modifier(listviewuser.getSelectionModel().getSelectedItem().getId(), u);
       refreshlist();
    }

    @FXML
    private void supprimer(ActionEvent event) {
        User u=listviewuser.getSelectionModel().getSelectedItem();
        us.supprimer(u.getId());
        refreshlist();
    }
    public void refreshlist(){
        data=FXCollections.observableArrayList(us.afficher());
        listviewuser.setItems(data);
    }
    @FXML
    public void fillforum(){
        User u=listviewuser.getSelectionModel().getSelectedItem();
        tfname.setText(u.getNom());
        tfprenom.setText(u.getPrenom());
        tfusername.setText(u.getUsername());
        tfemail.setText(u.getEmail());
        pfpwd.setText(u.getPassword());
        tfaddress.setText(u.getAdresse());
        tfnumero.setText(String.valueOf(u.getNumTel()));
        comborole.setValue(u.getRole());
        checkbox.setSelected(u.isStatus());
        Instant instant = Instant.ofEpochMilli(u.getDate_naissance().getTime());
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        dpdate.setValue(ldt.toLocalDate());
    }
    public void recherche_avance(){
        FilteredList<User> filteredlist=new FilteredList<>(data,b->true);
        tfrecherhe.textProperty().addListener(
                (observable,oldValue,newValue)->{
                    filteredlist.setPredicate(user->{
                        if(newValue==null || newValue.isEmpty()){
                            return true;
                        }
                        String lowercasenewvalue=newValue.toLowerCase();
                        if(user.getNom().toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        }
                        else if(user.getPrenom().toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        }

                        else if(user.getUsername().toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        }

                        else if(user.getEmail().toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        }

                        else if(user.getPassword().toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        }

                        else if(user.getAdresse().toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        } 
                        
                        else if(String.valueOf(user.getNumTel()).toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        }
                        
                        else if(user.getRole().toString().toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        }
                        
                        else if(user.getDate_naissance().toString().toLowerCase().indexOf(lowercasenewvalue)!=-1){
                            return true;
                        }
                        else{
                            return false;
                        }
                        
                    });
                }
        );
        listviewuser.setItems(filteredlist);
    }
    
}
