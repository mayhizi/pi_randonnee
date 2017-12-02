/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ENTITE.Randonneur ;
import Utils.DataSource ;
import java.io.InputStream;
/**
 *
 * @author Amin
 */
public class serviceRandonneur {
    Connection con1 = DataSource.getInstance().getConnection();
    static Statement ste;
    
    public serviceRandonneur() {
        try {
            ste = con1.createStatement();
            if (ste==null)
                System.out.println("bgg");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("beuug");
        }
        
   }
public void ajouterRandonneur(Randonneur r,InputStream img2) throws SQLException {
        String sql = "INSERT INTO `randonneur`(`nom`,`prenom`,`dateNaissance`,`ville`,`email`,`sexe`,`login`,`motDePasse`,`TypeUtilisateur`,`image`)" + " VALUES(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre = con1.prepareStatement(sql);

        pre.setString(1, r.getNom());
        pre.setString(2, r.getPrenom());
        pre.setString(3, r.getDateNaissance());
        pre.setString(4, r.getVille());
        pre.setString(5, r.getEmail());
        //pre.setLong(6, r.getNumTelephone());
        pre.setString(6, r.getSexe());
        pre.setString(7, r.getLogin());
        pre.setString(8, r.getMotDePasse());
        pre.setString(9, r.getType());
        pre.setBlob(10,img2) ;
        
        
       
        //pre.setInt(4, a.getId_art());

        pre.executeUpdate();
    }

    public List<Randonneur> afficherRandonneur() throws SQLException {
        List<Randonneur> ls = new ArrayList();
        ResultSet rs = ste.executeQuery("select * from randonneur");
        //Randonneur r = null;
        while (rs.next()) {
            
            Randonneur r = new Randonneur(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),rs.getString(10));
             r.setImage(rs.getBinaryStream(11));
            
             ls.add(r);
              
            
        }
        return ls;
        
    }

    public void supprimerRandonneur(int id) throws SQLException {

             String   req = "delete from  randonneur where id= ?";
        PreparedStatement pre = con1.prepareStatement(req);
        pre  = con1.prepareStatement(req);
        pre.setInt(1, id);

        pre.executeUpdate();
        System.out.println("randonneur supprimé");

    }

    public void modifierRandonneur(Randonneur r,int id,InputStream img2) throws SQLException {

         String sql = "UPDATE randonneur SET nom=?,prenom=?,dateNaissance=?,ville=?,email=?,sexe=?,login=?,motDePasse=?,TypeUtilisateur=?,image=? where id=?";
        PreparedStatement pre = con1.prepareStatement(sql);
       // pre.setString(1, "sac a dos");
        pre.setString(1, r.getNom());
        pre.setString(2, r.getPrenom());
        pre.setString (3, r.getDateNaissance());
        
        pre.setString(4, r.getVille());
        pre.setString(5, r.getEmail());
        //pre.setLong  (6,  r.getNumTelephone());
        pre.setString(6, r.getSexe());
        pre.setString(7, r.getLogin());
        pre.setString(8, r.getMotDePasse());
        pre.setString(9, r.getType());
        pre.setBlob(10, img2);
        pre.setInt(11,id) ;
        pre.executeUpdate();
        System.out.println("equipement modifiee");

    }
}
