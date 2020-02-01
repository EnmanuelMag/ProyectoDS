/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author Josue
 */
public class FormVendedorController implements Initializable {

    @FXML
    private StackPane stackPaneRoot;
    @FXML
    private JFXButton registrarmeButton;
    @FXML
    private JFXButton registrarmeButton1;

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
