/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import edu.esprit.entities.coach;
import edu.esprit.tools.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import edu.esprit.services.CoachCRUD;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Mokhtar
 */
public class CoachDetailsController implements Initializable {

    private TextField contnom;
    private TextField contprenom;
    private TextField contgenre;
    private TextField contdisponabilité;
    private TextField conttype;
    private TextField contlocalisation;
    @FXML
    private TableView<coach> colcoach;
    @FXML
    private TableColumn<coach, Integer> colid;
    @FXML
    private TableColumn<coach, String> colnom;
    @FXML
    private TableColumn<coach, String> colprenom;
    @FXML
    private TableColumn<coach, String> colgenre;
    @FXML
    private TableColumn<coach, String> coldisponabilité;
    @FXML
    private TableColumn<coach, String> coltype;
    @FXML
    private TableColumn<coach ,String> collocalisation;
    CoachCRUD coach1 = new CoachCRUD();
    ObservableList<coach> listcoach;
    @FXML
    private Button idsupprimer;
    @FXML
    private Button bref;
    @FXML
    private Button idretour;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            // TODO
            
            
            
            listcoach = (ObservableList<coach>) coach1.listecoach();
            
            
           
            colid.setCellValueFactory(new PropertyValueFactory<>("Idcoach"));
            colnom.setCellValueFactory(new PropertyValueFactory<>("Nomcoach"));
            colprenom.setCellValueFactory(new PropertyValueFactory<>("Prenomcoach"));
            colgenre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
            coldisponabilité.setCellValueFactory(new PropertyValueFactory<>("Disponabilite"));
            coltype.setCellValueFactory(new PropertyValueFactory<>("Typesesport"));
            collocalisation.setCellValueFactory(new PropertyValueFactory<>("Localisation"));
            
             colcoach.setItems(listcoach);
        } catch (SQLException ex) {
            System.out.println("hhhhhh ");
        }
            
            
    }    

    @FXML
    private void supprimercoach(ActionEvent event) {
        coach suppcoch =(coach) colcoach.getSelectionModel().getSelectedItem();
        coach1.suupcoach(suppcoch.getIdcoach());
        resetTableData();
    }

    private void resetTableData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void Actualiserpage(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("CoachDetails.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
            window.setTitle("Admin page");
            window.setScene(scene);
            window.show();
    }

    @FXML
    private void retourner(ActionEvent event) throws IOException {
         Parent loader = FXMLLoader.load(getClass().getResource("AddCoach.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
           // window.setTitle("Admin page");
            window.setScene(scene);
            window.show();
    }

    @FXML
    private void updatedelete(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("modifiercoach.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
           // window.setTitle("Admin page");
            window.setScene(scene);
            window.show();
        
    }
    
    

}      
        
    
 

//   public void setContnom(String nom) {
//        this.contnom.setText(nom);
//   }
//
//    public void setContprenom(String prenom) {
//        this.contprenom.setText(prenom);
//    }
//
//    public void setContgenre(String genre) {
//        this.contgenre.setText(genre);
//    }
//
//    public void setContdisponabilité(String disponabilité) {
//        this.contdisponabilité.setText(disponabilité);
//    }
//
//    public void setConttype(String type) {
//        this.conttype.setText(type);
//    }
//
//    public void setContlocalisation(String localisation) {
//        this.contlocalisation.setText(localisation);
//    }
//
//    
//}  
//
//
//

