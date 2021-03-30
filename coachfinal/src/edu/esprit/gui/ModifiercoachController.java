/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.coach;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import edu.esprit.services.CoachCRUD;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.controlsfx.control.textfield.TextFields;


/**
 * FXML Controller class
 *
 * @author Mokhtar
 */
public class ModifiercoachController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField genre;
    @FXML
    private TextField disponibilté;
    @FXML
    private TextField type;
    @FXML
    private TextField localisation;
    @FXML
    private TextField IdE;
    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int[] recherche= {1,11,2,265,547,1,2,54,125,1254};
          TextFields.bindAutoCompletion(IdE, recherche);
        // TODO
    }    

    @FXML
    private void getCoachs1(ActionEvent event) {
        String sid =IdE.getText();
        int id =Integer.parseInt(sid);
        coach std=CoachCRUD.getcoachs(id);
        nom.setText(std.getNomcoach());
        prenom.setText(std.getPrenomcoach());
        genre.setText(std.getGenre());
        disponibilté.setText(std.getDisponabilite());
        type.setText(std.getTypesesport());
        localisation.setText(std.getLocalisation());
        JOptionPane.showMessageDialog(null, "ce coach que vous voulez recherchez ?", "recherche",1 );
        JOptionPane.showMessageDialog(null, "recherche terminé", "recherche",1 );
    }

    @FXML
    private void UpdateCoachs(ActionEvent event) {
        String sid =IdE.getText();
        int id =Integer.parseInt(sid);
       
        String txtnom =nom.getText();
        String txtprenom =prenom.getText();
        String txtgenre =genre.getText();
        String txtdisponibilité =disponibilté.getText();
        String txttype =type.getText();
        String txtlocalisation =localisation.getText();
        coach  std=new coach();
        std.setIdcoach(id);
        std.setNomcoach(txtnom);
        std.setPrenomcoach(txtprenom);
        std.setGenre(txtgenre);
        std.setDisponabilite(txtdisponibilité);
        std.setTypesesport(txttype);
        std.setLocalisation(txtlocalisation);
        int status=CoachCRUD.update(std);
       if(status>0){
          
             Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Update coach");
            alert.setHeaderText("information");
            alert.setContentText("coach bien modifié!");
            alert.showAndWait();
        } else{
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Add coach");
            alert.setHeaderText("information");
            alert.setContentText("coach nom modifié!");
            alert.showAndWait();
             
         
        }
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("CoachDetails.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
           // window.setTitle("Admin page");
            window.setScene(scene);
            window.show();
    }
    
}
