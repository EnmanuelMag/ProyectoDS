package modelos;
// Generated 2/02/2020 08:19:21 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Adicionalbanios generated by hbm2java
 */
public class Adicionalbanios  implements java.io.Serializable {


     private Integer adicionalBaniosId;
     private String descripcion;
     private Double precio;
     private Set casacreadaAdicionals = new HashSet(0);

    public Adicionalbanios() {
    }

    public Adicionalbanios(String descripcion, Double precio, Set casacreadaAdicionals) {
       this.descripcion = descripcion;
       this.precio = precio;
       this.casacreadaAdicionals = casacreadaAdicionals;
    }
   
    public Integer getAdicionalBaniosId() {
        return this.adicionalBaniosId;
    }
    
    public void setAdicionalBaniosId(Integer adicionalBaniosId) {
        this.adicionalBaniosId = adicionalBaniosId;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public Set getCasacreadaAdicionals() {
        return this.casacreadaAdicionals;
    }
    
    public void setCasacreadaAdicionals(Set casacreadaAdicionals) {
        this.casacreadaAdicionals = casacreadaAdicionals;
    }




}

