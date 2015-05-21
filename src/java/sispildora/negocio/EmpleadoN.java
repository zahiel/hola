/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.negocio;

import java.sql.Connection;
import java.util.List;
import sispildora.entidades.Empleado;
import sispildora.entidades.Usuario;
import sispildora.persistencia.Daos;
import sispildora.utilidades.Conexion;


/**
 *
 * @author Usuario
 */
public class EmpleadoN {
   Daos dao;
    public EmpleadoN(){
    dao= new Daos();
    
    
    }
 public List<Empleado>ListadoEmpleados(){
 Connection c= new Conexion().getCon();
    return dao.ListadoEmpleado(c);
    
    
 }  
  public Usuario getEmpleado(String emp){
 Connection c;
       c = new Conexion ().getCon();
    return dao.getUsuario(c, emp);
    
    
 }     
public void getInsertarEmpleado (Empleado emp) throws Exception{

    Conexion con= new Conexion ();
    String mensajeError="";
    
    String doc_empleado= emp.getDoc_empleado();
    String nombre= emp.getNombre();
    String clave= emp.getClave();
    String cargo= emp.getCargo();
    
    if("".equals(doc_empleado)|| null==doc_empleado){
    mensajeError+="<br>Ingrese el Codigo";
    }
    
    if("".equals(nombre)|| null==nombre){
    mensajeError+="<br>Ingrese el Nombre";
    }
    
    if("".equals(clave)|| null==clave){
    mensajeError+="<br>Ingrese la Clave";
    }
    
    if("".equals(cargo)|| null==cargo){
    cargo="Electrico, Mecanico, Pintor, Vendedor";
    }
    
    if(!"".equals(mensajeError)){
    throw new Exception(mensajeError);
    }
    mensajeError= dao.getInsertarEmpleado(con.getCon(),doc_empleado, nombre, clave, cargo);
   
    
     if(!"".equals(mensajeError)){
    throw new Exception(mensajeError);
     }
}
}