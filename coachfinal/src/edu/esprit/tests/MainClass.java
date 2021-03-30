/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.tests;

import edu.esprit.entities.coach;
import edu.esprit.services.CoachCRUD;
import edu.esprit.tools.MyConnection5;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Mokhtar
 */
public class MainClass {
    public static void main(String[] args) throws SQLException {
        //MyConnection mc = new MyConnection5();
        CoachCRUD ccd =new CoachCRUD();
        coach c1 = new coach(14, "a", "b", "m", "c", "d", "e");
       ccd.addCoach(c1);
         ccd.suupcoach(13);
      
       List<coach> listcoach = ccd.listecoach();
            
       //listcoach=
       System.out.println(ccd.listecoach());
       
            
       
        
      // listcoach.forEach((e)->System.out.println(e));
       
    }
    
   
       
        
    }
 
    
    

