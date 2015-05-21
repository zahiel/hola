
package sispildora.persistencia;

public class SQLHelpers {
    static String getVenta;
    
    public static String getUsuarios()
    {
    return "SELECT usuario, nombre, clave, perfil, estado,mail from tblusuario";
    }//fin metodo
    //buscar un dato
    
    public static String getUsuarios(String us)
    {
    return "SELECT usuario, nombre, clave, perfil, estado from tblusuario where usuario= '"+us+"'";
    }//fin metodo buscar un dato
    //Nos vamos para ---> Daos
    
       public static String getMailUsuarios(String mail)
    {
    return "SELECT usuario, nombre, clave, perfil, estado from tblusuario where mail= '"+mail+"'";
    }//fin metodo buscar un mail
    //Nos vamos para ---> Daos
 
    //insertar un dato
    public static String getInsertarUsuario(){
    return "INSERT INTO tblusuario(usuario,nombre,clave,perfil,estado, mail)VALUES(?,?,?,?,?,?)";
    }//fin insertar
    
    public static String getActualizarUsuario(){
    return"UPDATE tblusuario set nombre=?,clave=?,perfil=?,estado=?, mail=? where usuario=? ";
    }//fin actualizar
    
    public static String getBorrrarUsuario(String user){
    return"delete from tblusuario where usuario='"+user+"'";
    }//fin borrar
    //nos amos para ---> Daos
    
    public static String getSede(){
    return"SELECT consc,nombre,estado,usuario_creador,fecha_creacion FROM tblsede";
    }//fin metodo sede
    
     public static String getSede(String campo, String valor){
    return"SELECT consc,nombre,estado,usuario_creador,fecha_creacion FROM tblsede where "+campo+"='"+valor+"' ";
    }//fin metodo sede
    
    public static String getInsertarSede(){
    return"INSERT INTO tblsede( consc,nombre,estado,usuario_creador,fecha_creacion)values(?,?,?,?,?)";
    }//fin metodo sede insertar
     
    public static String getActualizarSede(){
    return"UPDATE tblsede set nombre=?,estado=? where consc=?";
    }//fin metodo sede actualizar
    
    
     
    public static String getValidarIngreso(String us, String ca){
    return "SELECT usuario,nombre,clave "
        + ",perfil,estado, mail from tblusuario"
        + "  where usuario ='"+us+"' and clave ='"+ca+"'";    
    }// fin método validar un dato
     // Nos vamos para ---- > Daos
    
    public static String getMotos()
    {
    return "SELECT placa, cod_cliente, marca, color, kilometraje, modelo from tblmotos";
    }//fin metodo
    
     public static String getInsertarMotos()
    {
    return "insert into tblmotos( placa, cod_cliente, marca, color, kilometraje, modelo) values(?,?,?,?,?,?)";
    }//fin metodo
    
    //buscar un dato
    
    public static String getMotos(String campo,String  dato)
    {
       //se busca por placa no por moto campo no existe
    return "SELECT placa, cod_cliente, marca, color, kilometraje, modelo "
            + " from tblmotos where "+campo+"= '"+ dato+"'";
    }//fin metodo buscar
    //Nos vamos para ---> Daos
    
    public static String getServicio() {
        return "SELECT cod_cliente, venta, tecnica_mecanica, cambio_de_aceite, pintura, modelo from tblmotos";
    }//fin metodo
    //buscar un dato

    public static String getServicio(String se) {
        return "SELECT cod_cliente, venta, tecnica_mecanica, cambio_de_aceite, pintura,  modelo from tblmotos where motos= '" + se + "'";
    }//fin metodo buscar
    //Nos vamos para ---> Daos    
    
    public static String getEmpleado() {
        return "SELECT nombre, clave, cargo from tblEmpleado";
    }//fin metodo
    //buscar un dato

    public static String getEmpleado(String emp) {
        return "SELECT nombre, clave, cargo from tblEmpleados where empleados='" + emp + "'";
    }//fin metodo buscar
    //Nos vamos para----> daos
    
    public static String getClientes() {
        return "SELECT cod_cliente, nombre, apellido, telefono, direccion, email from tblclientes ";
    }//fin metodo
    //buscar un dato

    public static String getClientes(String cl) {
        return "SELECT cod_cliente, nombre, apellido, telefono, direccion, email from tblclientes where clientes='" + cl + "'";
    }//fin metodo
    //buscar un dato
    
    public static String getVenta(){
        return "SELECT nrofactura, idecliente, usuario, fecha, subtotal,iva, tipo from tblventa";
    }
    
    public static String getVenta(String v){
        return "SELECT nrofactura, idecliente, usuario, fecha, subtotal,iva, tipo from tblventa"+ v + "'";
    }
    
    public static String getInsertarVenta(){
        return "INSERT INTO tblventa_detalle (nrofactura,idecliente,usuario,fecha,subtotal,iva,tipo)VALUES(?,?,?,?,?,?,?)";
    }
    
    public static String getVenta_detalle(){
        return "SELECT vd.NROFACTURA,vd.CODPROD,p.NOMBRE, p.TIPO,vd.CANTIDAD,vd.VALOR,vd.IVA,vd.CANTIDAD*vd.VALOR from tblventa_detalle vd, TBLPRODUCTO p where p.CODPRO = vd.CODPROD";
    }
    
    public static String getVenta_detalle(String vd){
        return "SELECT vd.NROFACTURA,vd.CODPROD,p.NOMBRE, p.TIPO,vd.CANTIDAD,vd.VALOR,vd.IVA,vd.CANTIDAD*vd.VALOR from tblventa_detalle vd, TBLPRODUCTO p where p.CODPRO = vd.CODPROD"+vd+"'";
    }
    
    public static String getInsertarVenta_detalle(){
        return "INSERT INTO tblventa_detalle (nrofactura,codprod,  cantidad,  valor, iva)VALUES(?,?,?,?,?)";
    }
    
    public static String getConsecutivo(String tabla,String campo, int longitud){
        return "SELECT Lpad( max( cast( "+campo+" AS varchar("+longitud+") ) ) +1, "+longitud+", '0' )  FROM "+tabla+"";
    }
    
    public static String getProducto(){
        return "SELECT codpro, nombre, valor, costo, stock_min, stock_max, estado, tipo from tblproducto";
    
    }
    
    public static String getProducto(String p){
        return "SELECT codpro, nombre, valor, costo, stock_min, stock_max, estado, tipo from tblproducto  where codpro= '"+p+"'";
    
    }
}//fin de la clase
    


