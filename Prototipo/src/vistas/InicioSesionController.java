/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Josue
 */
public class InicioSesionController implements Initializable {

    @FXML
    private StackPane stackPaneRoot;
    @FXML
    private JFXTextField textFieldUsuario;
    @FXML
    private JFXButton iniciarSesionB;
    @FXML
    private JFXButton registrarseButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    



    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
        
        Parent newRoot = FXMLLoader.load(getClass().getResource("clientePrincipal.fxml"));
       
        if (textFieldUsuario.getText().equals("V")) {
            newRoot = FXMLLoader.load(getClass().getResource("vendedorPrincipal.fxml"));
        } else if (textFieldUsuario.getText().equals("A")) {
            newRoot = FXMLLoader.load(getClass().getResource("AdminPrincipal.fxml"));
        }else if(textFieldUsuario.getText().equals("C")) {
            newRoot = FXMLLoader.load(getClass().getResource("clientePrincipal.fxml"));
        }

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(newRoot);

        stage.setScene(scene);

        stage.show();
        stackPaneRoot.getScene().getWindow().hide();
        
    }

    @FXML
    private void registrarseHandle(ActionEvent event) throws IOException {
        //formCliente1
        
        Parent root = FXMLLoader.load(getClass().getResource("formCliente1.fxml"));
        
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
        stackPaneRoot.getScene().getWindow().hide();
        
    }

    @FXML
    private void iniciarSesion(KeyEvent event) {
    }

    
    
        
        
}
