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
public class AdminPrincipalController implements Initializable {

    @FXML
    private JFXButton registrarVendedorB;
    @FXML
    private JFXButton verClientesB;
    @FXML
    private JFXButton verEmpleadosB;
    @FXML
    private Label subtitulo;
    @FXML
    private StackPane centroStack;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    void registrarVendedorButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FormVendedor.fxml"));
        centroStack.getChildren().clear();
        subtitulo.setText("REGISTRAR NUEVO EMPLEADO");
        centroStack.getChildren().add(root);
        
    }

    @FXML
    void verListaClientes(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("vendedorListaClientes.fxml"));
        subtitulo.setText("LISTADO DE CLIENTES");
        centroStack.getChildren().clear();
        centroStack.getChildren().add(root);
        
    }

    @FXML
    void verListaEmpleados(ActionEvent event) throws IOException {
        this.subtitulo.setText("LISTADO DE EMPLEADOS");
        URL u = getClass().getResource("AdminListaEmpleados.fxml");
        
        Parent root = FXMLLoader.load(u);
        centroStack.getChildren().clear();
        centroStack.getChildren().add(root);
        
    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));
        
        Stage stage=new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
        centroStack.getScene().getWindow().hide();
        
    }
    
}
