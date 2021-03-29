/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Connectivity.MyConnectivity;
import Entities.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author belha
 */
public class CRUD {

    public static Client Clientget(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void addClient(Client c){
        try{
        String requete = "INSERT INTO client (Nom,Prenom,Sexe,DateNaissance,Email,Adresse,Handicap,DesHandicap,Tel)" 
                + "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = new MyConnectivity().cn.prepareStatement(requete);
            pst.setString(1,c.getNom());
            pst.setString(2, c.getPrenom());
            pst.setString(3, c.getSexe());
            pst.setString(4, c.getDateNaissance());
            pst.setString(5, c.getEmail());
            pst.setString(6, c.getAdresse());
            pst.setBoolean(7, c.isHandicap());
            pst.setString(8, c.getDesHandicap());
            pst.setInt(9, c.getTel());
            pst.executeUpdate();
            System.out.println("Client ajoutée");
        }
        catch (SQLException ex){
            System.err.println(ex.getMessage());
            System.out.println("Echec d'ajout");        
            
        }
    
}
    public ObservableList<Client> getClient(){
        ObservableList<Client> ListeClient = FXCollections.observableArrayList();
        
        
        try{
            String requete = " SELECT * FROM client";
            PreparedStatement pst = new MyConnectivity().cn.prepareStatement(requete);            
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                Client c = new Client();
                c.setID(rs.getInt(1));
                c.setNom(rs.getString(2));
                c.setPrenom(rs.getString(3));
                c.setSexe(rs.getString(4));
                c.setDateNaissance(rs.getString(5));
                c.setEmail(rs.getString(6));
                c.setAdresse(rs.getString(7));
                c.setHandicap(rs.getBoolean(8));
                c.setDesHandicap(rs.getString(9));
                c.setTel(rs.getInt(10));
                
                
                ListeClient.add(c);
            }
            }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            System.out.println("Echec d'ajout");            
        }
               
        return ListeClient;
    }
    
    
    
    public void deleteClient(int id){
  
        try {
           String requete ="DELETE FROM client WHERE ID = " + id;        
           PreparedStatement pst=new MyConnectivity().cn.prepareStatement(requete);
           pst.executeUpdate();
            System.err.println("Client Supprimé");
        }  
            
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println("Client non supprimé");
        }
    }
    
    public static void updateClient(Client oldc, Client newc){
        try {
                 String requete="UPDATE client SET Nom = ?,Prenom = ?,Sexe = ?,DateNaissance = ?,Email = ?,Adresse = ?,DesHandicap = ?,Tel = ? WHERE ID = ?";
                 PreparedStatement pst= new MyConnectivity().cn.prepareStatement(requete);
            
            pst.setString(1,newc.getNom());
            pst.setString(2, newc.getPrenom());
            pst.setString(3, newc.getSexe());
            pst.setString(4, newc.getDateNaissance());
            pst.setString(5, newc.getEmail());
            pst.setString(6, newc.getAdresse());
            pst.setString(7, newc.getDesHandicap());
            pst.setInt(8, newc.getTel());
            pst.setInt(9, oldc.getID());
            
            pst.executeUpdate();
             
             } catch (SQLException ex) {
                 System.err.println(ex.getMessage());
             }
        
    }
    
//    public static Client Clientget(int ID){
//        Client c = new Client();
//             
//             try {
//                  String requete ="SELECT * FROM client WHERE ID = ?";
//                  PreparedStatement pst = new MyConnectivity().cn.prepareStatement(requete);
//                  pst.setInt(1, ID);
//                  ResultSet rs =pst.executeQuery();
//                  while (rs.next()){
//                    
//                    c.setID(rs.getInt(1));
//                    c.setNom(rs.getString(2));
//                    c.setPrenom(rs.getString(3));
//                    c.setSexe(rs.getString(4));
//                    c.setDateNaissance(rs.getString(5));
//                    c.setEmail(rs.getString(6));
//                    c.setAdresse(rs.getString(7));
//                    c.setDesHandicap(rs.getString(8));
//                    c.setTel(rs.getInt(9));
//                    
//                  }
//             } catch (SQLException e) {
//                 System.err.println(e.getMessage());
//             }
//            
//           return c;
//    }
//    
}
