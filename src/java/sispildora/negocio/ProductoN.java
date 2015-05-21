/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.negocio;

import java.sql.Connection;
import java.util.List;
import sispildora.entidades.Producto;
import sispildora.persistencia.Daos;
import sispildora.utilidades.Conexion;

/**
 *
 * @author PRIVADA MANU
 */
public class ProductoN {
    
   

        Daos dao;
        Connection c = new Conexion().getCon();
   
        public ProductoN() {
            dao = new Daos();
        }// fin constructor
    
        public List<Producto> ListadoProducto() {
            return dao.ListadoProducto(c);
        }
            
        public Producto getProducto(String Prod) {
            return dao.getProducto(c, Prod);
            //una vez programado pasamos al servlet al buscar

        }//Fin getproducto
        
        public void getInsertarProducto(Producto prod) throws Exception{
    Conexion con= new Conexion();
//trows es una clase que permite programar nuestras propias excepciones
    String mensajeError="";
    String cod_producto= prod.getCod_producto();
    String descripcion= prod.getDescripcion();
    String valor= prod.getValor();
    String costo= prod.getCosto();
    String stock_min= prod.getStock_min();
    String stock_max= prod.getStock_max();
    String estado= prod.getEstado();
    String tipo= prod.getTipo();
    
 
    
    if("".equals(cod_producto)|| null== cod_producto){
    mensajeError+="<br>Ingrese el Codigo del producto";
    }//fin
    
    if("".equals(estado)|| null== estado){
    mensajeError+="<br>Ingrese el Estado";
    }//fin clave
    
    if("".equals(descripcion)|| null== descripcion){
    mensajeError+="<br>Ingrese la Descripcion";
    }//fin
    
    if("".equals(valor)|| null==valor){
    mensajeError+="<br>Ingrese la Cantidad";
    }//fin
    
        if("".equals(costo)|| null==costo){
    mensajeError+="<br>Ingrese la costo";
    }//fin
    
    if("".equals(stock_min)|| null==stock_min){
    mensajeError+="<br>Ingrese el Precio";
    }//fin
    
        if("".equals(stock_max)|| null==stock_max){
    mensajeError+="<br>Ingrese el Precio";
    }//fin
    
        if("".equals(estado)|| null==estado){
    mensajeError+="<br>Ingrese el Precio";
    }//fin
    
        if("".equals(tipo)|| null==tipo){
    mensajeError+="<br>Ingrese el Precio";
    }//fin
    
    
    
    
    //lanzamos una excpcion cuando falte algun dato obligatorio
    if(!"".equals(mensajeError)){
    throw new Exception(mensajeError);
    }// fin si no hay ningun error
    
    
    //verificamos si el usuario existe
    //if (dao.getVerSiExisteUsuario(con.getCon(), us)){
    
     
     

     

}//fin metodo-- regresamos al usuario servlet 
}

