/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import conexion.Conexion2;
import conexion.DBUtil;
import java.io.IOException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import modelos.Cargo;
import modelos.Cliente;
import modelos.Direccion;
import modelos.Empresa;
import modelos.Estadocivil;
import org.hibernate.Session;

/**
 * FXML Controller class
 *
 * @author Josue
 */
public class FormCliente1Controller implements Initializable {

    @FXML
    private StackPane stackPaneRoot;
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
    private JFXComboBox<Estadocivil> estadoCivilCmb;
    @FXML
    private JFXTextField empresaLbl;
    @FXML
    private JFXTextField direccionLaboralLbl;
    private JFXTextField cargoLbl;
    @FXML
    private JFXTextField telefonoLaboralLbl;
    @FXML
    private JFXComboBox<Cargo> cargoLaboralCmb;
    @FXML
    private Spinner<Integer> numeroHijosSp;
    @FXML
    private JFXButton registrarmeBtn;
    @FXML
    private Label xLbl;
    @FXML
    private JFXButton limpiarBtn;
    @FXML
    private JFXTextField usuarioLbl;
    @FXML
    private JFXTextField contrasenaLbl;
    @FXML
    private JFXTextField nombreLbl1;
    private SpinnerValueFactory<Integer> valueFactory;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeNumeroHijosSp();
        initializeComboBxs();
        
    }
    private void initializeComboBxs() {
        List<Estadocivil> estadosCivill=(List<Estadocivil>)DBUtil.getAll( Estadocivil.class);
        estadoCivilCmb.setItems(FXCollections.observableList(estadosCivill));
        estadoCivilCmb.setValue(estadosCivill.get(0));
        
        List<Cargo> cargosl=(List<Cargo>)DBUtil.getAll(Cargo.class);
        cargoLaboralCmb.setItems(FXCollections.observableList(cargosl));
        cargoLaboralCmb.setValue(cargosl.get(0));
        
    }

    private void initializeNumeroHijosSp() {
        valueFactory =new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
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
        usuarioLbl.setText("");
        contrasenaLbl.setText("");
        valueFactory.setValue(0);
        initializeNumeroHijosSp();
    }

    @FXML
    private void registrarmeManejador(ActionEvent event) throws IOException {
        
         boolean validador=true;
        
        List<Cliente> clientes= (List<Cliente>)DBUtil.getAll(Cliente.class);
        for (Cliente c:clientes){
            if (c.getUsuario().equals(usuarioLbl.getText())){
                validador=false;
            }
        }
        Cliente cl=new Cliente();
        if (validador){
            cl.setActivo("1");
            cl.setApellidos(apellidoLbl.getText());
            cl.setCargo(cargoLaboralCmb.getValue());
            cl.setContrasena(contrasenaLbl.getText());
            cl.setCorreo(correoLbl.getText());
            cl.setDireccion((Direccion)DBUtil.get(Direccion.class, 1));
            cl.setIdentificador("0000");
            cl.setEmpresa((Empresa)DBUtil.get(Empresa.class, 1));
            cl.setEstadocivil(estadoCivilCmb.getValue());
            cl.setNombres(nombreLbl1.getText());
            cl.setNumHijos(valueFactory.getValue());
            cl.setTelefTrabajo(telefonoLaboralLbl.getText());
            cl.setTelefono(telefLbl.getText());
            cl.setUsuario(usuarioLbl.getText());
        }
        if (cl.getContrasena().length()==0 || cl.getUsuario().length()==0){
            validador=false;
        }
        
        if (validador){
            DBUtil.agregar(cl);
            System.out.println("Usuario escrito");
            
            Parent root = FXMLLoader.load(getClass().getResource("InicioSesion.fxml"));

            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);

            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
            stackPaneRoot.getScene().getWindow().hide();
        }else{
            
            System.err.println("Tiene campos no validos");
        }
    }

}
