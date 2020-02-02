package modelos;
// Generated 1/02/2020 07:18:57 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * EmpleadoCreaCasa generated by hbm2java
 */
public class EmpleadoCreaCasa  implements java.io.Serializable {


     private int empleadoCasaCreadaId;
     private CasaCreada casaCreada;
     private Empleado empleado;
     private Date fecha;

    public EmpleadoCreaCasa() {
    }

    public EmpleadoCreaCasa(int empleadoCasaCreadaId, CasaCreada casaCreada, Empleado empleado, Date fecha) {
       this.empleadoCasaCreadaId = empleadoCasaCreadaId;
       this.casaCreada = casaCreada;
       this.empleado = empleado;
       this.fecha = fecha;
    }
   
    public int getEmpleadoCasaCreadaId() {
        return this.empleadoCasaCreadaId;
    }
    
    public void setEmpleadoCasaCreadaId(int empleadoCasaCreadaId) {
        this.empleadoCasaCreadaId = empleadoCasaCreadaId;
    }
    public CasaCreada getCasaCreada() {
        return this.casaCreada;
    }
    
    public void setCasaCreada(CasaCreada casaCreada) {
        this.casaCreada = casaCreada;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}

