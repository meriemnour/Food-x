/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery.GUI;

import delivery.entity.Role;
import delivery.entity.User;
import delivery.service.UserService;
import delivery.utils.MailApi;
import delivery.utils.SmsApi;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class StartPageController implements Initializable {


   /* private AnchorPane pane_login;
    private TextField tfusername;
    private PasswordField pfpassword;
    private AnchorPane pane_signup;
    private TextField tflastname;
    private TextField tfemail;
    private TextField tfusername_signup;
    private TextField pfpassword_signup;
    private TextField tfname;
    private TextField tftel;
    private DatePicker dpdate;
    private TextField tfadresse;
    private Label labelclock;*/

    
    /*public void clock(){
        
      Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
        LocalTime currentTime = LocalTime.now();
        time.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),new KeyFrame(Duration.seconds(1)) );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();*/
        
    /*   Thread clock=new Thread(){
            public void Run(){
                try {
                    while(true){
                    Calendar cal=new GregorianCalendar();
                    int day= cal.get(Calendar.DAY_OF_MONTH);
                    int month=cal.get(Calendar.MONTH);
                    int year=cal.get(Calendar.YEAR);
       
                    int sc=cal.get(Calendar.SECOND);
                    int min=cal.get(Calendar.MINUTE);
                    int h=cal.get(Calendar.HOUR);
                    
                    labelclock.setText("Time  "+h+":"+min+":"+sc+"   Date   "+day+"/"+day+"/"+year);
                    sleep(1000);
                }
                } catch (InterruptedException ex) {
                    Logger.getLogger(EssaiController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
                clock.start();
        
       
       
    }*/
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       /* clock();*/
    } }   


    
    /*UserService us =new UserService();
    private void login(ActionEvent event) {
        boolean resultat= us.checklogin(tfusername.getText(),pfpassword.getText());
        if (resultat==true){
            System.out.println("login succes");
            if(us.approvedlogin(tfusername.getText(),pfpassword.getText())){
                if(us.findByUsername(tfusername.getText()).getRole().equals(Role.CLIENT)){
                    System.out.println("interface client");
                }
                else if(us.findByUsername(tfusername.getText()).getRole().equals(Role.ADMIN)){
                    try {
                        Parent root=FXMLLoader.load(getClass().getResource("/delivery/GUI/AdminBack_End.fxml"));
                        Scene scene = new Scene(root);
                        // aandi interface 9dima w bech n7el interface jdida w nsaker l 9dima donc nestaamel node
                        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
                        stage.setTitle("Forgot Password!!");
                        stage.setScene(scene);
                        stage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(EssaiController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(us.findByUsername(tfusername.getText()).getRole().equals(Role.RESPONSABLE)){
                    System.out.println("interface responsable");
                }
                else if(us.findByUsername(tfusername.getText()).getRole().equals(Role.COLLABORATEUR)){
                    System.out.println("interface collaborateur");
                }
                else{
                    System.out.println("interface livreur");
                }
            }
            else{
                StringBuilder errors=new StringBuilder();
                errors.append("Wait for admin approval\n");
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText(errors.toString());
                alert.showAndWait();
            }
            
            /*
            String email=tfusername.getText();
            String password =pfpassword.getText();
            User user=null;
            user=UserService.checklogin(username, password );
            if(user==null){
            System.out.println("login failed");}
            else{
            if(user.getstatus().equals("false"))
            {
            tringBuilder errors=new StringBuilder();
            errors.append("Wait for admin approval\n");
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setContentText(errors.toString());
            alert.showAndWait();
            }
            if(user.getstatus().equals("true"))
            System.out.println("login succes");
            Parent root=FXMLLoader.load(getClass().getResource("/Delivery/GUI/HomePage.fxml"));
            Scene scene = new Scene(root);
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("HomePage");
            stage.setScene(scene);
            stage.show();
            }
            
            
        }else {
            StringBuilder errors=new StringBuilder();
                errors.append("Invalid username or password\n");
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setContentText(errors.toString());
                alert.showAndWait();
        }
    }
    private void LoginpaneShow(ActionEvent event) {
        pane_login.setVisible(true);
        pane_signup.setVisible(false);
    }

    private void SignupaneShow(ActionEvent event) {
        pane_login.setVisible(false);
        pane_signup.setVisible(true);
    }
    

    
    public String email="^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String numTel="^[0-9]*$";
    
    ZoneId defaultZoneId = ZoneId.systemDefault();
    private void signin(ActionEvent event) {
        
              StringBuilder errors=new StringBuilder();
        //.trim ==> tna7ili les espace khater ken fama espace twali ma aadech empty hors lezem tkoun empty donc naamlou trim
        //.append ==> ken par exemple ma ktebtech adresse w email donc ijibli ken lekhrenya donc .append yaamle aala l lkoll 
        //kima une list kol ma nektebech tzid'ha f lista w baeed yaffichili ili ma ktebtech fih
        if(tfadresse.getText().trim().isEmpty()){
            errors.append("Please enter an adress\n");
        }
        if(tfemail.getText().trim().isEmpty() ){
            errors.append("Please enter an email\n");
        }
        if(tfname.getText().trim().isEmpty()){
            errors.append("Please enter a lastname\n");
        }
        if(tflastname.getText().trim().isEmpty()){
            errors.append("Please enter a firstname\n");
        }
        if(tfusername_signup.getText().trim().isEmpty()){
            errors.append("Please enter a username\n");
        }
        if(tftel.getText().trim().isEmpty() ){
            errors.append("Please enter a phone number\n");
        }
        if(pfpassword_signup.getText().trim().isEmpty()){
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
            u.setPrenom(tflastname.getText());
            u.setUsername(tfusername_signup.getText());
            u.setAdresse(tfadresse.getText());
            u.setEmail(tfemail.getText());
            u.setPassword(pfpassword_signup.getText());
            u.setNumTel(Integer.parseInt(tftel.getText()));
            u.setDate_naissance(Date.valueOf(dpdate.getValue()));
            u.setRole(Role.CLIENT);
            us.signin(u);
            MailApi m=new MailApi();
            m.SendMail(u.getEmail(), "Bienvenu", "Signin");
            SmsApi s=new SmsApi();
            s.sendSMS(String.valueOf(u.getNumTel()), "bienvenu");
        }
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setContentText("Wait for admin approval\n");
        alert.showAndWait();
        pane_login.setVisible(true);
        pane_signup.setVisible(false);
        
    
    
    }

    private void forgotpassword(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/delivery/GUI/ForgotPassword.fxml"));
            Scene scene = new Scene(root);
            // aandi interface 9dima w bech n7el interface jdida w nsaker l 9dima donc nestaamel node
            Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Forgot Password!!");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(EssaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
}*/
