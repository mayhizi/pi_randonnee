/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITE;

import java.io.InputStream;
import java.sql.Date;


/**
 *
 * @author user
 */
public class Randonnee {
  private String nom;
    private String destination;
    private float prix;
    private String type_rand;
    private int id_randonnee ;
    private Date date_rand;
    private InputStream image;
    private String description;
    private String temps_debut;
    private String temps_fin;
    private int nb_places;
   
     public Randonnee() {
    }

    public Randonnee(String nom, String destination, float prix, String type_rand, Date date_rand,InputStream image, String description, String temps_debut, String temps_fin,int nb_places) {
        this.nom = nom;
        this.destination = destination;
        this.prix = prix;
        this.type_rand = type_rand;
        this.date_rand = date_rand;
        this.image = image;
        this.description = description;
        this.temps_debut = temps_debut;
        this.temps_fin = temps_fin;
        this.nb_places=nb_places;
    }

    public Randonnee(String nom, String destination, float prix) {
        this.nom = nom;
        this.destination = destination;
        this.prix = prix;
    }

    public Randonnee(String nom, String destination, float prix, int id_randonnee) {
        this.nom = nom;
        this.destination = destination;
        this.prix = prix;
        this.id_randonnee = id_randonnee;
    }

    public Randonnee(String string, String string0, float aFloat, String string1, Date date, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Randonnee(String string, String string0, int aInt, Date date, String string1, String string2, String string3, String string4, int aInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getType_rand() {
        return type_rand;
    }

    public void setType_rand(String type_rand) {
        this.type_rand = type_rand;
    }

    public int getId_randonnee() {
        return id_randonnee;
    }

    public void setId_randonnee(int id_randonnee) {
        this.id_randonnee = id_randonnee;
    }

    public Date getDate_rand() {
        return date_rand;
    }

    public void setDate_rand(Date date_rand) {
        this.date_rand = date_rand;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemps_debut() {
        return temps_debut;
    }

    public void setTemps_debut(String temps_debut) {
        this.temps_debut = temps_debut;
    }

    public String getTemps_fin() {
        return temps_fin;
    }

    public void setTemps_fin(String temps_fin) {
        this.temps_fin = temps_fin;
    }
     public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    @Override
    public String toString() {
        return "Randonnee{" + "nom=" + nom + ", destination=" + destination + ", prix=" + prix + ", type_rand=" + type_rand + ", id_randonnee=" + id_randonnee + ", date_rand=" + date_rand + ", image=" + image + ", description=" + description + ", temps_debut=" + temps_debut + ", temps_fin=" + temps_fin + ",nb_places=" +nb_places+ '}';
    }

    public Object getItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public int getId_participation() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
