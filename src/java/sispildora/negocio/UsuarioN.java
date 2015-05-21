/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.negocio;

import sispildora.entidades.Usuario;
import sispildora.persistencia.Daos;
import sispildora.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;



public class UsuarioN {
   Daos dao;
   Connection c= new Conexion().getCon();
   
   
   
    public UsuarioN(){
    dao= new Daos();
    }// fin constructor
    
    
    
    public List<Usuario>ListadoUsuario(){
    return dao.ListadoUsuarios(c);
    //una vez programado pasamos al servlet
    
 }  //fin lista de datos
  

    
    public Usuario getUsuario(String user){
    return dao.getUsuario(c, user);
    //una vez programado pasamos al servlet al buscar
    
 }
        
        
        
    public Usuario getUsuarioMail(String mail){
    return dao.getUsuario(c, mail);
    //una vez programado pasamos al servlet al buscar
    
 }
     
        
        
    public void getInsertarUsuario(Usuario user) throws Exception{
    Conexion con= new Conexion();
//trows es una clase que permite programar nuestras propias excepciones
    String mensajeError="";
    String us= user.getUsuario();
    String nombre= user.getNombre();
    String clave= user.getClave();
    String perfil= user.getPerfil();
    String estado= user.getEstado();
    String mail= user.getMail();
    
    if("".equals(us)|| null==us){
    mensajeError+="<br>Ingrese el Usuario";
    }//fin usuario
    
    if("".equals(nombre)|| null==nombre){
    mensajeError+="<br>Ingrese el Nombre";
    }//fin nombre
    
    if("".equals(clave)|| null==clave){
    mensajeError+="<br>Ingrese la Clave";
    }//fin clave
    
    if("".equals(perfil)|| null==perfil){
    mensajeError+="<br>Ingrese el Perfil";
    }//fin perfil
    
    if("".equals(estado)|| null==estado){
    estado="Activo";
    }//fin estado
    
    if("".equals(mail)|| null==mail){
    mensajeError+="<br>Ingrese correo electronico";
    }//fin mail
    
    //lanzamos una excpcion cuando falte algun dato obligatorio
    if(!"".equals(mensajeError)){
    throw new Exception(mensajeError);
    }// fin si no hay ningun error
    
    
    //verificamos si el usuario existe
    //if (dao.getVerSiExisteUsuario(con.getCon(), us)){
    
     if (dao.getVerSiExisteUsuario(con.getCon(), us)){
         mensajeError="Ya existe el usuario:"+ us;
        throw new Exception (mensajeError);
     }
     

    
     //validar que no empiece por un caracter especifico
     if(us.charAt(0)=='0'){
         mensajeError="El usuario no puede iniciar con (0):"+ us;
        throw new Exception (mensajeError);
     }
     
     //lanzar una excepcion si el mail ya existe 
     //verificamos si el usuario existe
     if (dao.getVerSiExisteMail(con.getCon(), mail)){
         mensajeError="Ya existe el mail:"+ mail;
        throw new Exception (mensajeError);
     }
     
     mensajeError=dao.getInsertarUsuario(con.getCon(), us, nombre, clave, perfil, estado, mail);
     //lanzar excepcion para mostrar 
     
     if(!"".equals(mensajeError)){
     throw new Exception(mensajeError);
    }// fin si no hay ningun error

}//fin metodo-- regresamos al usuario servlet  

    
    
    public Usuario getValidarIngreso(String user, String ca) {
        Connection c = new Conexion().getCon();
        return dao.getValidarIngreso(c, user, ca);
// una vez programado pasamos
//  al UsuarioServlet al buscar
    }

    
    
    public void getActualizarUsuario(Usuario user) throws Exception{ //modificar un dato
//trows es una clase que permite programar nuestras propias excepciones
    Conexion con= new Conexion();
    String mensajeError="";
    String us= user.getUsuario();
    String nombre= user.getNombre();
    String clave= user.getClave();
    String perfil= user.getPerfil();
    String estado= user.getEstado();
    String mail= user.getMail();
    
    if("".equals(us)|| null==us){
    mensajeError+="<br>Ingrese el Usuario";
    }//fin usuario
    
    if("".equals(nombre)|| null==nombre){
    mensajeError+="<br>Ingrese el Nombre";
    }//fin nombre
    
    if("".equals(clave)|| null==clave){
    mensajeError+="<br>Ingrese la Clave";
    }//fin clave
    
    if("".equals(perfil)|| null==perfil){
    mensajeError+="<br>Ingrese el Perfil";
    }//fin perfil
    
    if("".equals(estado)|| null==estado){
    mensajeError+="<br>Ingrese el Estado";
    }//fin estado
    
    if("".equals(mail)|| null==mail){
    mensajeError+="<br>Ingrese el mail";
    }//fin mail
    
    //llamamos una excpcion cuando falte algun dato obligatorio
    if(!"".equals(mensajeError)){
    throw new Exception(mensajeError);
    }// fin si no hay ningun error
    
    
    //verificamos si el usuario existe
     
     mensajeError=dao.getActualizarUsuario(con.getCon(), us, nombre, clave, perfil, estado, mail);
     //lanzar excepcion para mostrar 
     
     if(!"".equals(mensajeError)){
     throw new Exception(mensajeError);
    }// fin si no hay ningun error

}//fin metodo-- regresamos al usuario servlet

    
    
}//fin clase
