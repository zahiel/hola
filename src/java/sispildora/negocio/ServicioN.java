/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.negocio;

import java.sql.Connection;
import java.util.List;
import sispildora.entidades.Servicio;
import sispildora.persistencia.Daos;
import sispildora.utilidades.Conexion;

/**
 *
 * @author Usuario
 */
public class ServicioN {
    Daos dao;
    public ServicioN(){
    dao= new Daos();
    
   }// fin constructor  
    
public List<Servicio> ListadoServicio() {
Connection c3 = new Conexion().getCon();
return dao.ListadoServicio(c3);
//una vez programado pasamos al ServicioServlet
}  //fin lista de datos


//Buscar un dato
public Servicio getServicio(String se) {
Connection c3 = new Conexion().getCon();
return dao.getServicio(c3, se);
//una vez programado pasamos al ServicioServlet al buscar

}      
}