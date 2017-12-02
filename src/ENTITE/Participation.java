/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITE;

/**
 *
 * @author user
 */
public class Participation {
    private int id_participation;
    private Randonnee rand;
    private Randonneur participant;

    public Participation(int id_participation, Randonnee rand, Randonneur participant) {
        this.id_participation = id_participation;
        this.rand = rand;
        this.participant = participant;
    }

    public Participation() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.participant = new Randonneur();
        this.rand = new Randonnee();
    }

    public int getId_participation() {
        return id_participation;
    }

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public Randonnee getRand() {
        return rand;
    }

    public void setRand(Randonnee rand) {
        this.rand = rand;
    }

    public Randonneur getParticipant() {
        return participant;
    }

    public void setParticipant(Randonneur participant) {
        this.participant = participant;
    }

    @Override
    public String toString() {
        return "Participation{" + "id_participation=" + id_participation + ", rand=" + rand + ", participant=" + participant + '}';
    }
    
    
   
    
}
