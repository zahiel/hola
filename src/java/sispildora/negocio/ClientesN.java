/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.negocio;
import java.sql.Connection;
import java.util.List;
import sispildora.entidades.Clientes;
import sispildora.persistencia.Daos;
import sispildora.utilidades.Conexion;

/**
 *
 * @author Usuario
 */
public class ClientesN {
   Daos dao;
    public ClientesN(){
    dao= new Daos();
    
    }// fin constructor
 public List<Clientes>ListadoClientes(){
 Connection c4= new Conexion().getCon();
    return dao.ListadoClientes(c4);
    //una vez programado pasamos al servlet
    
 }  //fin lista de datos
  public Clientes getClientes(String Cli){
 Connection c4= new Conexion().getCon();
    return dao.getClientes(c4, Cli);
    //una vez programado pasamos al servlet al buscar
    
 }   

 }