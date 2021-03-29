/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Client;
import Services.CRUD;
import Services.Mailing;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author belha
 */
public class AjoutclientController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private ComboBox sexe;    
    @FXML
    private DatePicker datenaissance;
    @FXML
    private CheckBox handicap;
    @FXML
    private TextField deshandicap;
    @FXML
    private TextField tel;
    @FXML
    private TextField adresse;
    @FXML
    private TextField email;
    @FXML
    private Button ajouterbouton;
    @FXML
    private Button show;
    @FXML
    private Button propos;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> sexelist = FXCollections.observableArrayList("Homme","Femme");
        sexe.setItems(sexelist);
        sexe.setPromptText("Selectionnez un choix");
        handicap.setSelected(false);
        
        
        
    }    

    @FXML
    private void AjouterClient(ActionEvent event) throws Exception {
        
        String Nom = nom.getText();
        String Prenom = prenom.getText();
        String Sexe = (String) sexe.getSelectionModel().getSelectedItem();
        LocalDate date = datenaissance.getValue();
        String Date_Naissance = date.toString();
        String Email = email.getText();
        String Adresse = adresse.getText();
        boolean Handicap = handicap.isSelected();
//        if (handicap.isSelected() == false);
//        {
//            deshandicap.setEditable(false);
//        }
//        
//        {
//            deshandicap.setEditable(true);
//        }
        String Des_handicap = deshandicap.getText();
        String telString = tel.getText();
        int Tel = Integer.parseInt(telString);

        Client c = new Client(1,Nom,Prenom,Sexe,Date_Naissance,Email,Adresse,Handicap,Des_handicap,Tel);
        CRUD pcd = new CRUD();
        pcd.addClient(c);
        Mailing.sendMail(c.getEmail());
        
        String title ="Client ajouté avec succés. \nMail envoyé avec succés.";
               TrayNotification notif=new TrayNotification();
                AnimationType Type =AnimationType.POPUP;
                
        notif.setAnimationType(Type);    
        notif.setTitle(title);
        notif.setNotificationType(NotificationType.SUCCESS);
        notif.showAndDismiss(javafx.util.Duration.millis(3000));
               
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("afficheclient.fxml"));
            //  Parent root  = loader.load();
            Scene  scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Les Clients");
            window.setScene(scene);
            window.show();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        
    }

    @FXML
    private void afficherClient(ActionEvent event) {
        
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("afficheclient.fxml"));
            //  Parent root  = loader.load();
            Scene  scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Les Clients");
            window.setScene(scene);
            window.show();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } 
    }

    @FXML
    private void VideoPlayer(ActionEvent event) {
        
        String path="C:\\Users\\belha\\Downloads\\tuto.mp4";
//            

        Media media = new Media(new File(path).toURI().toString());  
          
        //Instantiating MediaPlayer class   
        MediaPlayer mediaPlayer = new MediaPlayer(media);  
          
        //Instantiating MediaView class   
        MediaView mediaView = new MediaView(mediaPlayer);  
      
        //by setting this property to true, the Video will be played   
        mediaPlayer.setAutoPlay(true);
        

        Group root = new Group();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.setTitle("video");
        window.show();


            
            //  Parent root  = loader.load();
       
           
           
        
        
    }
    
}
