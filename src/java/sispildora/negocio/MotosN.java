/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sispildora.negocio;

import java.sql.Connection;
import java.util.List;
import sispildora.entidades.Motos;
import sispildora.persistencia.Daos;
import sispildora.utilidades.Conexion;

/**
 *
 * @author Usuario
 */
public class MotosN {
   Daos dao1;
    public MotosN(){
    dao1= new Daos();
    
    
    }// fin constructor
 public List<Motos>ListadoMotos(String campo, String dato){
 Connection c1= new Conexion().getCon();
    return dao1.ListadoMotos(c1,campo, dato);
    //una vez programado pasamos al servlet
    
 }  //fin lista de datos
  public Motos getMotos(String campo,String dato){
 Connection c1= new Conexion().getCon();
    return dao1.getMotos(c1,campo, dato);
    //una vez programado pasamos al servlet al buscar
    
 }  
  
  public void getInsertarMotos(Motos mot) throws Exception{
//trows es una clase que permite programar nuestras propias excepciones
    Conexion con1= new Conexion();
    String mensajeError="";
    String placa= mot.getPlaca();
    String cod_cliente= mot.getCod_Cliente();
    String marca= mot.getMarca();
    String color= mot.getColor();
    String kilometraje= mot.getKilometraje();
    String modelo= mot.getModelo();
    
    if("".equals(placa)|| null==placa){
    mensajeError+="<br>Ingrese la Placa";
    }//fin placa
    
    if("".equals(cod_cliente)|| null==cod_cliente){
    mensajeError+="<br>Ingrese el Codigo";
    }//fin codigo_cliente
    
    if("".equals(marca)|| null==marca){
    mensajeError+="<br>Ingrese la Marca";
    }//fin marca
    
    if("".equals(color)|| null==color){
    mensajeError+="<br>Ingrese el Color";
    }//fin color
    
    if("".equals(kilometraje)|| null==kilometraje){
    mensajeError+="<br>Ingrese el Kilometraje";
    }//fin kilometraje
    
    if("".equals(modelo)|| null==modelo){
    mensajeError+="<br>Ingrese el Modelo";
    }//fin modelo
    
    //llamamos una excpcion cuando falte algun dato obligatorio
    if(!"".equals(mensajeError)){
    throw new Exception(mensajeError);
    }// fin si no hay ningun error
    //ejecutamos la accion
    
    if (dao1.siExiteMoto(con1.getCon(), placa)){
    mensajeError="La Moto ya está registrada";
    throw new Exception(mensajeError);
    }
    
    mensajeError= dao1.getInsertarMotos(con1.getCon(), placa, cod_cliente, marca, color, kilometraje, modelo);
    //validamos y enviamos una excepcion al guardar el dato
    
     if(!"".equals(mensajeError)){
    throw new Exception(mensajeError);
     }//

}//fin metodo-- regresamos al usuario servlet
    
}//fin clase
