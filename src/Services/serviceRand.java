/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import ENTITE.Randonnee;
import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author user
 */
public class serviceRand {
    private final Connection connection;
    private PreparedStatement ps;
    private static ResultSet r;
    ObservableList<ObservableList> obs;
    ObservableList<Randonnee> obs1;
    private TableColumn col;
    public serviceRand() {
        connection = DataSource.getInstance().getConnection();
    }
    Randonnee c = new Randonnee();
//    public void ajouter_randonnee(Randonnee ,InputStream img)
    public void ajouter_randonnee(Randonnee r,InputStream img) {

        try {
            String requete = "insert into randonnee (nom,destination,prix,type_rand,id_randonnee,date_rand,image,description,temps_debut,temps_fin,nb_places) values (?,?,?,?,?,?,?,?,?,?,?)";

            ps = connection.prepareStatement(requete);

            ps.setString(1, r.getNom());
            ps.setString(2, r.getDestination());
            ps.setFloat(3, r.getPrix());
            ps.setString(4, r.getType_rand());
            ps.setInt(5, r.getId_randonnee());
            ps.setDate(6, r.getDate_rand());
           
             
            ps.setBlob(7, img);
            ps.setString(7, "");
            ps.setString(8, r.getDescription());
            ps.setString(9, r.getTemps_debut());
            ps.setString(10, r.getTemps_fin());
            ps.setInt(11, r.getNb_places());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceRand.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    public List<Randonnee> findAll() {
        List<Randonnee> listeRandonnee = new ArrayList<>();

        String requete = "select nom,"
                + "destination,"
                + "prix,"
                + "type_rand,"
                + "id_randonnee,"
                + "date_rand,"
                + "image,"
                + "description,"
                + "temps_debut,"
                + "temps_fin,"
                + "nb_places from randonnee";
        try {
            Statement statement = connection.createStatement();
            r = statement.executeQuery(requete);

            while (r.next()) {
                Randonnee f = new Randonnee();

                f.setNom(r.getString(1));
                f.setDestination(r.getString(2));
                f.setPrix(r.getFloat(3));
                f.setType_rand(r.getString(4));
                f.setId_randonnee(r.getInt(5));
                f.setDate_rand(r.getDate(6));
                f.setImage(r.getBinaryStream(7));
                f.setDescription(r.getString(8));
                f.setTemps_debut(r.getString(9));
                f.setTemps_fin(r.getString(10));
                f.setNb_places(r.getInt(11));
                

                listeRandonnee.add(f);
            }
            return listeRandonnee;
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
            return null;
        }
    }
    
    public void Edit(Randonnee rand) {

        String req = "UPDATE `randonnee` SET `nom`=?,`destination`=?,`prix`=?,`type_rand`=?,`date_rand`=?,`temps_debut`=?,`temps_fin`=?,`description`=?,`nb_places`=? WHERE id_randonnee=?";

        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, rand.getNom());
            ps.setString(2, rand.getDestination());
            ps.setFloat(3, rand.getPrix());
            ps.setString(4, rand.getType_rand());
            ps.setDate(5,rand.getDate_rand() );
            ps.setString(6,rand.getTemps_debut());
            ps.setString(7,rand.getTemps_fin() );
            ps.setString(8, rand.getDescription());
            ps.setInt(9, rand.getNb_places());
            ps.setInt(10, rand.getId_randonnee());
            
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(serviceRand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        String req = "DELETE FROM `randonnee` WHERE id_randonnee=" + id+ " ";
        try {
            ps = connection.prepareStatement(req);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceRand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
//    public Randonnee findById(Integer ID) {
//          String req = "select * from proposition where PropositionId= ?";
//        Randonnee rand = null;
//        Randonnee randonnee = null;
//        try {
//            ps = connection.prepareStatement(req);
//            ps.setInt(1, ID);
//            ResultSet resultSet = ps.executeQuery();
//            if (resultSet.next()) {
//                randonnee = new Randonnee(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return randonnee;
//    }
    public List<Randonnee> find(String term){
        List<Randonnee> listeRandonnee = new ArrayList<Randonnee>();
        String req = "select * from randonnee where "
                +"nom like'" + term
                +"' or destination like'" + term+"'";
        try {
            Statement statement = connection.createStatement();
            r = statement.executeQuery(req);

            while (r.next()) {
                Randonnee f = new Randonnee();

                f.setNom(r.getString(1));
                f.setDestination(r.getString(2));
                f.setPrix(r.getFloat(3));
                f.setType_rand(r.getString(4));
                f.setId_randonnee(r.getInt(5));
                f.setDate_rand(r.getDate(6));
                f.setImage(r.getBinaryStream(7));
                f.setDescription(r.getString(8));
                f.setTemps_debut(r.getString(9));
                f.setTemps_fin(r.getString(10));
                f.setNb_places(r.getInt(11));
                

                listeRandonnee.add(f);
            }
        } catch (SQLException ex) {
            System.out.println("SQL Error: " + ex);
            return null;
        }
        
        return listeRandonnee;
    }



}
