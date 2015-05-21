

package sispildora.entidades;

public class Venta {
    
 private String nrofactura,idecliente,usuario,fecha,subtotal,iva,tipo;

    public Venta(String nrofactura, String idecliente, String usuario, String fecha, String subtotal, String iva, String tipo) {
        
        this.nrofactura = nrofactura;
        this.idecliente = idecliente;
        this.usuario = usuario;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.tipo = tipo;
    }

    
    public Venta() {
    }

    
    public String getNrofactura() {
        return nrofactura;
    }

    
    public String getIdecliente() {
        return idecliente;
    }

    
    public String getUsuario() {
        return usuario;
    }

    
    public String getFecha() {
        return fecha;
    }

    
    public String getSubtotal() {
        return subtotal;
    }

    
    public String getIva() {
        return iva;
    }

    
    public String getTipo() {
        return tipo;
    }

    
    public void setNrofactura(String nrofactura) {
        this.nrofactura = nrofactura;
    }

    
    public void setIdecliente(String idecliente) {
        this.idecliente = idecliente;
    }

    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    
    public void setIva(String iva) {
        this.iva = iva;
    }

    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
 
}
