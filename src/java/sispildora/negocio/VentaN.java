/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.negocio;

import sispildora.persistencia.Daos;
import sispildora.utilidades.Conexion;
import java.sql.Connection;
import java.util.List;
import sispildora.entidades.Venta;
import sispildora.entidades.Venta_detalle;

/**
 *
 * @author PRIVADA MANU
 */
public class VentaN {

    Daos dao;
    Conexion c = new Conexion();

    public VentaN() {
        dao = new Daos();
    }// fin constructor

    public List<Venta> ListadoVenta() {
        return dao.ListadoVenta(c.getCon());
        //una vez programado pasamos al servlet

    }  //fin lista de datos

    public Venta getVenta(String vent) {
        return dao.getVenta(c.getCon(), vent);
        //una vez programado pasamos al servlet al buscar

    }

    public void InsertarVenta(Venta hijov) throws Exception {
        Conexion con = new Conexion();

        String mensajeError = "";
        String nrofactura = hijov.getNrofactura();
        String idecliente = hijov.getIdecliente();
        String usuario = hijov.getUsuario();
        String fecha = hijov.getFecha();
        String subtotal = hijov.getSubtotal();
        String iva = hijov.getIva();
        String tipo = hijov.getTipo();

        if ("".equals(nrofactura) || null == nrofactura) {
            mensajeError += "<br>Ingrese el No.Factura";
        }//fin FACTURA

        if ("".equals(idecliente) || null == idecliente) {
            mensajeError += "<br>Ingrese el ID del cliente";
        }//fin CLIENTE

        if ("".equals(usuario) || null == usuario) {
            mensajeError += "<br>Ingrese el Usuario";
        }//fin USUARIO

        if ("".equals(fecha) || null == fecha) {
            mensajeError += "<br>Ingrese la fecha";
        }//fin FECHA

        if ("".equals(subtotal) || null == subtotal) {
            mensajeError += "<br>Ingrese el No.Factura";
        }//fin TOTAL

        if ("".equals(iva) || null == iva) {
            mensajeError += "<br>Ingrese el Iva";
        }//fin IVA

        if ("".equals(tipo) || null == tipo) {
            mensajeError += "<br>Ingrese el Tipo";
        }//fin tipo


        mensajeError = dao.getInsertarVenta(c.getCon(), nrofactura, idecliente, usuario, fecha, subtotal, iva, tipo);
    }

    public String getConsecutivo() {
        return dao.getConsecutivo(c.getCon(), "tblventa", "nrofactura", 10);
    }

    public List<Venta_detalle> ListadoVenta_detalle() {
        return dao.ListadoVenta_detalle(c.getCon());
        //una vez programado pasamos al servlet

    }  //fin lista de datos

    public Venta_detalle getVenta_detalle(String nrofactura) {
        return dao.getVenta_detalle(c.getCon(), nrofactura);
        //una vez programado pasamos al servlet al buscar

    }

    public void InsertarVentaDetalle(Venta_detalle hijod) throws Exception {
       
        String mensajeError = "";
        String nrofactura = hijod.getNrofactura();
        String codprod = hijod.getCodprod();
        String cantidad = hijod.getCantidad();
        String valor = hijod.getValor();
        String iva = hijod.getIva();

        if ("".equals(nrofactura) || null == nrofactura) {
            mensajeError += "<br>Ingrese el No.Factura";
        }//fin FACTURA

        if ("".equals(codprod) || null == codprod) {
            mensajeError += "<br>Ingrese el Codigo del Producto";
        }//fin COD

        if ("".equals(cantidad) || null == cantidad) {
            mensajeError += "<br>Ingrese la cantidad";
        }//fin CANTIDAD

        if ("".equals(valor) || null == valor) {
            mensajeError += "<br>Ingrese el valor";
        }//fin VALOR

        if ("".equals(iva) || null == iva) {
            mensajeError += "<br>Ingrese el Iva";
        }//fin IVA


        mensajeError = dao.getInsertarVenta_detalle(c.getCon(), nrofactura, codprod, cantidad, valor, iva);
      if(!"".equals(mensajeError)){
     throw new Exception(mensajeError);
    }// fin si no hay ningun error
    
    
    }
    
    
    
    
}
