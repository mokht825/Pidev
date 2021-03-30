/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import com.sun.javafx.scene.control.skin.TextFieldSkin;
import edu.esprit.entities.coach;
import edu.esprit.services.CoachCRUD;
import edu.esprit.gui.ModifiercoachController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;


/**
 * FXML Controller class
 *
 * @author Mokhtar
 */
public class AddCoachController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private ComboBox tfgenre;
    @FXML
    private TextField tfdisponabilité;
    @FXML
    private ComboBox tftype;
    @FXML
    private ComboBox tflocalisation;
    @FXML
    private Button btnajouter;
    @FXML
    private AnchorPane root;
    @FXML
    private Button idavance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> genrelist = FXCollections.observableArrayList("homme","femme");
        ObservableList<String> typelist = FXCollections.observableArrayList( "caraté","congfu","zoomba","crafmaga" ,"box","gymnastique","swimming");
        tfgenre.setItems(genrelist);
        tfgenre.setPromptText("indiquez le genre");
        ObservableList<String> localist = FXCollections.observableArrayList("ariana","béja","ben arous"
        ,"bizerte","gabes","gafsa","jendouba","kairouan","kasserine","kébilli","le kef","mahdia","la manouba","médenine"
        ,"mnastir","nabeul","sfax","sidi bouzid","siliana","sousse","tataouine","tozeur","tunis","zagouane","manzel bouzelfa nabeul tunisie"
        ,"cité al ghazela ariana tunisie");
        tflocalisation.setItems(localist);
        
        tftype.setItems(typelist);
        tflocalisation.setPromptText("indiquez la localisation");
        tftype.setPromptText("indiquez le type de sport");
        String[] possiblewords ={"lundi","lu","lun","lund","ma","mar","mard","mardi","me",
            "mer","merc","mercr","mercre","mercred","mercredi","je","jeu","jeud","jeudi","ve","ven","vend",
            "vendr","vendre","vendre","vendred","vendredi","sa","sam","same","samed","samedi",
            "di","dim","dima","diman","dimanc","dimanch","dimanche","lundi et","mardi et","mercredi et","jeudi et","vendredi et"
        ,"samedi et","dimanche et","lundi et mardi","lundi et mercredi","lundi et jeudi","lunndi et vendredi","lundi et samedi",
        "lundi et dimanche","mardi et mercredi","mardi et jeudi","mardi et vendredi","mardi et samedi","mardi et dimache",
        "mercredi et jeudi","mercredi et vendredi","mercredi et samedi","mercredi et dimanche","jeudi et vendredi",
        "jeudi et samedi","jeudi et dimanche","vendredi et samedi","vendredi et dimanche","samedi et dimanche"};
        String[] noms ={"mokhtar","mouin","mouhib","mondher","mo","mon","ahmed","amani","asma","aroua"};
        String[] prenoms={"bechaib","bech","taib","Abbée",	"Aïcha","Aliseto","Amele","Annah","Aria","Audréanne",
 "Abby","Aïda",	"Alison","Ameli","Annaïc","Ariana","Audrée",
"Abélia","Aidana","Alisonne","Amélia","Annaïck","Ariane","Audrena"};
        String[] type={"zo","zoom","zoomba","ca","car","caraté","te","tek","tekwa","tekwando","bo","box","cr","cra","craf","crafma"
                ,"crafmaga"};


        TextFields.bindAutoCompletion(tfdisponabilité, possiblewords);
        TextFields.bindAutoCompletion(tfnom, noms);
        TextFields.bindAutoCompletion(tfprenom, prenoms);
        
        
        
        // TODO
    }    

    @FXML
    private void ajoutercoach(ActionEvent event) throws IOException {
        //1- SAVE COACH IN DATABASE
            String rNom= tfnom.getText();
            String rPrenom= tfprenom.getText();
            String rGenre= (String)tfgenre.getSelectionModel().getSelectedItem();
            String rDisponabilté= tfdisponabilité.getText();
            String rType= (String)tftype.getSelectionModel().getSelectedItem();
            String rLocalisation= (String)tflocalisation.getSelectionModel().getSelectedItem();
            coach c = new coach(123, rNom, rPrenom, rGenre, rDisponabilté, rType, rLocalisation);
            CoachCRUD ccd =new CoachCRUD();
            
            if(tfnom.getText().trim().isEmpty()||tfprenom.getText().trim().isEmpty()||
                    tfdisponabilité.getText().trim().isEmpty())
            {
        Alert fail= new Alert(AlertType.ERROR);
        fail.setHeaderText("failure");
        fail.setContentText("Vous devez saisir tous les données!");
        fail.showAndWait();}
            
            else{
              ccd.addCoach(c);   
            JOptionPane.showMessageDialog(null, "coach ajouter", "ajout",1 );
       Parent loader = FXMLLoader.load(getClass().getResource("CoachDetails.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
            window.setTitle("Admin page");
            window.setScene(scene);
            window.show(); }    
    /*        //2- REDIRECTION
            
            
            
            FXMLLoader loader=new FXMLLoader(
                    getClass().getResource("CoachDetails.fxml"));
        try {
            Parent root = loader.load();
            CoachDetailsController cdc = loader.getController();
            cdc.setContnom(rNom); // injecter les variables de première formulaire
            cdc.setContprenom(rPrenom);
            cdc.setContgenre(rGenre);
            cdc.setContdisponabilité(rDisponabilté);
            cdc.setConttype(rType);
            cdc.setContlocalisation(rLocalisation);
            tfnom.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
            
      }*/
    // Image img = new Image("validation.png");
      Notifications notificationBuilder = Notifications.create()
                
                        .title("coach Ajoutée")
                        .text("Saved in your DATABASE")
         //    .graphic(new ImageView(img))
    .graphic(null)
                        .hideAfter(Duration.seconds(5))
                        .position(Pos.TOP_RIGHT)
                        .onAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               System.out.println("Clicked on notification");
            }
        });
                notificationBuilder.darkStyle();
                notificationBuilder.showConfirm();
              
     
    
    
}

    @FXML
    private void avance(ActionEvent event) throws IOException {
         Parent loader = FXMLLoader.load(getClass().getResource("CoachDetails.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
            window.setTitle("Admin page");
            window.setScene(scene);
            window.show(); }    
        
    
}
