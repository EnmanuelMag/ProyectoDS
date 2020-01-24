/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Josue
 */
public class ClientePrincipalController implements Initializable {

    @FXML
    private Label subtitulo;
    @FXML
    private StackPane centroStack;
    @FXML
    private JFXButton nuevoDiseñoB;
    @FXML
    private JFXButton verMisDiseñosB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));
        
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
        centroStack.getScene().getWindow().hide();
    }

    @FXML
    private void nuevoDiseñoBHandle(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("DiseñoCasa.fxml"));
        centroStack.getChildren().clear();
        subtitulo.setText("DISEÑO NUEVO");
        centroStack.getChildren().add(root);
    }

    @FXML
    private void verMisDiseñosBHandle(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("clienteListaDiseños.fxml"));
        centroStack.getChildren().clear();
        subtitulo.setText("MIS DISEÑOS");
        centroStack.getChildren().add(root);
    }
    
    
    
}
