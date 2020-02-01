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
    private JFXComboBox<?> comboCasaBase;
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
    private RadioButton enBaño;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //habitacionesSp = new Spinner<Integer>();
        //baniosSp = new Spinner<Integer>();
        //orientacionSp = new Spinner<String>();
        //superficieSp = new Spinner<Double>();
        final int initialValue = 0;
 
        // Value factory.
        SpinnerValueFactory<Integer> valueFactory = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, initialValue);
        
        SpinnerValueFactory<Integer> valueFactory4 = //
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, initialValue);
        
        
        ObservableList<String> orientaciones = FXCollections.observableArrayList(//
               "SUR","NORTE","ESTE","OESTE");
        
        SpinnerValueFactory<String> valueFactory3 = //
               new SpinnerValueFactory.ListSpinnerValueFactory<String>(orientaciones);
        
        valueFactory3.setValue("SUR");
 
        
        SpinnerValueFactory<Double> valueFactory2 = //
                new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10, initialValue);
 
        habitacionesSp.setValueFactory(valueFactory4);
        baniosSp.setValueFactory(valueFactory);
        orientacionSp.setValueFactory(valueFactory3);
        superficieSp.setValueFactory(valueFactory2);
        
        
        
        
        enBaño.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                banoTb.setDisable(wasPreviouslySelected);
            }});
        enGasfiteria.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                gasfiteriaCombo.setDisable(wasPreviouslySelected);
            }});
        enIluminacion.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                iluminacionCombo.setDisable(wasPreviouslySelected);
            }});
        enPiso.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                pisosCombo.setDisable(wasPreviouslySelected);
            }});
        enTecho.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean wasPreviouslySelected, Boolean isNowSelected) {
                techoCombo.setDisable(wasPreviouslySelected);
            }});
        
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
        
    }    

    @FXML
    private void registrarmeHandle(ActionEvent event) {
    }
    
}
