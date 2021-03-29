/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Client;
import Entities.DonnéesLocales;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author belha
 */
public class DetailsClientController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField sexe;
    @FXML
    private TextField dateNaissance;
    @FXML
    private TextField Addresse;
    @FXML
    private TextField handicap;
    @FXML
    private TextField DesHandicap;
    @FXML
    private TextField Tel;
    @FXML
    private TextField Email;
    @FXML
    private TextField ID;
    @FXML
    private Button QR;
    
    Client CLmod = DonnéesLocales.getClient();
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID.setText(String.valueOf(CLmod.getID()));
        nom.setText(CLmod.getNom());
        prenom.setText(CLmod.getPrenom());
        sexe.setText(CLmod.getSexe());
        dateNaissance.setText(CLmod.getDateNaissance());
        Email.setText(CLmod.getEmail());
        Addresse.setText(CLmod.getAdresse());
        handicap.setText(String.valueOf(CLmod.isHandicap()));
        DesHandicap.setText(CLmod.getDesHandicap());
        Tel.setText(String.valueOf(CLmod.getTel()));
    }    

    @FXML
    private void CreateQR(ActionEvent event) {
        
        
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        
        String id =ID.getText();
        String name =nom.getText();
        String pname = prenom.getText();
        String myWeb = id +" "+ name +" "+ pname;
              
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success...");
            
        } catch (WriterException ex) {
            Logger.getLogger(JavaFX_QRCodeWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
        StackPane root = new StackPane();
        root.getChildren().add(qrView);
        
        Scene scene = new Scene(root);
        Stage stage= new Stage();
        
        stage.setTitle("This is your QR code!");
        stage.setScene(scene);
        stage.show();
        
        
//        try {
//            MyConnectivity obj_DBConnection = new MyConnectivity();
//            Connection connection = obj_DBConnection.getConnexion();
//            String query = "select * from client";
//            Statement stmt = null;
//            stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//            	DetailsClientController.generate_qr(rs.getString("ID"),rs.getString("Nom"));
//            }
//            
//            String title ="Code QR créé avec succés.";
//               TrayNotification notif=new TrayNotification();
//                AnimationType Type =AnimationType.POPUP;
//                
//                notif.setAnimationType(Type);    
//                notif.setTitle(title);
//                notif.setNotificationType(NotificationType.SUCCESS);
//                notif.showAndDismiss(javafx.util.Duration.millis(3000));
//                afficherQr();
//		} 
//        catch (SQLException e) {
//			         
//            System.err.println(e);
//            }
        

    }
    
//    public static void generate_qr(String image_name,String qrCodeData) {
//        try {
//            String filePath = "C:\\QRcode\\"+image_name+".png";
//            String charset = "UTF-8"; // or "ISO-8859-1"
//            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
//            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
//            BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
//                BarcodeFormat.QR_CODE, 200, 200, hintMap);
//            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
//                    .lastIndexOf('.') + 1), new File(filePath));
//            System.out.println("QR Code image created successfully!");
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//    }
    

    @FXML
    private void GoBack(ActionEvent event) {
        
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
