/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;


import javafx.scene.control.DatePicker;


/**
 *
 * @author belha
 */
public class Client {
    private int ID;
    private String Nom;
    private String Prenom;
    private String Sexe;
    private String DateNaissance;
    private String Email;
    private String Adresse;
    private boolean Handicap;
    private String DesHandicap;
    private int Tel;

    public Client() {
    }

    public Client(int ID, String Nom, String Prenom, String Sexe, String DateNaissance, String Email, String Adresse, boolean Handicap, String DesHandicap, int Tel) {
        this.ID = ID;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Sexe = Sexe;
        this.DateNaissance = DateNaissance;
        this.Email = Email;
        this.Adresse = Adresse;
        this.Handicap = Handicap;
        this.DesHandicap = DesHandicap;
        this.Tel = Tel;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String Sexe) {
        this.Sexe = Sexe;
    }

    public String getDateNaissance() {
        return DateNaissance;
    }

    public void setDateNaissance(String DateNaissance) {
        this.DateNaissance = DateNaissance;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public boolean isHandicap() {
        return Handicap;
    }

    public void setHandicap(boolean Handicap) {
        this.Handicap = Handicap;
    }

    public String getDesHandicap() {
        return DesHandicap;
    }

    public void setDesHandicap(String DesHandicap) {
        this.DesHandicap = DesHandicap;
    }

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    @Override
    public String toString() {
        return "Client{" + "ID=" + ID + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Sexe=" + Sexe + ", DateNaissance=" + DateNaissance + ", Email=" + Email + ", Adresse=" + Adresse + ", Handicap=" + Handicap + ", DesHandicap=" + DesHandicap + ", Tel=" + Tel + '}';
    }
    
    
    
}
