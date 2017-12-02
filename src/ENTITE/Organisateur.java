/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITE;

import java.io.InputStream;

/**
 *
 * @author Amin
 */
public class Organisateur extends Randonneur {

    
    
    private String experience  ;
    public Organisateur() {
         super.setType("organisateur");
    }
     public Organisateur(int id) {
        super(id);
         super.setType("organisateur");}
    
    
    public Organisateur( int id, String nom, String prenom, String dateNaissance, String ville, String email,  String sexe, String login, String motDePasse,String experience,InputStream image) {
        super(id, nom, prenom, dateNaissance, ville, email,  sexe, login, motDePasse,image);
        
       super.setType("organisateur");
      
        this.experience = experience;
    }
    
     public Organisateur( int id, String nom, String prenom, String dateNaissance, String ville, String email,  String sexe, String login, String motDePasse,String experience,String type) {
        super(id, nom, prenom, dateNaissance, ville, email,  sexe, login, motDePasse);
       super.setType(type);
        this.experience = experience;
    }

    public Organisateur(String nom, String prenom, String dateNaissance, String ville, String email,  String sexe, String login, String motDePasse,String experience) {
        super(nom, prenom, dateNaissance, ville, email,  sexe, login, motDePasse);
        super.setType("organisateur");
        this.experience = experience;
    }

    public Organisateur(String experience, int id, String nom, String prenom, String dateNaissance, String ville, String email,  String sexe, String login, String motDePasse) {
        super(id, nom, prenom, dateNaissance, ville, email,  sexe, login, motDePasse);
        this.experience = experience;
    }

    public Organisateur(String experience, int id, String nom, String prenom, String dateNaissance, String ville, String email,  String sexe, String login, String motDePasse, String type) {
        super(id, nom, prenom, dateNaissance, ville, email,  sexe, login, motDePasse, type);
        this.experience = experience;
    }

   

   

    
    

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return super.toString() +"{" + "experience=" + experience + '}';
    }

   
    
    
     
     
    
}

