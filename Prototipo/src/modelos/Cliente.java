package modelos;
// Generated 1/02/2020 07:18:57 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int clienteId;
     private Cargo cargo;
     private Direccion direccion;
     private Empresa empresa;
     private EstadoCivil estadoCivil;
     private String nombres;
     private String apellidos;
     private String telefono;
     private String correo;
     private String activo;
     private String identificador;
     private String telefTrabajo;
     private int numHijos;
     private Set cotizacions = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(int clienteId, Direccion direccion, EstadoCivil estadoCivil, String nombres, String apellidos, String telefono, String correo, String activo, String identificador, String telefTrabajo, int numHijos) {
        this.clienteId = clienteId;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.activo = activo;
        this.identificador = identificador;
        this.telefTrabajo = telefTrabajo;
        this.numHijos = numHijos;
    }
    public Cliente(int clienteId, Cargo cargo, Direccion direccion, Empresa empresa, EstadoCivil estadoCivil, String nombres, String apellidos, String telefono, String correo, String activo, String identificador, String telefTrabajo, int numHijos, Set cotizacions) {
       this.clienteId = clienteId;
       this.cargo = cargo;
       this.direccion = direccion;
       this.empresa = empresa;
       this.estadoCivil = estadoCivil;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.telefono = telefono;
       this.correo = correo;
       this.activo = activo;
       this.identificador = identificador;
       this.telefTrabajo = telefTrabajo;
       this.numHijos = numHijos;
       this.cotizacions = cotizacions;
    }
   
    public int getClienteId() {
        return this.clienteId;
    }
    
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public Direccion getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    public Empresa getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public EstadoCivil getEstadoCivil() {
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getActivo() {
        return this.activo;
    }
    
    public void setActivo(String activo) {
        this.activo = activo;
    }
    public String getIdentificador() {
        return this.identificador;
    }
    
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    public String getTelefTrabajo() {
        return this.telefTrabajo;
    }
    
    public void setTelefTrabajo(String telefTrabajo) {
        this.telefTrabajo = telefTrabajo;
    }
    public int getNumHijos() {
        return this.numHijos;
    }
    
    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }
    public Set getCotizacions() {
        return this.cotizacions;
    }
    
    public void setCotizacions(Set cotizacions) {
        this.cotizacions = cotizacions;
    }




}

