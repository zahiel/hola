/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.entidades;

/**
 *
 * @author Usuario
 */
public class Empleado {
   
    String doc_empleado;
    String nombre;
    String clave;
    String cargo;

  public Empleado  (){}

    public Empleado(String doc_empleado, String nombre, String clave, String cargo) {
        this.doc_empleado = doc_empleado;
        this.nombre = nombre;
        this.clave = clave;
        this.cargo = cargo;
    }


    public String getDoc_empleado() {
        return doc_empleado;
    }

    public void setDoc_empleado(String doc_empleado) {
        this.doc_empleado = doc_empleado;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}

