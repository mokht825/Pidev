/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mokhtar
 */
public class MyConnection5 {

    public static Object getInstance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String url = "jdbc:mysql://localhost:3306/pidev";
    public String login = "root";
    public String pwd = "";
    public Connection cn;
    public MyConnection5() {
        try {
           cn = DriverManager.getConnection(url, login, pwd);
             System.out.println("Connection établie!");
        } catch (SQLException ex) {
            System.out.println("Ererreur de connection");
            System.out.println(ex.getMessage());
        }

    }

}
