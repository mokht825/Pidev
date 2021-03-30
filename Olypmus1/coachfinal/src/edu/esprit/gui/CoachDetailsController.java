/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.esprit.entities.coach;
import edu.esprit.tools.MyConnection5;
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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
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
    @FXML
    private TextField ftid;
    @FXML
    private TextField ftnom;
    @FXML
    private TextField ftprenom;
    @FXML
    private TextField ftgenre;
    @FXML
    private TextField ftdisponibilité;
    @FXML
    private TextField fttype;
    @FXML
    private TextField ftlocalisation;
    @FXML
    private Button ftmodifier;
    @FXML
    private TextField filterField;
    @FXML
    private Button ftMail;
    @FXML
    private TextField emailToField;
    @FXML
    private Button sendemailbutton;
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
    private void supprimercoach(ActionEvent event) throws IOException {
        coach suppcoch =(coach) colcoach.getSelectionModel().getSelectedItem();
        coach1.suupcoach(suppcoch.getIdcoach());
        //resetTableData();
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete coach");
            alert.setHeaderText("information");
            alert.setContentText("VOULEZ VRAIMENT SUPPRIMER CE COACH");
            alert.showAndWait();
        Actualiserpage(event);
       
       
        
        
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
             JOptionPane.showMessageDialog(null, "page actualisé", "refresh",1 );
           
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

    @FXML
    private void handelmouseaction(MouseEvent event) {
           coach c1 =(coach) colcoach.getSelectionModel().getSelectedItem();
        ftid.setText(""+c1.getIdcoach());
        ftnom.setText(""+c1.getNomcoach());
        ftprenom.setText(""+c1.getPrenomcoach());
        ftgenre.setText(""+c1.getGenre());
        ftdisponibilité.setText(""+c1.getDisponabilite());
        fttype.setText(""+c1.getTypesesport());
        ftlocalisation.setText(""+c1.getLocalisation());
    }
@FXML
    public void recherche() throws SQLException{
    CoachCRUD re= new CoachCRUD() ;
    List<coach>results = new ArrayList<>();
    results = re.listecoach();
     FilteredList<coach> filteredData = new FilteredList<>(listcoach , b -> true);
		coach r = new coach();
		// 2. Set the filter Predicate whenever the filter changes.
		filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate((coach coachs) -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (coachs.getDisponabilite().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (coachs.getGenre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				} else if (coachs.getPrenomcoach().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (coachs.getNomcoach().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (coachs.getGenre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}else if (coachs.getLocalisation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
                                } else if(coachs.getTypesesport().toLowerCase().indexOf(lowerCaseFilter) != -1 ){
                                    return true;
				}
				else if (String.valueOf(r.getGenre()).indexOf(lowerCaseFilter)!=-1)
				     return true;
                                else if (String.valueOf(r.getGenre()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<coach> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(colcoach.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		colcoach.setItems(sortedData);
               
        
    }
  

    @FXML
    private void modifiercoach(ActionEvent event) throws IOException {
         String sid =ftid.getText();
        int id =Integer.parseInt(sid);
       
        String txtnom =ftnom.getText();
        String txtprenom =ftprenom.getText();
        String txtgenre =ftgenre.getText();
        String txtdisponibilité =ftdisponibilité.getText();
        String txttype =fttype.getText();
        String txtlocalisation =ftlocalisation.getText();
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
          
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Update coach");
            alert.setHeaderText("information");
            alert.setContentText("voulez vous vraiment  modifier ce coach!");
            alert.showAndWait();
            Parent loader = FXMLLoader.load(getClass().getResource("CoachDetails.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
            window.setTitle("Admin page");
            window.setScene(scene);
            window.show();
             JOptionPane.showMessageDialog(null, "coach bien modifié", "modifier coach",1 );
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Add coach");
            alert.setHeaderText("information");
            alert.setContentText("coach nom modifié!");
            alert.showAndWait();
             
           
        }
    }
      @FXML
    public void buttonclicked() throws SQLException{
    senemail();
    if (emailToField.getText().trim().isEmpty())
         {
        Alert fail= new Alert(Alert.AlertType.ERROR);
        fail.setHeaderText("failure");
        fail.setContentText("Vous devez saisir un mail valide!");
        fail.showAndWait();}
    else{
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ajout un nouveaux coach");
            alert.setHeaderText("information");
            alert.setContentText("message envoyée");
            alert.showAndWait();
    }
    }
    public void senemail() throws SQLException{
      //String req="Select User_Email from 'membres' where User_nom='user.getText()'"; 
     // Statement st = cnx.createStatement();
         //   ResultSet rs = st.executeQuery(req);
 //String r = emailToField.getText();
  String to = emailToField.getText();
 String from = "mokhtar.becheib@esprit.tn"; 
 final String username="mokhtar.becheib@esprit.tn";
 final String password="Mokh98745632";
   
 String host = "smtp.google.com";
 
       Properties props = new Properties();
         props.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        props.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        props.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        props.put("mail.smtp.port", "587");
  Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
  try {
      MimeMessage m = new MimeMessage(session);
      m.setFrom(new InternetAddress(from));
      m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
      m.setSubject("nouveaux coach Foot-Plus");
      m.setText("votre inscription au salle de sport est en cours de traitement");      
      
      
      Transport.send(m);
      System.out.println("message envoyé");
      
  } catch (MessagingException e){
  e.printStackTrace();
  }
  }
     @FXML
    private void Mailing(ActionEvent event) {
        ftMail.getScene().getWindow().hide();

        try {
            Stage stage = new Stage();
            stage.setTitle("Consultation");
            Parent root = FXMLLoader.load(getClass().getResource("Stats.fxml"));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

   @FXML
    private void pdfs(ActionEvent event) throws SQLException, ClassNotFoundException, DocumentException, FileNotFoundException 
    {
     
        try {
           Class.forName("com.mysql.jdbc.Driver");
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pidev", "root", "");
  Statement stmt = conn.createStatement();
                    /* Define the SQL query */
                    
                  //  coach ctd = new coach();
                    ResultSet query_set = stmt.executeQuery("SELECT * From coach");
                   
                    /* Step-2: Initialize PDF documents - logical objects */
                    Document my_pdf_report = new Document();
                    PdfWriter.getInstance(my_pdf_report, new FileOutputStream("/Users/Mokhtar/Desktop/pdf_report_from_sql_using_java.pdf"));
                    my_pdf_report.open();            
                    //we have four columns in our table
                    PdfPTable my_report_table = new PdfPTable(6);
                    //create a cell object
                    PdfPCell table_cell;

                    while (query_set.next()) {                
                                   /* int id = query_set.getInt("Idcoach");
                                    table_cell=new PdfPCell(new Phrase(id));
                                    my_report_table.addCell(table_cell);*/
                                    String Nom=query_set.getString("Nomcoach");
                                    table_cell=new PdfPCell(new Phrase(Nom));
                                    my_report_table.addCell(table_cell);
                                    String Prenom=query_set.getString("Prenomcoach");
                                    table_cell=new PdfPCell(new Phrase(Prenom));
                                    my_report_table.addCell(table_cell);
                                    String genre=query_set.getString("Genre");
                                    table_cell=new PdfPCell(new Phrase(genre));
                                    my_report_table.addCell(table_cell);
                                    String disponibilité=query_set.getString("Disponabilite");
                                    table_cell=new PdfPCell(new Phrase(disponibilité));
                                    my_report_table.addCell(table_cell);
                                    String Type =query_set.getString("Typesesport");
                                    table_cell=new PdfPCell(new Phrase(Type));
                                    my_report_table.addCell(table_cell);
                                    String localisation=query_set.getString("Localisation");
                                    table_cell=new PdfPCell(new Phrase(localisation));
                                    my_report_table.addCell(table_cell);
                                    }
                    /* Attach report table to PDF */
                    my_pdf_report.add(my_report_table);                       
                    my_pdf_report.close();

                    /* Close all DB related objects */
                    query_set.close();
                    stmt.close(); 
                    conn.close();   
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("convertition pdf");
            alert.setHeaderText("information");
            alert.setContentText("conversion terminé le tableaux est enregistrée sur votre bureaux !");
            alert.showAndWait();



    } catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    } catch (DocumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
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

