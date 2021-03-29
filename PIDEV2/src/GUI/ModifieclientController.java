/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Client;
import Entities.DonnéesLocales;
import Services.CRUD;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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
public class ModifieclientController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField email;
    @FXML
    private TextField prenom;
    @FXML
    private TextField adresse;
    @FXML
    private TextField deshandicap;
    @FXML
    private TextField tel;
    @FXML
    private DatePicker datenaissance ;
    @FXML
    private ComboBox sexe;
    @FXML
    private Button confirmupdate;
    
    Client CLmod = DonnéesLocales.getClient();
    Client newCL = new Client();
    @FXML
    private Button Back;
    

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
        initializeAll(); 
    } 
    
    public void initializeAll(){
        
        nom.setText(CLmod.getNom());
        prenom.setText(CLmod.getPrenom());
        email.setText(CLmod.getEmail());
        adresse.setText(CLmod.getAdresse());
        deshandicap.setText(CLmod.getDesHandicap());
        tel.setText(String.valueOf(CLmod.getTel()));
        
        
    }

    @FXML
    private void ConfirmerModifierClient(ActionEvent event) {
        Client c = new Client();        
        
        c.setNom(nom.getText());
        c.setPrenom(prenom.getText());
        c.setSexe((String) sexe.getSelectionModel().getSelectedItem());
        c.setDateNaissance(datenaissance.getValue().toString());
        c.setEmail(email.getText());
        c.setAdresse(adresse.getText());
        c.setDesHandicap(deshandicap.getText());
        c.setTel(Integer.parseInt(tel.getText()));
        
        CRUD.updateClient(CLmod,c);
        
        String title ="Client modifié avec succés";
               TrayNotification notif=new TrayNotification();
                AnimationType Type =AnimationType.POPUP;
                
                notif.setAnimationType(Type);    
        notif.setTitle(title);
        notif.setNotificationType(NotificationType.INFORMATION);
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
    private void AnnulerModif(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Annulation");
            alert.setHeaderText("Voulez-vous vraiment annuler la modification de ce client ?");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            
    if (result.get() == ButtonType.OK){           
        
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
        
    else {
            try {
            Parent loader = FXMLLoader.load(getClass().getResource("modifieclient.fxml"));
            //  Parent root  = loader.load();
            Scene  scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Modifier le client");
            window.setScene(scene);
            window.show();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } 
        }
    }
        
            
    
}
