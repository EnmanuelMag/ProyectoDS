/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Msi
 */
public class Prototipo extends Application {
    
    private Parent root;
    
    @Override
    public void start(Stage stage) throws Exception {

        root = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));
        
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        scene.setOnDragDetected((i)->{
            scene.getRoot().setOpacity(0.5f);
        
        });
        stage.setScene(scene);
        
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
