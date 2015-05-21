/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.entidades;

/**
 *
 * @author PRIVADA MANU
 */
public class Producto {
    
    String cod_producto;
    String descripcion;
    String valor;
    String costo;
    String stock_min;
    String stock_max;
    String estado;
    String tipo;
    
    public Producto(){}

    public Producto(String cod_producto, String descripcion, String valor, String costo, String stock_min, String stock_max, String estado, String tipo) {
        this.cod_producto = cod_producto;
        this.descripcion = descripcion;
        this.valor = valor;
        this.costo = costo;
        this.stock_min = stock_min;
        this.stock_max = stock_max;
        this.estado = estado;
        this.tipo = tipo;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getStock_min() {
        return stock_min;
    }

    public void setStock_min(String stock_min) {
        this.stock_min = stock_min;
    }

    public String getStock_max() {
        return stock_max;
    }

    public void setStock_max(String stock_max) {
        this.stock_max = stock_max;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 
    
    
    
}