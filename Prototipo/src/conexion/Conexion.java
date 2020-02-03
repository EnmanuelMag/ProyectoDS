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
public  class Conexion {
    
    private static Session conexion = null;
    
    private static Session Conexion(){
        
        SessionFactory sesion = NewHibernateUtil.getSessionFactory();
        return sesion.openSession();  
    }
    
    public static Session getInstance(){
        
        return conexion == null ? conexion = Conexion() : conexion;
    }
    
    public void close(){
        
        if(conexion != null && conexion.isOpen()) conexion.close();
                
    }
    
    public boolean isConnected(){
        
        return conexion.isConnected();
    }
    
    
}
