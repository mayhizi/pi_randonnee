/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author user
 */
public class Drawer_randController implements Initializable {
     
    @FXML
    private VBox Vbox_rand;

    @FXML
    private JFXButton button_ajouter;

    @FXML
    void ActionAjout(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();

        switch (btn.getText()) {

            case "Gestion des randonnées": {
                System.out.println(btn.getText());
                AnchorPane pane1 = FXMLLoader.load(getClass().getResource("/views/Drawer_rand.fxml"));
                AccueilController.rootP.getChildren().clear();
                AccueilController.rootP.getChildren().setAll(pane1);

                break;
            }


        }
        

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    
}
