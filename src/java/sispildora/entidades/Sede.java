/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.entidades;

/**
 *
 * @author Usuario
 */
public class Sede {
    private String consc, nombre, estado,usuario_creador, fecha_creacion; 

    public Sede() {
    }
 
    public Sede(String consc, String nombre, String estado, String usuario_creador, String fecha_creacion) {
        this.consc = consc;
        this.nombre = nombre;
        this.estado = estado;
        this.usuario_creador = usuario_creador;
        this.fecha_creacion = fecha_creacion;
        
        
    }

    public Sede(String consc, String nombre, String estado) {
        this.consc = consc;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getConsc() {
        return consc;
    }

    public void setConsc(String consc) {
        this.consc = consc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario_creador() {
        return usuario_creador;
    }

    public void setUsuario_creador(String usuario_creador) {
        this.usuario_creador = usuario_creador;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
   //pasamos apersistencia SQLHelpers
    
    
}
