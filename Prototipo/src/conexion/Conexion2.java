/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;


import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 *
 * @author Msi
 */
public class Conexion2 {
    
    private static Session conexion = null;
    
    private static Session conexion(){
        
        SessionFactory sesion = MyDB.getInstance();
        return sesion.openSession();  
    }
    
    public static Session getInstance(){
        
        return conexion == null ? conexion = conexion() : conexion;
    }
    
    
    public boolean isConnected(){
        
        return conexion.isConnected();
    }
    
    
}
