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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private Label subtitulo;

    @FXML
    void verClientesButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ClientesRUD.fxml"));
        centroStack.getChildren().clear();
        subtitulo.setText("INFORMACIÓN DE CLIENTES");
        centroStack.getChildren().add(root);
    }
    
    @FXML
    void registrarVendedorButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FormularioVendedor.fxml"));
        centroStack.getChildren().clear();
        subtitulo.setText("REGISTRAR NUEVO EMPLEADO");
        centroStack.getChildren().add(root);
    }
    @FXML
    void verEmpleadosButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EmpleadosRUD.fxml"));
        centroStack.getChildren().clear();
        subtitulo.setText("INFORMACIÓN DE EMPLEADOS");
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
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
