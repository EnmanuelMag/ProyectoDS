package modelos;
// Generated 1/02/2020 07:18:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * CasaBuilder generated by hbm2java
 */
public class CasaBuilder  implements java.io.Serializable {


     private Integer casaBaseId;
     private double metrosCuadrados;
     private int numPlantas;
     private String esquinera;
     private String orientacion;
     private String patio;
     private int numHabitaciones;
     private int numBanios;
     private double precio;
     private Set casaCreadas = new HashSet(0);

    public CasaBuilder() {
    }

	
    public CasaBuilder(double metrosCuadrados, int numPlantas, String esquinera, String orientacion, String patio, int numHabitaciones, int numBanios, double precio) {
        this.metrosCuadrados = metrosCuadrados;
        this.numPlantas = numPlantas;
        this.esquinera = esquinera;
        this.orientacion = orientacion;
        this.patio = patio;
        this.numHabitaciones = numHabitaciones;
        this.numBanios = numBanios;
        this.precio = precio;
    }
    public CasaBuilder(double metrosCuadrados, int numPlantas, String esquinera, String orientacion, String patio, int numHabitaciones, int numBanios, double precio, Set casaCreadas) {
       this.metrosCuadrados = metrosCuadrados;
       this.numPlantas = numPlantas;
       this.esquinera = esquinera;
       this.orientacion = orientacion;
       this.patio = patio;
       this.numHabitaciones = numHabitaciones;
       this.numBanios = numBanios;
       this.precio = precio;
       this.casaCreadas = casaCreadas;
    }
   
    public Integer getCasaBaseId() {
        return this.casaBaseId;
    }
    
    public void setCasaBaseId(Integer casaBaseId) {
        this.casaBaseId = casaBaseId;
    }
    public double getMetrosCuadrados() {
        return this.metrosCuadrados;
    }
    
    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }
    public int getNumPlantas() {
        return this.numPlantas;
    }
    
    public void setNumPlantas(int numPlantas) {
        this.numPlantas = numPlantas;
    }
    public String getEsquinera() {
        return this.esquinera;
    }
    
    public void setEsquinera(String esquinera) {
        this.esquinera = esquinera;
    }
    public String getOrientacion() {
        return this.orientacion;
    }
    
    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }
    public String getPatio() {
        return this.patio;
    }
    
    public void setPatio(String patio) {
        this.patio = patio;
    }
    public int getNumHabitaciones() {
        return this.numHabitaciones;
    }
    
    public void setNumHabitaciones(int numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }
    public int getNumBanios() {
        return this.numBanios;
    }
    
    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Set getCasaCreadas() {
        return this.casaCreadas;
    }
    
    public void setCasaCreadas(Set casaCreadas) {
        this.casaCreadas = casaCreadas;
    }

    @Override
    public String toString() {
        return String.valueOf(casaBaseId);
    }

    


}


