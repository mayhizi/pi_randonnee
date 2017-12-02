/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MapController implements Initializable {
    @FXML
    private WebView Web_map;
    private WebEngine engine;
    @FXML
    private TextField field_destination;
    @FXML
    private Button retour_map_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       engine= Web_map.getEngine();
//       engine.load("https://www.google.fr/maps/place/Tunisie/@33.720779,5.0655354,6z/data=!3m1!4b1!4m5!3m4!1s0x125595448316a4e1:0x3a84333aaa019bef!8m2!3d33.886917!4d9.537499");
//            
        field_destination.textProperty().addListener((observable, oldValue, newValue) -> {
            
            engine= Web_map.getEngine();
            engine.load(makeMapUrl("esprit ariana", newValue));
             
                    });
                
                }       
    public String makeMapUrl(String from, String to){
        from = from.replaceAll("\\s+","+");
        to = to.replaceAll("\\s+","+");
        return "https://www.google.tn/maps/dir/"+from+"/"+to;
    }
///////
    

    
  void changescene(String gui, ActionEvent event) throws IOException {
        FXMLLoader fxmlloder = new FXMLLoader(getClass().getResource(gui));

        Parent root2 = fxmlloder.load();
        Scene home_scene = new Scene(root2);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }  
///
    @FXML
    private void ActionRetourMap(ActionEvent event) throws IOException {
        changescene("/views/Particip_rand.fxml",event);
    }
    
   
    
}
