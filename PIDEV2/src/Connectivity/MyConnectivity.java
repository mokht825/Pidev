/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author belha
 */
public class MyConnectivity {
    public String url="jdbc:mysql://localhost:3306/pidev";
    public String login="root";
    public String pwd="";
    public Connection cn;

    public MyConnectivity(){
        try 
        {
            cn = DriverManager.getConnection(url,login,pwd);
            System.out.println("Connexion établie");
        }
        catch (SQLException ex)
        {
            System.err.println("Erreur de connexion");
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConnexion(){
    return cn ; 
    }

    
}
