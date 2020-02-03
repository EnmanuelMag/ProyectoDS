/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.StackPane;
import conexion.DBUtil;
import java.util.List;

import modelos.*;
/**
 * FXML Controller class
 *
 * @author Josue
 */
public class DiseñoCasaController implements Initializable {

    @FXML
    private StackPane stackPaneRoot;
    @FXML
    private JFXButton registrarmeButton;
    @FXML
    private JFXComboBox<Casabuilder> comboCasaBase;
    @FXML
    private Spinner<Integer> habitacionesSp;
    @FXML
    private Spinner<Integer> baniosSp;
    @FXML
    private Spinner<String> orientacionSp;
    @FXML
    private JFXToggleButton patioTb;
    @FXML
    private JFXToggleButton posicionTb;
    @FXML
    private Spinner<Double> superficieSp;
    private JFXToggleButton banoTb;
    @FXML
    private RadioButton enPiso;
    @FXML
    private RadioButton enGasfiteria;
    @FXML
    private RadioButton enIluminacion;
    @FXML
    private RadioButton enTecho;
    @FXML
    private RadioButton enBano;
    @FXML
    private JFXComboBox<Adicionalpiso> pisosCombo;
    @FXML
    private JFXComboBox<Adicionalgriferia> gasfiteriaCombo;
    @FXML
    private JFXComboBox<Adicionaliluminacion> iluminacionCombo;
    @FXML
    private JFXComboBox<Adicionaltecho> techoCombo;
    @FXML
    private JFXButton limpiarButton;

    private  SpinnerValueFactory<Integer> valueFactory ;
    private SpinnerValueFactory<Integer> valueFactory4;
    private SpinnerValueFactory<String> valueFactory3;
    private SpinnerValueFactory<Double> valueFactory2 ;
    
    private Cliente cliente;
    private Empleado empleado;
    @FXML
    private JFXComboBox<Adicionalbanios> banioCombo;
    private Casacreada casaCreada;
    private Cotizacion cotizacion;
    private CasacreadaAdicional casaAdicional;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final int initialValue = 0;
 
        // Value factory.
        valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, initialValue);
       
        valueFactory4 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, initialValue);
        
        ObservableList<String> orientaciones = FXCollections.observableArrayList(//
               "SUR","NORTE","ESTE","OESTE");

        valueFactory3 = //
               new SpinnerValueFactory.ListSpinnerValueFactory<>(orientaciones);
        
        valueFactory3.setValue("SUR");
        valueFactory2 = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, initialValue);
 
        habitacionesSp.setValueFactory(valueFactory4);
        habitacionesSp.valueProperty().addListener(new ChangeListener<Integer>() {
             @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                casaCreada.getCasabuilder().setNumHabitaciones(newValue);
            }
        });
        
        baniosSp.setValueFactory(valueFactory);
        baniosSp.valueProperty().addListener(new ChangeListener<Integer>() {
             @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                casaCreada.getCasabuilder().setNumBanios(newValue);
            }
        });
        orientacionSp.setValueFactory(valueFactory3);
        orientacionSp.valueProperty().addListener(new ChangeListener<String>() {
             @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                casaCreada.getCasabuilder().setOrientacion(newValue);
            }
            
        });
        superficieSp.setValueFactory(valueFactory2);
        
        superficieSp.valueProperty().addListener(new ChangeListener<Double>() {
             @Override
            public void changed(ObservableValue<? extends Double> observable, Double oldValue, Double newValue) {
                casaCreada.getCasabuilder().setMetrosCuadrados(newValue);
            }
            
        });
      

        enBano.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            banioCombo.setDisable(!isNowSelected);
                Adicionalbanios adicional=(!isNowSelected)?banioCombo.getValue():null;
                casaAdicional.setAdicionalbanios(banioCombo.getValue());
        });
        enGasfiteria.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            gasfiteriaCombo.setDisable(!isNowSelected);
                Adicionalgriferia adicional=(!isNowSelected)?gasfiteriaCombo.getValue():null;
                casaAdicional.setAdicionalgriferia(gasfiteriaCombo.getValue());
        });
        enIluminacion.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            iluminacionCombo.setDisable(!isNowSelected);
                Adicionaliluminacion adicional=(!isNowSelected)?iluminacionCombo.getValue():null;
                casaAdicional.setAdicionaliluminacion(iluminacionCombo.getValue());
        });
        enPiso.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            pisosCombo.setDisable(!isNowSelected);
                Adicionalpiso adicional=(!isNowSelected)?pisosCombo.getValue():null;
                casaAdicional.setAdicionalpiso(adicional);
        });
        enTecho.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            techoCombo.setDisable(!isNowSelected);
                Adicionaltecho adicional=(!isNowSelected)?techoCombo.getValue():null;
                casaAdicional.setAdicionaltecho(adicional);
        });
        
        patioTb.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            String texto=(newValue)?"Grande":"Pequeño";
            String texto2=(newValue)?"1":"0";
            patioTb.setText(texto);
            casaCreada.getCasabuilder().setPatio(texto2);
            }));
        posicionTb.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            String texto=(newValue)?"Esquinera":"No Esquinera";
            String texto2=(newValue)?"1":"0";
            posicionTb.setText(texto);
            casaCreada.getCasabuilder().setEsquinera(texto2);
        }));
        
        List<Casabuilder>lista = (List<Casabuilder>)DBUtil.getAll(Casabuilder.class);
        comboCasaBase.setItems(FXCollections.observableList(lista));
        comboCasaBase.setValue(lista.get(0));
        casaCreada.setCasabuilder(lista.get(0));
        cargarComboAdicionales();
        
        casaAdicional=new CasacreadaAdicional();
        casaAdicional.setCasacreada(casaCreada);
        casaAdicional.setAdicionalId(1);
        
    }    
    
    private void cargarComboAdicionales(){
        List<Casabuilder>pisos = (List<Casabuilder>)DBUtil.getAll(Adicionalpiso.class);
        comboCasaBase.setItems(FXCollections.observableList(pisos));
        comboCasaBase.setValue(pisos.get(0));
        List<Casabuilder>gasfiteria = (List<Casabuilder>)DBUtil.getAll(Adicionalgriferia.class);
        comboCasaBase.setItems(FXCollections.observableList(gasfiteria));
        comboCasaBase.setValue(gasfiteria.get(0));
        List<Casabuilder>iluminacion = (List<Casabuilder>)DBUtil.getAll(Adicionaliluminacion.class);
        comboCasaBase.setItems(FXCollections.observableList(iluminacion));
        comboCasaBase.setValue(iluminacion.get(0));
        List<Casabuilder>techos = (List<Casabuilder>)DBUtil.getAll(Adicionaltecho.class);
        comboCasaBase.setItems(FXCollections.observableList(techos));
        comboCasaBase.setValue(techos.get(0));
        
        
    }

    @FXML
    private void registrarmeHandle(ActionEvent event) {
        
        
        
        
    }

    @FXML
    private void comboCasaBaseManejador(ActionEvent event) {
        
        Casabuilder casa=comboCasaBase.getValue();
        if (casa!=null){
            casaCreada.setCasabuilder(casa);
            
            valueFactory4.setValue(casa.getNumHabitaciones());
            
            valueFactory.setValue(casa.getNumBanios());
            valueFactory3.setValue(casa.getOrientacion().toUpperCase());
            
            valueFactory2.setValue(casa.getMetrosCuadrados());
            
            if (casa.getEsquinera().equals('1')){
                posicionTb.setSelected(true);
            }else{
                posicionTb.setSelected(false);
            }
            if (casa.getPatio().equals('1')){
                patioTb.setSelected(true);
            }else{
                patioTb.setSelected(false);
            }
    }
    }
    
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
    }
    public void setEmpleado(Empleado empleado){
        this.empleado=empleado;
    }
   
    
}
