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
    @FXML
    private JFXButton disenoRapidoB;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        stackPaneRoot.setOnKeyPressed(u->{
            if (u.getCode().equals(KeyCode.ESCAPE)){
                System.exit(0);
            }
        });
        
        
    }    



    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException {
        
        Parent newRoot = FXMLLoader.load(getClass().getResource("clientePrincipal.fxml"));
       
        switch (textFieldUsuario.getText()) {
            case "V":
                newRoot = FXMLLoader.load(getClass().getResource("vendedorPrincipal.fxml"));
                break;
            case "A":
                newRoot = FXMLLoader.load(getClass().getResource("AdminPrincipal.fxml"));
                break;
            case "C":
                newRoot = FXMLLoader.load(getClass().getResource("clientePrincipal.fxml"));
                break;
            default:
                break;
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

    @FXML
    private void abrirDisenoRapido(ActionEvent event) throws IOException {
        
         
        Parent root = FXMLLoader.load(getClass().getResource("DiseñoCasa.fxml"));
        
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
        stackPaneRoot.getScene().getWindow().hide();
        
    }

    
    
        
        
}
