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
import javafx.fxml.Initializable;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MailController implements Initializable {
    @FXML
    private TextField emailtf;
    @FXML
    private TextField sujettf;
    @FXML
    private TextArea messagetf;
    @FXML
    private JFXButton btn_Mail;
     TextArea messager;
    @FXML
    private Button retour_mail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
     

//        ObservableList<String> cursors = FXCollections.observableArrayList("Non Archivées", "Archivées", "Tout");
//        selectcb.setItems(cursors);
    }    

    @FXML
    private void sendMail(ActionEvent event) {
       
            Mail.send(emailtf.getText(), sujettf.getText(), messagetf.getText());
            System.out.println("maillllll2");
            tray.notification.TrayNotification tr = new TrayNotification();
            tr.setTitle("Terminé");
            tr.setMessage("Mail envoyé avec succées");
            tr.setNotificationType(NotificationType.INFORMATION);
            tr.setAnimationType(AnimationType.SLIDE);

            tr.showAndDismiss(Duration.seconds(1));

            
    }
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
    private void ActionRetourMail(ActionEvent event) throws IOException {
          changescene("/views/Particip_rand.fxml",event);
    }
    
}
