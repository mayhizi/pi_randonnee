/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITE;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Commentaire {
    
   private int id_com;
   private String contenu_com;
   private Date date_com;
   
   
   public Commentaire(){

   
   
   }

    public Commentaire( String contenu_com, Date date_com) {
        
        this.contenu_com = contenu_com;
        this.date_com = date_com;
    }

    public int getId_com() {
        return id_com;
    }

    public void setId_com(int id_com) {
        this.id_com = id_com;
    }

    public String getContenu_com() {
        return contenu_com;
    }

    public void setContenu_com(String contenu_com) {
        this.contenu_com = contenu_com;
    }

    public Date getDate_com() {
        return date_com;
    }

    public void setDate_com(Date date_com) {
        this.date_com = date_com;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id_com=" + id_com + ", contenu_com=" + contenu_com + ", date_com=" + date_com + '}';
    }

    public int getInt(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
   
   
    
}
