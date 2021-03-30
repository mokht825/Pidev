/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author Mokhtar
 */
public class coach {
    private int Idcoach;
    private String Nomcoach;
    private String Prenomcoach;
    private String Genre;
    private String Disponabilite;
    private String Typesesport;
    private String Localisation;

    public coach() {
    }

    public coach(int Idcoach, String Nomcoach, String Prenomcoach, String Genre, String Disponabilite, String Typesesport, String Localisation) {
        this.Idcoach = Idcoach;
        this.Nomcoach = Nomcoach;
        this.Prenomcoach = Prenomcoach;
        this.Genre = Genre;
        this.Disponabilite = Disponabilite;
        this.Typesesport = Typesesport;
        this.Localisation = Localisation;
    }

    public int getIdcoach() {
        return Idcoach;
    }

    public String getNomcoach() {
        return Nomcoach;
    }

    public String getPrenomcoach() {
        return Prenomcoach;
    }

    public String getGenre() {
        return Genre;
    }

    public String getDisponabilite() {
        return Disponabilite;
    }

    public String getTypesesport() {
        return Typesesport;
    }

    public String getLocalisation() {
        return Localisation;
    }

    public void setIdcoach(int Idcoach) {
        this.Idcoach = Idcoach;
    }

    public void setNomcoach(String Nomcoach) {
        this.Nomcoach = Nomcoach;
    }

    public void setPrenomcoach(String Prenomcoach) {
        this.Prenomcoach = Prenomcoach;
    }

    public void setGenre(String Genre) {
        this.Genre = Genre;
    }

    public void setDisponabilite(String Disponabilite) {
        this.Disponabilite = Disponabilite;
    }

    public void setTypesesport(String Typesesport) {
        this.Typesesport = Typesesport;
    }

    public void setLocalisation(String Localisation) {
        this.Localisation = Localisation;
    }

    @Override
    public String toString() {
        return "coach{" + "Idcoach=" + Idcoach + ", Nomcoach=" + Nomcoach + ", Prenomcoach=" + Prenomcoach + ", Genre=" + Genre + ", Disponabilite=" + Disponabilite + ", Typesesport=" + Typesesport + ", Localisation=" + Localisation + '}';
    }
    
    
}
  
 