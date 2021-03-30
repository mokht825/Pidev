/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.coach;
import edu.esprit.tools.MyConnection5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Mokhtar
 */
public class CoachCRUD {
     private Statement ste;
      PreparedStatement pst;

    public void addCoach(coach c) {
        String requete = "INSERT INTO coach (Nomcoach,Prenomcoach,Genre,Disponabilite,Typesesport,Localisation)"
                + "VALUES (?,?,?,?,?,?)";
        try {
            pst= new MyConnection5().cn.prepareStatement(requete);

            
            pst.setString(1, c.getNomcoach());
            pst.setString(2, c.getPrenomcoach());
            pst.setString(3, c.getGenre());
            pst.setString(4, c.getDisponabilite());
            pst.setString(5, c.getTypesesport());
            pst.setString(6, c.getLocalisation());
            pst.executeUpdate();
            System.out.println("coach ajouté!");
        } catch (SQLException ex) {
            Logger.getLogger(CoachCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 
    }
    public int getNbrcongfu() {
        String sql="SELECT COUNT(*) FROM `coach` where Typesesport='congfu'";
        ResultSet rs;
        int countIdFed=0;
        try {
            pst= new MyConnection5().cn.prepareStatement(sql);
			ResultSet res= pst.executeQuery(); 
                        while(res.next()) {
                           countIdFed= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdFed;
    }
     
    public int getNbrcarat() {
        String sql="SELECT COUNT(*) FROM `coach` where Typesesport='caraté'";
        ResultSet rs;
        int countIdFed=0;
        try {
            pst= new MyConnection5().cn.prepareStatement(sql);
			ResultSet res= pst.executeQuery(); 
                        while(res.next()) {
                           countIdFed= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdFed;
    }public int getNbrcrafmaga() {
        String sql="SELECT COUNT(*) FROM `coach` where Typesesport='crafmaga'";
        ResultSet rs;
        int countIdFed=0;
        try {
            pst= new MyConnection5().cn.prepareStatement(sql);
			ResultSet res= pst.executeQuery(); 
                        while(res.next()) {
                           countIdFed= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdFed;
    }
    public int getNbgym() {
        String sql="SELECT COUNT(*) FROM `coach` where Typesesport='gymnastique'";
        ResultSet rs;
        int countIdFed=0;
        try {
            pst= new MyConnection5().cn.prepareStatement(sql);
			ResultSet res= pst.executeQuery(); 
                        while(res.next()) {
                           countIdFed= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdFed;
    }
    public int getNbrzoomba() {
        String sql="SELECT COUNT(*) FROM `coach` where Typesesport='zoomba'";
        ResultSet rs;
        int countIdFed=0;
        try {
            pst= new MyConnection5().cn.prepareStatement(sql);
			ResultSet res= pst.executeQuery(); 
                        while(res.next()) {
                           countIdFed= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdFed;
    }
     public int getNbrswim() {
        String sql="SELECT COUNT(*) FROM `coach` where Typesesport='swimming'";
        ResultSet rs;
        int countIdFed=0;
        try {
            pst= new MyConnection5().cn.prepareStatement(sql);
			ResultSet res= pst.executeQuery(); 
                        while(res.next()) {
                           countIdFed= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdFed;
    }
    public int getNbrbox() {
        String sql="SELECT COUNT(*) FROM `coach` where Typesesport='box'";
        ResultSet rs;
        int countIdFed=0;
        try {
            pst= new MyConnection5().cn.prepareStatement(sql);
			ResultSet res= pst.executeQuery(); 
                        while(res.next()) {
                           countIdFed= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdFed;
    }
    
    
         public void suupcoach(int  Idcoach){
             
                
         try {
               String  requete3 ="DELETE FROM coach where Idcoach = "+Idcoach;
                 PreparedStatement pst=
                         new MyConnection5().cn.prepareStatement(requete3);
             pst.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(CoachCRUD.class.getName()).log(Level.SEVERE, null, ex);
         }
                 System.out.println("coach supprimé");
            
             }
         public static int update(coach ctd){
             int co =0;
             try {
                 String sql="UPDATE coach SET Nomcoach =?,Prenomcoach=?, Genre=?,Disponabilite=?,Typesesport=?,Localisation=? WHERE Idcoach =?";
                 PreparedStatement pst=
                         new MyConnection5().cn.prepareStatement(sql);
                  
            pst.setString(1, ctd.getNomcoach());
            pst.setString(2, ctd.getPrenomcoach());
            pst.setString(3, ctd.getGenre());
            pst.setString(4, ctd.getDisponabilite());
            pst.setString(5, ctd.getTypesesport());
            pst.setString(6, ctd.getLocalisation());
            pst.setInt(7,ctd.getIdcoach());
                 
             co =pst.executeUpdate();
             
             } catch (SQLException e) {
               e.printStackTrace();
             }
           return co;  
         }
         public static coach getcoachs(int id){
             coach ctd = new coach();
             try {
                  String sql2="SELECT * FROM coach WHERE Idcoach=?";
                  PreparedStatement pst=
                         new MyConnection5().cn.prepareStatement(sql2);
                  pst.setInt(1, id);
                  ResultSet rst =pst.executeQuery();
                  if (rst.next()){
                      ctd.setIdcoach(rst.getInt(1));
                      ctd.setNomcoach(rst.getString(2));
                      ctd.setPrenomcoach(rst.getString(3));
                      ctd.setGenre(rst.getString(4));
                      ctd.setDisponabilite(rst.getString(5));
                      ctd.setTypesesport(rst.getString(6));
                      ctd.setLocalisation(rst.getString(7));
                  }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
            
           return ctd;  
         }
         
   
     public List<coach> listecoach() throws SQLException 
    {
        System.out.println("mochkla fil lister tout");
      String sql = "SELECT * FROM coach ";
        ObservableList<coach> listType = FXCollections.observableArrayList();
       
        PreparedStatement pste=new MyConnection5().cn.prepareStatement(sql);
        ResultSet result = pste.executeQuery();
     
        try {
            

        while (result.next()){
  
            listType.add(new coach(result.getInt("Idcoach"),result.getString("Nomcoach"),result.getString("Prenomcoach"),result.getString("Genre"),result.getString("Disponabilite"),result.getString("Typesesport"),result.getString("Localisation")));
             
          
            
        }
      
      } catch (SQLException ex) {
           System.out.println("Mokhlq fil lister type");
              
    }
     
      
      
    return (listType);

    }
}


