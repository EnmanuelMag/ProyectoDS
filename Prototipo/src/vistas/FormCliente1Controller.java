/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;

import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Josue
 */
public class FormCliente1Controller implements Initializable {

    @FXML
    private StackPane stackPaneRoot;
    @FXML
    private JFXTextField nombreLbl;
    @FXML
    private JFXTextField apellidoLbl;
    @FXML
    private JFXTextField telefLbl;
    @FXML
    private JFXTextField correoLbl;
    @FXML
    private JFXTextField direccionLbl;
    @FXML
    private JFXComboBox<?> estadoCivilCmb;
    @FXML
    private JFXTextField empresaLbl;
    @FXML
    private JFXTextField direccionLaboralLbl;
    @FXML
    private JFXTextField cargoLbl;
    @FXML
    private JFXTextField telefonoLaboralLbl;
    @FXML
    private JFXComboBox<?> cargoLaboralCmb;
    @FXML
    private Spinner<?> numeroHijosSp;
    @FXML
    private JFXButton registrarmeBtn;


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
