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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 *
 * @author Josue
 *
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
    @FXML
    private Label xLbl;
    @FXML
    private JFXTextField usuarioLbl;
    @FXML
    private JFXTextField contrasenaLbl2;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

    @FXML
    private void registrarmeHandle(ActionEvent event) throws IOException {
        //Logica de registro
        Parent root = FXMLLoader.load(getClass().getResource("AdminPrincipal.fxml"));

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
        stackPaneRoot.getScene().getWindow().hide();
    }

    private void limpiarHandle(ActionEvent event) {
        nombreLbl.setText("");
        apellidoLbl.setText("");
        identificacionLbl.setText("");
        telefonoLbl.setText("");
        direccionLbl.setText("");
        correoLbl.setText("");
        cargoLbl.setText("");
        telefonoLaboralLbl.setText("");
    }

    @FXML
    private void exitHandle(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AdminPrincipal.fxml"));

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
        stackPaneRoot.getScene().getWindow().hide();
    }

}
