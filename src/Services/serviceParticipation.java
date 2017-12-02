/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DataSource;
import ENTITE.Participation;
import ENTITE.Randonnee;
import ENTITE.Randonneur;
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

/**
 *
 * @author user
 */
public class serviceParticipation {
    private final Connection connection;
    private PreparedStatement ps;
    private static ResultSet r;
    ObservableList<ObservableList> obs;
    ObservableList<Participation> obs1;
    private TableColumn col;
    public serviceParticipation() {
        connection = DataSource.getInstance().getConnection();
    }
    Participation p = new Participation();
    
    public void ajouter_participation(Participation p) {

        try {
            String requete = "insert into participation (id_randonnee,id_randonneur) values (?,?)";

            ps = connection.prepareStatement(requete);

            ps.setInt(1, p.getRand().getId_randonnee());
            ps.setInt(2, p.getParticipant().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceRand.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    
     public List<Randonnee> findRandonneesByRandonneur(Integer randonneurID) {
        List<Randonnee> listeRandonnee = new ArrayList<>();

        String req = "SELECT"
        + " randonnee.id_randonnee,randonnee.nom, randonnee.type_rand,randonnee.date_rand,randonnee.destination,randonnee.description,randonnee.temps_debut,randonnee.temps_fin,randonnee.nb_places,randonnee.prix"
        + " FROM participation INNER JOIN randonnee ON participation.id_randonnee=randonnee.id_randonnee"
        + " WHERE participation.id_randonneur="+randonneurID;
        
        try {
            Statement statement = connection.createStatement();
            r = statement.executeQuery(req);

            while (r.next()) {
                Randonnee f = new Randonnee();

                f.setNom(r.getString(2));
                f.setDestination(r.getString(5));
                f.setPrix(r.getFloat(10));
                f.setType_rand(r.getString(3));
                f.setId_randonnee(r.getInt(1));
                f.setDate_rand(r.getDate(4));
//                f.setImage(r.getBinaryStream(7));
                f.setDescription(r.getString(6));
                f.setTemps_debut(r.getString(7));
                f.setTemps_fin(r.getString(8));
                f.setNb_places(r.getInt(9));
                

                listeRandonnee.add(f);
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listeRandonnee;
    }
     
//    public static void main(String[] args) {
//        ParticipationController pc= new ParticipationController();
////        List<Randonnee> rands = pc.findRandonneesByRandonneur(4);
////        
////        rands.forEach((rand)->{
////                System.out.println(rand.toString());
////        });
//
//       Participation p=new Participation();
//       p.getParticipant().setId(4);
//p.getRand().setId_randonnee(294);
//
//pc.ajouter_participation(p);
//    }
     public void supprimer_participation(int idRand, int idRandonneur){
       String req = "DELETE FROM `participation` WHERE id_randonnee=" + idRand+ " AND id_randonneur =" +idRandonneur;
        try {
            ps = connection.prepareStatement(req);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(serviceRand.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     }

}
