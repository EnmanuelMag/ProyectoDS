/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class FormVendedorController implements Initializable {

    @FXML
    private StackPane stackPaneRoot;
    @FXML
    private JFXTextField nombreLbl;
    @FXML
    private JFXTextField apellidoLbl;
    @FXML
    private JFXTextField identificacionLbl;
    @FXML
    private JFXTextField telefonoLbl;
    @FXML
    private JFXTextField direccionLbl;
    @FXML
    private JFXTextField correoLbl;
    @FXML
    private JFXComboBox<?> estadoCivilCmb;
    @FXML
    private JFXTextField cargoLbl;
    @FXML
    private JFXTextField telefonoLaboralLbl;
    @FXML
    private JFXButton registrarBtn;
    @FXML
    private JFXButton limpiarBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrarmeHandle(ActionEvent event) {
    }
    
}
