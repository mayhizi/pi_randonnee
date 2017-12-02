/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import ENTITE.Organisateur;

import Utils.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amin
 */
public class serviceOrganisateur {
    Connection con2 = DataSource.getInstance().getConnection();
    static private Statement ste;
    
    public serviceOrganisateur() {
        try {
            ste = con2.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
   }
public void ajouterOrganisateur(Organisateur o, InputStream img) throws SQLException {
        
    
        String sql = "INSERT INTO `organisateur`(`nom`,`prenom`,`dateNaissance`,`ville`,`email`,`sexe`,`login`,`motDePasse`,`experience`,`TypeUtilisateur`,`image`)" + " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        
        
        PreparedStatement pre = con2.prepareStatement(sql);
         
        pre.setString(1, o.getNom());
        pre.setString(2, o.getPrenom());
        pre.setString(3, o.getDateNaissance());
        pre.setString(4, o.getVille());
        pre.setString(5, o.getEmail());
        //pre.setLong(6, o.getNumTelephone());
        pre.setString(6, o.getSexe());
        pre.setString(7, o.getLogin());
        pre.setString(8, o.getMotDePasse());
        pre.setString(9,o.getExperience());
        pre.setString(10,o.getType());
        pre.setBlob(11,img);
        
        
       
        //pre.setInt(4, a.getId_art());

        pre.executeUpdate();
        
     }


//Organisateur organisateur = new Organisateur(55, "jh", "jj", "jj", "jj", "jj", 55555, "hh", "jj", "jj", "jjjj");
Organisateur organisateur = new Organisateur();

   public List<Organisateur> afficher()  {
        
        List<Organisateur> ls = new ArrayList();
        try {
            ResultSet gs;
            gs = ste.executeQuery("select * from organisateur");
            
         
             while (gs.next()) {
             Organisateur org = new Organisateur(gs.getInt(1), gs.getString(2), gs.getString(3),gs.getString(4),
               gs.getString(5), gs.getString(6),  gs.getString(7), gs.getString(8),
               gs.getString(9), gs.getString(10), gs.getString(11));
             org.setImage(gs.getBinaryStream(12)) ;
            ls.add(org);
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(serviceOrganisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
        return ls;

    }

    public void supprimerOrganisateur(int id) throws SQLException {

             String   req = "delete from  organisateur where id= ?";
        PreparedStatement pre = con2.prepareStatement(req);
        pre  = con2.prepareStatement(req);
        pre.setInt(1, id);

        pre.executeUpdate();
        System.out.println("organisateur supprimé");

    }

    public void modifierOrganisateur(Organisateur o,int id,InputStream img) throws SQLException {

        String sql = "UPDATE organisateur SET nom=?,prenom=?,dateNaissance=?,ville=?,email=?,sexe=?,login=?,motDePasse=?,experience=?,image=? where id=?";
        PreparedStatement pre = con2.prepareStatement(sql);
       // pre.setString(1, "sac a dos");
        pre.setString(1, o.getNom());
        pre.setString(2, o.getPrenom());
        pre.setString (3, o.getDateNaissance());
        
        pre.setString(4, o.getVille());
        pre.setString(5, o.getEmail());
       // pre.setLong  (6,  o.getNumTelephone());
        pre.setString(6, o.getSexe());
        pre.setString(7, o.getLogin());
        pre.setString(8, o.getMotDePasse());
        pre.setString(9,o.getExperience());
        pre.setBlob(10, img);
        pre.setInt(11,id);
        pre.executeUpdate();
        System.out.println("equipement modifiee");

    }
    
}
