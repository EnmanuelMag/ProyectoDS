package modelos;
// Generated 2/02/2020 10:33:02 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Pais generated by hbm2java
 */
public class Pais  implements java.io.Serializable {


     private Integer paisId;
     private String descripcion;
     private Set provincias = new HashSet(0);

    public Pais() {
    }

	
    public Pais(String descripcion) {
        this.descripcion = descripcion;
    }
    public Pais(String descripcion, Set provincias) {
       this.descripcion = descripcion;
       this.provincias = provincias;
    }
   
    public Integer getPaisId() {
        return this.paisId;
    }
    
    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getProvincias() {
        return this.provincias;
    }
    
    public void setProvincias(Set provincias) {
        this.provincias = provincias;
    }




}


