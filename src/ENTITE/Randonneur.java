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
public class Randonneur {

    public Randonneur(String nom, String prenom, String dateNaissance, String ville, String email, String sexe, String login, String motDePasse, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.email = email;
        //this.numTelephone = numTelephone;
        this.sexe = sexe;
        this.login = login;
        this.motDePasse = motDePasse;
        this.type = type;
    }
    private int id;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String ville;
    private String email;
   // private long numTelephone;
    private String  sexe;
    private String  login;
    private String  motDePasse;
    private String type ;
    private InputStream image;

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
    
    
    
    public Randonneur(int id, String nom, String prenom, String dateNaissance, String ville, String email,  String sexe, String login, String motDePasse, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.email = email;
        //this.numTelephone = numTelephone;
        this.sexe = sexe;
        this.login = login;
        this.motDePasse = motDePasse;
        this.type = type;
        
    }
    
    
    
    public Randonneur(){
    this.type="randonneur";}

    public Randonneur(int id) {
        this.id = id;
        this.type="randonneur";}
    
    
    
    public Randonneur(int id, String nom, String prenom, String dateNaissance, String ville, String email,  String sexe, String login, String motDePasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.email = email;
        //this.numTelephone = numTelephone;
        this.sexe = sexe;
        this.login = login;
        this.motDePasse = motDePasse;
        this.type="randonneur" ;
    }

    public Randonneur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Randonneur(String nom, String prenom, String dateNaissance, String ville, String email,  String sexe, String login, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.email = email;
        //this.numTelephone = numTelephone;
        this.sexe = sexe;
        this.login = login;
        this.motDePasse = motDePasse;
        this.type="randonneur" ;
    }

    public Randonneur(String nom, String prenom, String dateNaissance, String ville, String email, String sexe, String login, String motDePasse, String type, InputStream image) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.email = email;
        this.sexe = sexe;
        this.login = login;
        this.motDePasse = motDePasse;
        this.type = type;
        this.image = image;
    }

    public Randonneur(int id, String nom, String prenom, String dateNaissance, String ville, String email, String sexe, String login, String motDePasse, String type, InputStream image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.email = email;
        this.sexe = sexe;
        this.login = login;
        this.motDePasse = motDePasse;
        this.type = type;
        this.image = image;
    }

    public Randonneur(int id, String nom, String prenom, String dateNaissance, String ville, String email, String sexe, String login, String motDePasse, InputStream image) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.email = email;
        this.sexe = sexe;
        this.login = login;
        this.motDePasse = motDePasse;
        this.image = image;
    }

    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public String getEmail() {
        return email;
    }

   /* public long getNumTelephone() {
        return numTelephone;
    }*/

    public String getSexe() {
        return sexe;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public void setNumTelephone(int numTelephone) {
        this.numTelephone = numTelephone;
    }*/

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return this.getType() + "{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" 
                + dateNaissance + ", ville=" + ville + ", email=" + email + 
                ", sexe=" + sexe + ", login=" + login + ", motDePasse=" + motDePasse + '}' ;
    }
    
   
}
