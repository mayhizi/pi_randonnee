/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UI extends Application{
    public static void main(String[] args) {
        launch(args);
     
    }

    @Override
    public void start(Stage primarystage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Rand_Wrap.fxml"));
        Scene scene = new Scene(root);
        primarystage.setScene(scene);
        primarystage.show();
        
    }
    
//   
//     @Override
//    public void start(Stage primarystage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/views/map_view.fxml"));
//        Scene scene = new Scene(root);
//        primarystage.setScene(scene);
//        primarystage.show();
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
        
}

