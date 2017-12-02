/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import Utils.DataSource;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.fxml.Initializable;


import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import Services.serviceRand;




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.TableView;
import ENTITE.Randonnee;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;


/**
 * FXML Controller class
 *
 * @author user
 */
public class Rand_WrapController implements Initializable {
    
    /**
     * Initializes the controller class.
     */
    
    private Randonnee Rand;
    private serviceRand RandCtr;

    @FXML private TextField chercher_id;
    private WebEngine engine;
     @FXML
    private ImageView imageview2;

    
    
    private String s;
    @FXML private TextField chercher_field;

   
    @FXML
    private WebView field_rand_mapview;
    @FXML
    private JFXTextField field_rand_destination;
    @FXML
    private JFXTextField field_rand_nom;
    @FXML
    private DatePicker field_rand_date;
    @FXML
    private JFXTextField field_rand_prix;
    @FXML
    private TextArea field_rand_description;
    @FXML
    private JFXTextField field_rand_place;
    @FXML
    private JFXTextField field_rand_fin;
    @FXML
    private JFXTextField field_rand_debut;
    @FXML
    private Button field_rand_photo;
    @FXML
    private ComboBox field_rand_type;
    @FXML
    private TableView<Randonnee> list_rands_table;
    @FXML
    private Button modif_rand_button;
    @FXML
    private DatePicker field_rand_date_modif;
    @FXML
    private TextArea field_rand_description_modif;
    @FXML
    private JFXTextField field_rand_debut_modif;
    @FXML
    private JFXTextField field_rand_destination_modif;
    @FXML
    private JFXTextField field_rand_nom_modif;
    @FXML
    private JFXTextField field_rand_id_modif;
    @FXML
    private JFXTextField field_rand_fin_modif;
    @FXML
    private JFXTextField field_rand_place_modif;
    @FXML
    private Button sup_rand_button;
    @FXML
    private JFXTextField field_rand_prix_modif;
     @FXML
    private ComboBox field_rand_type_modif;
    
    
     
    private List<Randonnee> Rands ;
    
    @FXML protected void ActionAjout(ActionEvent event) throws FileNotFoundException {
        
    
          boolean check = CheckInputs();
          if(check){
              
            Rand.setNom(field_rand_nom.getText());
            Rand.setDestination(field_rand_destination.getText());
            Rand.setPrix(Float.parseFloat(field_rand_prix.getText().toString()));
            Rand.setDate_rand(java.sql.Date.valueOf(field_rand_date.getValue()));
            Rand.setType_rand((String) field_rand_type.getValue());
            Rand.setTemps_debut(field_rand_debut.getText());
            Rand.setTemps_fin(field_rand_fin.getText());
            Rand.setDescription( field_rand_description.getText());
            Rand.setNb_places(Integer.parseInt(field_rand_place.getText()));
            System.out.println(Rand.toString());
            InputStream img;
        img = new FileInputStream(new File(s));
    
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("success");
            success.setHeaderText("Votre Randonnée est ajoutée avec succée");
            success.show();
            
            RandCtr.ajouter_randonnee(Rand,img);
            Rands = RandCtr.findAll();
            cleanInputs();
            updateRandTable();
          }
        
    }
//    
    @FXML protected void modifierRand(ActionEvent event) {
        Randonnee r = list_rands_table.getSelectionModel().getSelectedItem();
        System.out.println(r.toString());
        
        boolean check = CheckInputsModif();
        if (check) {
            
        Randonnee Rand= new Randonnee();
       
           Rand.setId_randonnee(Integer.parseInt(field_rand_id_modif.getText()));
           Rand.setNom(field_rand_nom_modif.getText());
          Rand.setDestination(field_rand_destination_modif.getText());
          Rand.setPrix(Float.parseFloat(field_rand_prix_modif.getText()));
          Rand.setDate_rand(java.sql.Date.valueOf(field_rand_date_modif.getValue()));
          Rand.setType_rand((String) field_rand_type_modif.getValue());
          Rand.setTemps_debut(field_rand_debut_modif.getText());
          Rand.setTemps_fin(field_rand_fin_modif.getText());
          Rand.setDescription( field_rand_description_modif.getText());
          Rand.setNb_places( Integer.parseInt(field_rand_place_modif.getText()));
          RandCtr.Edit(Rand);
          findRands(chercher_field.getText());
          updateRandTable();
          Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("success");
            success.setHeaderText("Votre Randonnée est modifiée avec succée");
            success.show();

        }
        
        
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        field_rand_type.getItems().addAll("Difficile", "Moyenne", "Facile");
        field_rand_type.getSelectionModel().select("Moyenne");
        RandCtr = new serviceRand();
        Rand = new Randonnee();
        
        
        Rands = RandCtr.findAll();
//       
        
        
  
        
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
        
        
        
        updateRandTable();
        list_rands_table.getColumns().addAll(col_table_id, col_table_nom, col_table_destination, col_table_prix, col_table_date, col_table_type, col_table_description, col_table_debut, col_table_fin, col_table_place);
         field_rand_type_modif.getItems().addAll("Difficile", "Moyenne", "Facile");
        list_rands_table.getSelectionModel().selectedItemProperty().addListener((obs,oldRand,newRand)->{
            if (newRand !=null){
               field_rand_id_modif.setText(newRand.getId_randonnee()+"");
               field_rand_nom_modif.setText(newRand.getNom());
               field_rand_destination_modif.setText(newRand.getDestination());
               field_rand_prix_modif.setText(newRand.getPrix()+"");
               field_rand_date_modif.setValue(LocalDate.parse(newRand.getDate_rand()+""));
               field_rand_type_modif.setValue(newRand.getType_rand());
               field_rand_debut_modif.setText(newRand.getTemps_debut());
               field_rand_fin_modif.setText(newRand.getTemps_fin());
               field_rand_description_modif.setText(newRand.getDescription());
               field_rand_place_modif.setText(newRand.getNb_places()+"");
               
               
               
               
               
               
            }
        });
        
//        https://www.google.tn/maps/@36.898998,10.1899154,18.5z
//        
//        http://maps.google.com/maps?q=40.01696,32.33076&z=17
        
        
        field_rand_destination.textProperty().addListener((observable, oldValue, newValue) -> {
            
            engine= field_rand_mapview.getEngine();
            engine.load(makeMapUrl("esprit ariana", newValue));
        
        });
        chercher_field.textProperty().addListener((observable, oldValue, newValue) -> {
            
            findRands(newValue);
        
        });
      
        
        
        
        
        
        
        
        
        
             }
    
    

    public String makeMapUrl(String from, String to){
        from = from.replaceAll("\\s+","+");
        to = to.replaceAll("\\s+","+");
        return "https://www.google.tn/maps/dir/"+from+"/"+to;
    }
    @FXML
    void supRand(ActionEvent event) throws SQLException {
       
        Randonnee selectedItem = list_rands_table.getSelectionModel().getSelectedItem();
         Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
                            alerte.setTitle("confirmation");
                            alerte.setHeaderText("voulez vous vraiment sup?");
                            Optional<ButtonType> result = alerte.showAndWait();
                            if (result.get() == ButtonType.OK) {
                                RandCtr.delete(selectedItem.getId_randonnee());
                                list_rands_table.getItems().remove(selectedItem);
                                actualise();

                            }
                        }
        
        

  
    public void updateRandTable(){
        
        ObservableList<Randonnee> observableArrayList = FXCollections.observableArrayList(Rands);
        list_rands_table.setItems(observableArrayList);

        }

    private void actualise() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     @FXML
    void Actionphoto(ActionEvent event) {
         FileChooser filechooser = new FileChooser();
        File file;
        Window ctx = null;
        file = filechooser.showOpenDialog(ctx);
        String path = file.getAbsolutePath();
        if (file != null) {
            Image image;
            image = new Image(file.toURI().toString(), 100, 150, true, true);
            imageview2.setImage(image);
            s = path;
            
        }

    }
    
   
    void findRands(String term){
        if(!term.isEmpty()){
            Rands = RandCtr.find(term);
        }
        else{
            Rands = RandCtr.findAll();
        }
        updateRandTable();

    }
    public boolean CheckInputs(){
        String msg="";
        String regex = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
        
        if (field_rand_nom.getText().isEmpty())
            msg+="\n - Nom ne doit pas etre vide";
        if (field_rand_destination.getText().isEmpty())
            msg+="\n - destination ne doit pas etre vide";
        if (field_rand_prix.getText().isEmpty())
             msg+="\n - Prix ne doit pas etre vide";
        else if(!isInteger(field_rand_prix.getText()))
            msg+="\n - Prix doit etre un numero";
//         if (field_rand_date.getValue().toString().isEmpty())
//             msg+="\n - date ne doit pas etre vide";
//         
         if (field_rand_debut.getText().isEmpty())
             msg+="\n - Début ne doit pas etre vide";
         else if(!field_rand_debut.getText().matches(regex))
            msg+="\n - Debut doit etre au format hh:mm";
         if (field_rand_fin.getText().isEmpty())
             msg+="\n - Fin ne doit pas etre vide";
         else if(!field_rand_fin.getText().matches(regex))
            msg+="\n - Fin doit etre au format hh:mm";
         if (field_rand_place.getText().isEmpty())
              msg+="\n - Nb_places ne doit pas etre vide";
         else if(!isInteger(field_rand_place.getText()))
            msg+="\n - Nb_places doit etre un numero";
         if (field_rand_description.getText().isEmpty())
             msg+="\n - Description ne doit pas etre vide";
         if (s == null)
             msg += "\n - Vous avez pas choisi une image";
       
        if(msg.isEmpty()){
            return true;
        }
        else{
             Alert alerte = new Alert(Alert.AlertType.WARNING);
                             alerte.setTitle("Attention");
                            alerte.setHeaderText(msg);
                             alerte.show();
            return false;
        }
    
    }
    public void cleanInputs(){
    
        field_rand_date.setValue(null);
        field_rand_debut.setText("");
        field_rand_description.setText("");
        field_rand_destination.setText("");
        field_rand_fin.setText("");
        field_rand_nom.setText("");
        field_rand_place.setText("");
        field_rand_prix.setText("");
        field_rand_type.setValue("Moyenne");
        imageview2.setImage(null);
        
    }
    
    public boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    public boolean CheckInputsModif(){
        String msg="";
        String regex = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
        
        if (field_rand_nom_modif.getText().isEmpty())
            msg+="\n - Nom ne doit pas etre vide";
        if (field_rand_destination_modif.getText().isEmpty())
            msg+="\n - destination ne doit pas etre vide";
        if (field_rand_prix_modif.getText().isEmpty())
             msg+="\n - Prix ne doit pas etre vide";
        else if(!isInteger(field_rand_prix_modif.getText()))
            msg+="\n - Prix doit etre un numero";
//         if (field_rand_date.getValue().toString().isEmpty())
//             msg+="\n - date ne doit pas etre vide";
//         
         if (field_rand_debut_modif.getText().isEmpty())
             msg+="\n - Début ne doit pas etre vide";
         else if(!field_rand_debut_modif.getText().matches(regex))
            msg+="\n - Debut doit etre au format hh:mm";
         if (field_rand_fin_modif.getText().isEmpty())
             msg+="\n - Fin ne doit pas etre vide";
         else if(!field_rand_fin_modif.getText().matches(regex))
            msg+="\n - Fin doit etre au format hh:mm";
         if (field_rand_place_modif.getText().isEmpty())
              msg+="\n - Nb_places ne doit pas etre vide";
         else if(!isInteger(field_rand_place_modif.getText()))
            msg+="\n - Nb_places doit etre un numero";
         if (field_rand_description_modif.getText().isEmpty())
             msg+="\n - Description ne doit pas etre vide";
        
       
        if(msg.isEmpty()){
            return true;
        }
        else{
             Alert alerte = new Alert(Alert.AlertType.WARNING);
                             alerte.setTitle("Attention");
                            alerte.setHeaderText(msg);
                             alerte.show();
            return false;
        }
    
    }

}

   
    
     
    
    
    

