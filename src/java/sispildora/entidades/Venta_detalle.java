
package sispildora.entidades;


public class Venta_detalle {
    
    private String nrofactura,codprod, nombre, cantidad, tipo, valor, iva, total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
    public Venta_detalle(String nrofactura, String codprod, String cantidad, String valor, String iva){
    
        
        this.nrofactura=nrofactura;
        this.codprod=codprod;
        this.cantidad=cantidad;
        this.valor=valor;
        this.iva=iva;
        
    }
    
    
    public Venta_detalle(){
    }

    
    public String getNrofactura() {
        return nrofactura;
    }

    
    public String getCodprod() {
        return codprod;
    }
    
    
    public String getNombre(){
        return nombre;
    }

    
    public String getCantidad() {
        return cantidad;
    }
    
    
    public String getTipo(){
        return tipo;
    }

    
    public String getValor() {
        return valor;
    }

    
    public String getIva() {
        return iva;
    }

    
    public void setNrofactura(String nrofactura) {
        this.nrofactura = nrofactura;
    }

    
    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }
    
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    
    public void setValor(String valor) {
        this.valor = valor;
    }

    
    public void setIva(String iva) {
        this.iva = iva;
    }
    
}
