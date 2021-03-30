/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.gui;


import edu.esprit.entities.coach;
import edu.esprit.services.CoachCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class StatsController implements Initializable {

    @FXML
    private BarChart<?, ?> rt;
    @FXML
    private NumberAxis x;
    @FXML
    private CategoryAxis y;
    @FXML
    private Label fd;
    @FXML
    private Button idretour;
    int sum =0;

    /**
     * Initializes the controller class.
     */
    
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         CoachCRUD o = new CoachCRUD();
        coach rc = new coach();
        BarChart.Series set1 = new BarChart.Series<>();
        set1.getData().add(new BarChart.Data("box",o.getNbrbox()));
        set1.getData().add(new BarChart.Data("congfu",o.getNbrcongfu()));
        set1.getData().add(new BarChart.Data("caraté",o.getNbrcarat()));
        set1.getData().add(new BarChart.Data("swimming",o.getNbrswim()));
        set1.getData().add(new BarChart.Data("zoomba",o.getNbrzoomba()));
        set1.getData().add(new BarChart.Data("gymnastique",o.getNbgym()));
        set1.getData().add(new BarChart.Data("crafmaga",o.getNbrcrafmaga()));
        rt.getData().addAll(set1);
        sum=o.getNbrbox()+o.getNbrcongfu()+o.getNbrcarat()+o.getNbrswim()+o.getNbrzoomba()+o.getNbgym()+o.getNbrcrafmaga();
        fd.setText("vous avez "+sum+" coachs");
            
        // TODO
    }    

    @FXML
    private void retourner(ActionEvent event) throws IOException {
         Parent loader = FXMLLoader.load(getClass().getResource("CoachDetails.fxml"));
            Scene scene = new Scene(loader);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // AdminPageController apc= loader.getController();
            window.setTitle("Admin page");
            window.setScene(scene);
            window.show(); }    
    
    
}
