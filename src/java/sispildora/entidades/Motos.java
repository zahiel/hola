/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.entidades;

/**
 *
 * @author Usuario
 */
public class Motos {
String placa;
String cod_cliente;
String marca;
String color;
String kilometraje;
String modelo;

public Motos (){}

    public Motos(String placa, String cod_cliente, String marca, String color, String kilometraje, String modelo) {
        this.placa = placa;
        this.cod_cliente = cod_cliente;
        this.marca = marca;
        this.color = color;
        this.kilometraje = kilometraje;
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }
    
     
    public void setPlaca(String placa) {
        this.placa= placa;
    }

    public String getCod_Cliente() {
        return cod_cliente;
    }

    public void setCod_Cliente(String cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(String kilometraje) {
        this.kilometraje = kilometraje;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }    

    



}