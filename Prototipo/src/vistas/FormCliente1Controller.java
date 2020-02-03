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
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private Spinner<Integer> numeroHijosSp;
    @FXML
    private JFXButton registrarmeBtn;
    @FXML
    private Label xLbl;
    @FXML
    private JFXButton limpiarBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNumeroHijosSp();

    }

    @FXML
    private void registrarmeHandle(ActionEvent event) throws IOException {
        //Logica de registro
        Parent root = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
        stackPaneRoot.getScene().getWindow().hide();
    }

    private void initializeNumeroHijosSp() {
        SpinnerValueFactory<Integer> valueFactory
                = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        numeroHijosSp.setValueFactory(valueFactory);
        numeroHijosSp.setEditable(true);

    }

    @FXML
    private void exitHandle(MouseEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));

        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
        stackPaneRoot.getScene().getWindow().hide();
    }

    @FXML
    private void limpiarHandle(ActionEvent event) {
        nombreLbl.setText("");
        apellidoLbl.setText("");
        telefLbl.setText("");
        direccionLbl.setText("");
        correoLbl.setText("");
        cargoLbl.setText("");
        telefonoLaboralLbl.setText("");
        empresaLbl.setText("");
        direccionLaboralLbl.setText("");
        initializeNumeroHijosSp();
    }

}
