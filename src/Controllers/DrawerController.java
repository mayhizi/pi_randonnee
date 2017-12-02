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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author user
 */
public class DrawerController implements Initializable {
  @FXML
    private VBox id_vbox;

     @FXML
    private JFXButton id_button_gestion;
     

    @FXML
    void button_gestion_rand(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();

        switch (btn.getText()) {

            case "Gestion des randonnées": {
                System.out.println(btn.getText());
                AnchorPane pane1;
            pane1 = FXMLLoader.load(getClass().getResource("/views/Rand_Wrap.fxml"));
                AccueilController.rootP.getChildren().clear();
                AccueilController.rootP.getChildren().setAll(pane1);

                break;
            }


        }
        

    }


    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     void changescene(String gui, ActionEvent event) throws IOException {
        FXMLLoader fxmlloder = new FXMLLoader(getClass().getResource(gui));

        Parent root1 = fxmlloder.load();
        Scene home_scene = new Scene(root1);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(home_scene);
        app_stage.show();
    }
    
}
