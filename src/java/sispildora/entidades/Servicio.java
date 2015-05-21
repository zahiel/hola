
package sispildora.entidades;

/**
 *
 * @author LeidyLondoño
 */
public class Servicio {
    String cod_servicio;
    String cod_producto;
    String placa;
    String fecha;
    String valor;

    public Servicio(String cod_servicio, String cod_producto, String placa, String fecha, String valor) {
        this.cod_servicio = cod_servicio;
        this.cod_producto = cod_producto;
        this.placa = placa;
        this.fecha = fecha;
        this.valor = valor;
    }

    public Servicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public String getCod_servicio() {
        return cod_servicio;
    }

    public void setCod_servicio(String cod_servicio) {
        this.cod_servicio = cod_servicio;
    }

    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    
}
