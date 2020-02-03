/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import modelos.Cliente;

/**
 * FXML Controller class
 *
 * @author Josue
 */
public class ClienteListaDiseñosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Cliente cliente;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }    
    public void setCliente(Cliente cliente){
        this.cliente=cliente;
        
    }
    
}
