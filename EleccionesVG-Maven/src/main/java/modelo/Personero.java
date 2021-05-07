package modelo;

import java.util.Date;

public class Personero {
    
    private String dni;
    private String nombre;
    private String apaterno;
    private String amaterno;
    private Date nacimiento;
    private String telefono;
    private String asignacion;
    private String mesa;
    private String observacion;    
    private String estado; // Activo (A) y no activo (I)

    // Getter y Setter
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getAsignacion() {
        return asignacion;
    }
    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }
    public String getMesa() {
        return mesa;
    }
    public void setMesa(String mesa) {
        this.mesa = mesa;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Date getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }  
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getApaterno() {
        return apaterno;
    }
    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }
    public String getAmaterno() {
        return amaterno;
    }
    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }   
    
}
