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
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterAttributes;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.transform.Scale;
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
public class AfficheclientController implements Initializable {

    @FXML
    private TableView<Client> tableclient;
    @FXML
    private TableColumn<Client, Integer> idcol;
    @FXML
    private TableColumn<Client, String> nomcol;
    @FXML
    private TableColumn<Client, String> prenomcol;
    @FXML
    private TableColumn<Client, String> sexecol;
    @FXML
    private TableColumn<Client, String> datenaissancecol;
    @FXML
    private TableColumn<Client, String> emailcol;
    @FXML
    private TableColumn<Client, String> adressecol;
    @FXML
    private TableColumn<Client, Boolean> handicapcol;
    @FXML
    private TableColumn<Client, String> deshandicapcol;
    @FXML
    private TableColumn<Client, Integer> telcol;
    @FXML
    private Button delete;
    @FXML
    private Button update;
    @FXML
    private Button addother;
    @FXML
    private TextField rechercherClient;
    @FXML
    private Button impression;
    @FXML
    private Button Details;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CRUD cd = new CRUD();
        ObservableList<Client> ListeClient = cd.getClient();
        idcol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        nomcol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        prenomcol.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        sexecol.setCellValueFactory(new PropertyValueFactory<>("Sexe"));
        datenaissancecol.setCellValueFactory(new PropertyValueFactory<>("DateNaissance"));
        emailcol.setCellValueFactory(new PropertyValueFactory<>("Email"));
        adressecol.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        handicapcol.setCellValueFactory(new PropertyValueFactory<>("Handicap"));
        deshandicapcol.setCellValueFactory(new PropertyValueFactory<>("DesHandicap"));
        telcol.setCellValueFactory(new PropertyValueFactory<>("Tel")) ;
        tableclient.setItems(ListeClient);
        
    }    

    @FXML
    private void SupprimerClient(ActionEvent event) throws IOException {
        Client c = (Client)tableclient.getSelectionModel().getSelectedItem();
        if (c == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erruer !");
            alert.setHeaderText("Aucun élément n'est sélectionné.");
            alert.setContentText(" Veuillez sélectionner le Client à supprimer.");

            alert.showAndWait();
            
        }
        else{
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer ce client ?");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK){
                CRUD cd = new CRUD();
                cd.deleteClient(c.getID());
                String title ="Client supprimé avec succés";
                TrayNotification notif=new TrayNotification();
                AnimationType Type =AnimationType.POPUP;
                
                notif.setAnimationType(Type);    
                notif.setTitle(title);
                notif.setNotificationType(NotificationType.WARNING);
                notif.showAndDismiss(javafx.util.Duration.millis(3000));
                
            Parent loader = FXMLLoader.load(getClass().getResource("afficheclient.fxml"));
            //  Parent root  = loader.load();
            Scene  scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Les Clients");
            window.setScene(scene);
            window.show();
    
            }          
            else {
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

    }
                
}

    
    @FXML
    private void ModifierClient(ActionEvent event) {

        Client newc = tableclient.getSelectionModel().getSelectedItem();        
        if (newc == null) {
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erruer !");
            alert.setHeaderText("Aucun élément n'est sélectionné.");
            alert.setContentText(" Veuillez sélectionner le Client à modifier.");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Modification");
            alert.setHeaderText("Voulez-vous vraiment modifier ce client ?");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            
            if (result.get() == ButtonType.OK){
            try {
                
                Client c = new Client();
                
                c.setID(newc.getID());
                c.setNom(newc.getNom());
                c.setPrenom(newc.getPrenom());
                c.setSexe(newc.getSexe());
                c.setDateNaissance(newc.getDateNaissance());
                c.setEmail(newc.getEmail());
                c.setAdresse(newc.getAdresse());
                c.setDesHandicap(newc.getDesHandicap());
                c.setTel(newc.getTel());
                
                DonnéesLocales.setClient(c);
                
                Parent loader = FXMLLoader.load(getClass().getResource("modifieclient.fxml"));
                //  Parent root  = loader.load();
                Scene scene = new Scene(loader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Modifier le client");
                window.setScene(scene);
                window.show();
            }
             catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
            }
            else{
                
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

    }
}
    
        
        
    

    @FXML
    private void AjouterAutreClient(ActionEvent event) {
        try {
            Parent loader = FXMLLoader.load(getClass().getResource("ajoutclient.fxml"));
            //  Parent root  = loader.load();
            Scene  scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Ajouter Clients");
            window.setScene(scene);
            window.show();
            
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } 
    }

//    private void resetTableData() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @FXML
    private void Search(KeyEvent event) {
        CRUD cd = new CRUD();
        ObservableList<Client> ListeClient = cd.getClient();
        FilteredList<Client> filterData = new FilteredList<>(ListeClient, p -> true);
        rechercherClient.textProperty().addListener((obsevable, oldvalue, newvalue) -> {
            filterData.setPredicate(pers -> {

                if (newvalue == null || newvalue.isEmpty()) {
                    return true;
                }
                String typedText = newvalue.toLowerCase();
               
                 if (String.valueOf(pers.getID()).toLowerCase().indexOf(typedText) != -1) {

                    return true;
                } 
                
                if (pers.getNom().toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                if (pers.getPrenom().toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                if (pers.getSexe().toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                if (pers.getDateNaissance().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getEmail().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                if (pers.getAdresse().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                
                if (pers.getDesHandicap().toLowerCase().indexOf(typedText) != -1) {
                    return true;
                }
                
                 if (String.valueOf(pers.getTel()).toLowerCase().indexOf(typedText) != -1) {

                    return true;
                }
                 
                  
                
                
                return false;
            });
            SortedList<Client> sortedList = new SortedList<>(filterData);
            sortedList.comparatorProperty().bind(tableclient.comparatorProperty());
            tableclient.setItems(sortedList);
                       
            
        });
    }

    @FXML
    private void Imprimer(ActionEvent event) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        
        printNode(tableclient);
    }
    
    public static void printNode(final Node node) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    Printer printer = Printer.getDefaultPrinter();
    PageLayout pageLayout
        = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
    PrinterAttributes attr = printer.getPrinterAttributes();
    PrinterJob job = PrinterJob.createPrinterJob();
    double scaleX
        = pageLayout.getPrintableWidth() / node.getBoundsInParent().getWidth();
    double scaleY
        = pageLayout.getPrintableHeight() / node.getBoundsInParent().getHeight();
    Scale scale = new Scale(scaleX, scaleY);
    node.getTransforms().add(scale);

    if (job != null && job.showPrintDialog(node.getScene().getWindow())) {
      boolean success = job.printPage(pageLayout, node);
      if (success) {
        job.endJob();

      }
    }
    node.getTransforms().remove(scale);
    }

    @FXML
    private void ShowDets(ActionEvent event) {
        
        Client newc = tableclient.getSelectionModel().getSelectedItem();
        
        if (newc == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erruer !");
            alert.setHeaderText("Aucun élément n'est sélectionné.");
            alert.setContentText(" Veuillez sélectionner le Client pour voir ses détails.");

            alert.showAndWait();
            
        }
        else {
            try {
                
                Client c = new Client();
                
                c.setID(newc.getID());
                c.setNom(newc.getNom());
                c.setPrenom(newc.getPrenom());
                c.setSexe(newc.getSexe());
                c.setDateNaissance(newc.getDateNaissance());
                c.setEmail(newc.getEmail());
                c.setAdresse(newc.getAdresse());
//                c.setHandicap(newc.isHandicap());
                c.setDesHandicap(newc.getDesHandicap());
                c.setTel(newc.getTel());
                
                DonnéesLocales.setClient(c);
                
                Parent loader = FXMLLoader.load(getClass().getResource("DetailsClient.fxml"));
                //  Parent root  = loader.load();
                Scene scene = new Scene(loader);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setTitle("Les détails du client");
                window.setScene(scene);
                window.show();

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

    }
    }
    
//    @FXML
//    private void Actualiser(ActionEvent event) {
//        try {
//            Parent loader = FXMLLoader.load(getClass().getResource("afficheclient.fxml"));
//            //  Parent root  = loader.load();
//            Scene  scene = new Scene(loader);
//            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            window.setTitle("Les Clients");
//            window.setScene(scene);
//            window.show();
//            
//        } catch (IOException ex) {
//            System.err.println(ex.getMessage());
//        } 
//    }

    

}
    


    

