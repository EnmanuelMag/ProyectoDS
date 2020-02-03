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
    @FXML
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
    private JFXComboBox<?> pisosCombo;
    @FXML
    private JFXComboBox<?> gasfiteriaCombo;
    @FXML
    private JFXComboBox<?> iluminacionCombo;
    @FXML
    private JFXComboBox<?> techoCombo;
    @FXML
    private JFXButton limpiarButton;

    private  SpinnerValueFactory<Integer> valueFactory ;
    private SpinnerValueFactory<Integer> valueFactory4;
    private SpinnerValueFactory<String> valueFactory3;
    private SpinnerValueFactory<Double> valueFactory2 ;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final int initialValue = 0;
 
        // Value factory.
        valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, initialValue);
        valueFactory4 = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, initialValue);
        
        ObservableList<String> orientaciones = FXCollections.observableArrayList(//
               "SUR","NORTE","ESTE","OESTE");
        valueFactory3 = //
               new SpinnerValueFactory.ListSpinnerValueFactory<>(orientaciones);
        
        valueFactory3.setValue("SUR");
 
        valueFactory2 = //
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, initialValue);
 
        habitacionesSp.setValueFactory(valueFactory4);
       
        baniosSp.setValueFactory(valueFactory);
        orientacionSp.setValueFactory(valueFactory3);
        superficieSp.setValueFactory(valueFactory2);
        
        
        
        
        enBano.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            banoTb.setDisable(!isNowSelected);
        });
        enGasfiteria.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            gasfiteriaCombo.setDisable(!isNowSelected);
        });
        enIluminacion.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            iluminacionCombo.setDisable(!isNowSelected);
        });
        enPiso.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            pisosCombo.setDisable(!isNowSelected);
        });
        enTecho.selectedProperty().addListener((ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) -> {
            techoCombo.setDisable(!isNowSelected);
        });
        
        patioTb.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            String texto=(newValue)?"Grande":"Pequeño";
            patioTb.setText(texto);
            }));
        posicionTb.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            String texto=(newValue)?"Esquinera":"No Esquinera";
            posicionTb.setText(texto);
        }));
        banoTb.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            String texto=(newValue)?"Si":"No";
            banoTb.setText(texto);
                
}));    
       
        List<Casabuilder>lista = (List<Casabuilder>)DBUtil.getAll(Casabuilder.class);
        comboCasaBase.setItems(FXCollections.observableList(lista));
        
    }    

    @FXML
    private void registrarmeHandle(ActionEvent event) {
    }

    @FXML
    private void comboCasaBaseManejador(ActionEvent event) {
        
        Casabuilder casa=comboCasaBase.getValue();
        if (casa!=null){
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
    
}
