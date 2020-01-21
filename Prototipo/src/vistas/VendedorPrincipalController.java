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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Msi
 */
public class VendedorPrincipalController implements Initializable {
    //980-645
    @FXML
    private Label tituloDash;
    
    @FXML
    private TreeTableView listaClientes;
    
    @FXML
    private JFXButton verClientesB;

    @FXML
    private JFXButton disenoCasaB;
    
    @FXML
    private StackPane centroStack;

    /**
     * Initializes the controller class.
     */
     
    @FXML
    void verListaClientes(ActionEvent event) throws IOException {
        this.tituloDash.setText("Listado de Clientes");
        URL u = getClass().getResource("vendedorListaClientes.fxml");
        
        Parent root = FXMLLoader.load(u);
        centroStack.getChildren().clear();
        centroStack.getChildren().add(root);
        
    }
    @FXML
    void disenarNuevaCasa(ActionEvent event) throws IOException {
        //this.tituloDash.setText("Diseño de Casa");
        Parent root = FXMLLoader.load(getClass().getResource("EmpleadosRUD.fxml"));
        centroStack.getChildren().clear();
        centroStack.getChildren().add(root);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    } 
    
}
