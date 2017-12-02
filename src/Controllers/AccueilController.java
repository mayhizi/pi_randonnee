/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AccueilController implements Initializable {
      
   @FXML
    private AnchorPane anchrpane;
@FXML
    private JFXHamburger id_burger;

    @FXML
    private JFXDrawer id_drawer;
public static AnchorPane rootP;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    rootP = anchrpane;
        try {

            VBox box = FXMLLoader.load(getClass().getResource("/views/Drawer.fxml"));

            id_drawer.setSidePane(box);

            HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(id_burger);

            transition.setRate(-1);

            id_burger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {

                transition.setRate(transition.getRate() * -1);

                transition.play();

                if (id_drawer.isShown()) {
                    id_drawer.close();

                } else {
                    id_drawer.open();
                }

            });
        } catch (IOException ex) {
            Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
        }

    

    }    
    
}
