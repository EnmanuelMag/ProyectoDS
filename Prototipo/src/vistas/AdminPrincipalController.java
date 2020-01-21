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
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Josue
 */
public class AdminPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton registrarVendedorB;

    @FXML
    private JFXButton verClientesB;

    @FXML
    private JFXButton verEmpleadosB;
    
    @FXML
    private StackPane centroStack;

    @FXML
    void verClientesButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClientesRUD.fxml"));
        centroStack.getChildren().clear();
        centroStack.getChildren().add(root);
    }
    
    @FXML
    void registrarVendedorButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FormularioVendedor.fxml"));
        centroStack.getChildren().clear();
        centroStack.getChildren().add(root);
    }
    @FXML
    void verEmpleadosButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmpleadosRUD.fxml"));
        centroStack.getChildren().clear();
        centroStack.getChildren().add(root);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
