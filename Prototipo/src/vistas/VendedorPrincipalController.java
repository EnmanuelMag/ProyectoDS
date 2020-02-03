/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class VendedorPrincipalController implements Initializable {
    //980-645
    private Label tituloDash;
    

    private StackPane centroStack;

    /**
     * Initializes the controller class.
     */
     
    void verListaClientes(ActionEvent event) throws IOException {
        this.tituloDash.setText("LISTADO DE CLIENTES");
        URL u = getClass().getResource("vendedorListaClientes.fxml");
        
        Parent root = FXMLLoader.load(u);
        centroStack.getChildren().clear();
        centroStack.getChildren().add(root);
        
    }
    void disenarNuevaCasa(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DiseñoCasa.fxml"));
        centroStack.getChildren().clear();
        this.tituloDash.setText("DISEÑO NUEVO");
        centroStack.getChildren().add(root);
    }
    void cerrarSesion(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));
        
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
        centroStack.getScene().getWindow().hide();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
    } 

}
