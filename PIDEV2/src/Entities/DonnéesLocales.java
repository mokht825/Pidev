/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author belha
 */
public class DonnéesLocales {
    
    
    private static Client selectedClient = new Client();;
    private static DonnéesLocales  localdata;
    
    public static void setClient(Client c){
    selectedClient = c;
    }
    
    public static Client getClient(){
        
    return selectedClient;
    
    }
    
}
