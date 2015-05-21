/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.entidades;

/**
 *
 * @author Usuario
 */
public class Usuario {
    
String usuario;
String nombre;
String clave;
String perfil;
String estado;
String mail;

public Usuario() {}

    public Usuario(String usuario, String nombre, String clave, String perfil, String estado, String mail) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.clave = clave;
        this.perfil = perfil;
        this.estado = estado;
        this.mail = mail;
    }

//luego de organizar las entidades con el mail nos vamos para el SQLHelpers

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
