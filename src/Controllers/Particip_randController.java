/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Services.serviceParticipation;
import Services.serviceRand;
import ENTITE.Participation;
import ENTITE.Randonnee;
import ENTITE.Randonneur;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Particip_randController implements Initializable {
 private Randonnee Rand;
 private serviceRand RCtr;
 private serviceParticipation PCtr;
 
 private Randonnee selectedRand = null;
 
 
 // Id Randonneur to fix with Friend work
 private Randonneur randonneur;
 
    @FXML
    private TableView<Randonnee> table_participer;
    @FXML
    private Button btn_participer;
     @FXML
    private TableView<Randonnee> table_participer_in;
    @FXML
    private Button annuler_rand;
    @FXML
    private Button map_rand;
    @FXML
    private Button mail_id;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        table_participer.getItems().addAll("Difficile", "Moyenne", "Facile");
      RCtr = new serviceRand();
      PCtr = new serviceParticipation();
      Rand = new Randonnee();
      randonneur=new Randonneur();
      randonneur.setId(4);
        
        final TableColumn col_table_nom = new TableColumn("Nom");
        col_table_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        final TableColumn col_table_destination = new TableColumn("Destination");
        col_table_destination.setCellValueFactory(new PropertyValueFactory<>("destination"));
        
        final TableColumn col_table_prix = new TableColumn("Prix");
        col_table_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
        final TableColumn col_table_type = new TableColumn("Type");
        col_table_type.setCellValueFactory(new PropertyValueFactory<>("type_rand"));
        
        final TableColumn col_table_date = new TableColumn("Date");
        col_table_date.setCellValueFactory(new PropertyValueFactory<>("date_rand"));
        
        final TableColumn col_table_description = new TableColumn("Description");
        col_table_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        
        final TableColumn col_table_debut = new TableColumn("Temps_début");
        col_table_debut.setCellValueFactory(new PropertyValueFactory<>("temps_debut"));
        
        final TableColumn col_table_fin = new TableColumn("Temps_fin");
        col_table_fin.setCellValueFactory(new PropertyValueFactory<>("temps_fin"));
        
        final TableColumn col_table_id = new TableColumn("Id");
        col_table_id.setCellValueFactory(new PropertyValueFactory<>("id_randonnee"));
        
        final TableColumn col_table_place = new TableColumn("Nb_places");
        col_table_place.setCellValueFactory(new PropertyValueFactory<>("nb_places"));
        
        table_participer.getColumns().addAll(col_table_id, col_table_nom, col_table_destination, col_table_prix, col_table_date, col_table_type, col_table_description, col_table_debut, col_table_fin, col_table_place);
        /////////////////////
        final TableColumn col_table_nom1 = new TableColumn("Nom");
        col_table_nom1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        final TableColumn col_table_destination1 = new TableColumn("Destination");
        col_table_destination1.setCellValueFactory(new PropertyValueFactory<>("destination"));
      
        final TableColumn col_table_date1 = new TableColumn("Date");
        col_table_date1.setCellValueFactory(new PropertyValueFactory<>("date_rand"));
        
    
        
        final TableColumn col_table_id1 = new TableColumn("Id");
        col_table_id1.setCellValueFactory(new PropertyValueFactory<>("id_randonnee"));
        
        table_participer_in.getColumns().addAll(col_table_id1, col_table_nom1, col_table_destination1, col_table_date1);

        updatetableparticiper();
        
        table_participer.getSelectionModel().selectedItemProperty().addListener((obs,oldRand,newRand)->{
            selectedRand = newRand;
            
        
             
        });
          
       
    }    
     public void updatetableparticiper(){
         
        List<Randonnee> Rands = RCtr.findAll();
        
        List<Randonnee> RandsParticipated = PCtr.findRandonneesByRandonneur(randonneur.getId());
        
//        for(Randonnee rand : RandsParticipated){
//           Rands.remove(rand);
//        }
        
        
        for (Iterator<Randonnee> randParticipated = RandsParticipated.listIterator(); randParticipated.hasNext(); ) {
            Randonnee rp = randParticipated.next();
            for (Iterator<Randonnee> rand = Rands.listIterator(); rand.hasNext(); ) {
                Randonnee r = rand.next();
                if(r.getId_randonnee() == rp.getId_randonnee()){
                    rand.remove();
                }

            }
        }
        
        
        ObservableList<Randonnee> observableArrayList = FXCollections.observableArrayList(Rands);
        ObservableList<Randonnee> observableArrayListParticipated = FXCollections.observableArrayList(RandsParticipated);


        table_participer.setItems(observableArrayList);
        table_participer_in.setItems(observableArrayListParticipated);
        
        

//         List<Randonnee> listeRandonnee = new ArrayList<>();
//        listeRandonnee = RCtr.findAll();
//        ObservableList<Randonnee> observableArrayList = FXCollections.observableArrayList(listeRandonnee);
//        table_participer.setItems(observableArrayList);

        }

    @FXML
    private void Participer_rand(ActionEvent event) {
        if(selectedRand != null){
           Participation p = new Participation();
           p.setParticipant(randonneur);
           p.setRand(selectedRand);
           PCtr.ajouter_participation(p);
           updatetableparticiper();
        }

    }

    private void Annuler(ActionEvent event) {
//       
//      Randonnee selectedItem =table_participer_in.getSelectionModel().getSelectedItem();
//         Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
//                            alerte.setTitle("confirmation");
//                            alerte.setHeaderText("voulez vous vraiment sup?");
//                            Optional<ButtonType> result = alerte.showAndWait();
//                            if (result.get() == ButtonType.OK) {
//                                PCtr.supprimer_participation(selectedItem.getId_randonnee());
//                                table_participer_in.getItems().remove(selectedItem);
//                                actualise();
//
//                            }
        
        
    }

    private void actualise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Actionliste(ActionEvent event) throws IOException {
             
//    
//        
//        Parent parent5 = FXMLLoader.load(getClass().getResource("/views/Maliste.fxml"));
//        Scene scene5 = new Scene (parent5);
//        Stage stage5 =(Stage)((Node) event.getSource()).getScene().getWindow();
//        
//        stage5.setScene(scene5);
//        stage5.show();
    }

    @FXML
    private void ActionAnnuler(ActionEvent event) {
        Randonnee selectedItem =table_participer_in.getSelectionModel().getSelectedItem();
         Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
                            alerte.setTitle("confirmation");
                            alerte.setHeaderText("voulez vous vraiment sup?");
                            Optional<ButtonType> result = alerte.showAndWait();
                            if (result.get() == ButtonType.OK) {
                                System.out.println(selectedItem.getId_randonnee());
                                PCtr.supprimer_participation(selectedItem.getId_randonnee(), randonneur.getId());
                                updatetableparticiper();

                            }
    }

    @FXML
    private void Actionmap(ActionEvent event) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("/views/Map.fxml"));
        Scene scene5 = new Scene (root);
        Stage stage5 =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        stage5.setScene(scene5);
        stage5.show();
    }

    @FXML
    private void Actionenvoyer(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("/views/mail.fxml"));
        Scene scene5 = new Scene (root1);
        Stage stage5 =(Stage)((Node) event.getSource()).getScene().getWindow();
        
        stage5.setScene(scene5);
        stage5.show();
        
    }
     @FXML
    private Button Retour;

    

    
}
