
package sispildora.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sispildora.entidades.Clientes;
import sispildora.entidades.Empleado;
import sispildora.entidades.Usuario;
import sispildora.entidades.Motos;
import sispildora.entidades.Sede;
import sispildora.entidades.Servicio;
import sispildora.entidades.Producto;
import sispildora.entidades.Venta;
import sispildora.entidades.Venta_detalle;



    public class Daos {
    //copiaos ests metodo
    
    public List<Usuario>ListadoUsuarios(Connection con){
    List<Usuario> resultado =new ArrayList<Usuario>();
    try{
        PreparedStatement p=  con.prepareStatement(SQLHelpers.getUsuarios());
    ResultSet r=p.executeQuery();
    while(r.next()){
    Usuario u= new Usuario();
    u.setUsuario(r.getString(1));
    u.setNombre(r.getString(2));
    u.setClave(r.getString(3));
    u.setPerfil(r.getString(4));
    u.setEstado(r.getString(5));
    u.setMail(r.getString(6));
    
    resultado.add(u);
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    
    return resultado;
    
    
    
    }//fin metodo 
    
    
    
    public Usuario getUsuario (Connection con,String user){
    Usuario u=new Usuario();
    try{
    PreparedStatement p=  
             con.prepareStatement(SQLHelpers.getUsuarios(user));
    ResultSet r=p.executeQuery();
    while(r.next()){
    u.setUsuario(r.getString(1));
    u.setNombre(r.getString("nombre"));
    u.setClave(r.getString(3));
    u.setPerfil(r.getString(4));
    u.setEstado(r.getString(5));
    u.setMail(r.getString(6));
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return u;
}//fin metodo
    
    
    
    public Usuario getUsuarioMail (Connection con,String mail){
    Usuario u=new Usuario();
    try{
    PreparedStatement p=  
             con.prepareStatement(SQLHelpers.getMailUsuarios(mail));
    ResultSet r=p.executeQuery();
    while(r.next()){
    u.setUsuario(r.getString(1));
    u.setNombre(r.getString("nombre"));
    u.setClave(r.getString(3));
    u.setPerfil(r.getString(4));
    u.setEstado(r.getString(5));
    u.setMail(r.getString(6));
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return u;
}//fin metodo
    
    
    
    public String getInsertarUsuario(
           Connection con,
           String user, 
           String nombre,
           String clave,
           String perfil,
           String estado, 
           String mail ){
    String respuesta="";
    try{
    PreparedStatement p = con.prepareStatement(SQLHelpers.getInsertarUsuario());
    //(?,?,?,?,?);
    p.setString(1, user);
    p.setString(2, nombre);
    p.setString(3, clave);
    p.setString(4, perfil);
    p.setString(5, estado);
    p.setString(6, mail);
    //luego ejecutamos la accion
    p.execute();//este metodo no retorna filas 
    //a diferencia del metodo executeQuery{}
    if(p.getUpdateCount()>0){
    respuesta="Usuario Agregado";
    }else{
    respuesta="Error, usuario no agregado";
    }//fin si

    }catch(Exception e){
    respuesta+="Error:"+ e.getMessage()+ "Causa:"+ e.getCause();
    }finally{try{con.close();}catch(Exception e1){}}//fin finally
    //con.close(); permite cerrar la conexion a la bd
    return respuesta;
    
    }//fin metodo ----regresamos a la capa de negocio UsuarioN
    
   
    
    public String getActualizarUsuario(
           Connection con,
           String user, 
           String nombre,
           String clave,
           String perfil,
           String estado,
           String mail ){
    String respuesta="";
    try{
    PreparedStatement p = con.prepareStatement(SQLHelpers.getActualizarUsuario());
    //(?,?,?,?,?);
    
    p.setString(6, user); 
    p.setString(1, nombre);
    p.setString(2, clave);
    p.setString(3, perfil);
    p.setString(4, estado);
    p.setString(5, mail);
    
    p.execute(); 
    
    if(p.getUpdateCount()>0){
    respuesta="Usuario Actualizado";
    }else{
    respuesta="Error, usuario no actualizado";
    }//fin si

    }catch(Exception e){
    respuesta+="Error :"+ e.getMessage()+ "Causa:"+ e.getCause();
    }finally{try{con.close();}catch(Exception e1){}}//fin finally
    //con.close(); permite cerrar la conexion a la bd
    return respuesta;
    
    }//fin metodo ----regresamos a la capa de negocio UsuarioN
    

    
     public boolean getVerSiExisteUsuario(Connection con, String user) {
            boolean u = false;
            try {
                PreparedStatement p =
                        con.prepareStatement(SQLHelpers.getUsuarios(user));
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    u = true;

                }//fin mientras
            }//try
            catch (Exception e1) {
            } finally {
            }//fin finally
            try {
                con.close();
            }//fin control cerrar conexion
            catch (Exception clo) {
            }

            //fin finally

            return u;
        }//fin metodo

        
        
    public boolean getVerSiExisteMail (Connection con,String mail){
    boolean u= false;
    try{
    PreparedStatement p=  
             con.prepareStatement(SQLHelpers.getMailUsuarios(mail));
    ResultSet r=p.executeQuery();
    while(r.next()){
    u=true;
    
    }//fin mientras
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return u;
}//fin metodo //si existe mail

                

    public Usuario getValidarIngreso(Connection con,String user,String ca ){
    Usuario u = new Usuario();
    u.setUsuario("0");
    try{
    PreparedStatement p= 
    con.prepareStatement(SQLHelpers.getValidarIngreso(user,ca));
    ResultSet r=p.executeQuery();
    while(r.next()){
    u.setUsuario(r.getString(1));
    u.setNombre(r.getString(2));
    u.setClave(r.getString(3));
    u.setEstado(r.getString(5));
    u.setPerfil(r.getString(4));
    u.setMail(r.getString(6));

    }// fin mientras 
    }// fin try
    catch(Exception e1){}
    finally{
    try{con.close();}// fin control cerrar conexion    
    catch(Exception clo){}

    }// fin finally

    return u;   
    }// fin métodos   


    
    public List<Motos>ListadoMotos(Connection con1,String campo, String dato){
    List<Motos> resultado =new ArrayList<Motos>();
    try{
        PreparedStatement p=  con1.prepareStatement(SQLHelpers.getMotos(campo,dato));
    ResultSet r=p.executeQuery();
    while(r.next()){
    Motos m= new Motos();
    m.setPlaca(r.getString(1));
    m.setCod_Cliente(r.getString(2));
    m.setMarca(r.getString(3));
    m.setColor(r.getString(4));
    m.setKilometraje(r.getString(5));
    m.setModelo(r.getString(6));
    
    resultado.add(m);
    
    }//fin mientras
            
    }//try
    
    catch(SQLException e2){}
    finally{}//fin finally
    try{con1.close();}//fin control cerrar conexion
    catch(SQLException clo1){}
    
    
    return resultado;
    
    
    
    }//fin metodo 


    
    public Motos getMotos (Connection con,String campo,String dato){
    Motos m=new Motos();
    try{
    // Recuerda que  son motos y no usuarios     
    // PreparedStatement p=  con.prepareStatement(SQLHelpers.getUsuarios(mot));     
    PreparedStatement p=  con.prepareStatement(SQLHelpers.getMotos(campo,dato));
    ResultSet r=p.executeQuery();
    while(r.next()){
    m.setPlaca(r.getString(1));
    m.setCod_Cliente(r.getString(2));
    m.setMarca(r.getString(3));
    m.setColor(r.getString(4));
    m.setKilometraje(r.getString(5));
    m.setModelo(r.getString(6));
    }//fin mientras
            
    }//try
    
    catch(SQLException e2){
    
    }
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(SQLException clo1){}
    
    //fin finally
    
    return m;
    }//fin metodo

    
    
    public boolean siExiteMoto (Connection con,String mot){
 boolean m=false;
  try{
  PreparedStatement p=  con.prepareStatement(SQLHelpers.getMotos("placa",mot));
 ResultSet r=p.executeQuery();
 while(r.next()){
  m=true;
  }//fin mientras
    }//try
    
    catch(SQLException e2){
    }
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(SQLException clo1){}
  
    
    return m;
}//fin si existe motos


    
    public String getInsertarMotos(
       Connection con1,
        String placa, 
        String cod_cliente,
        String marca,
        String color,
        String kilometraje,
        String modelo){
String respuesta="";
try{
    // rECUERDA ES MOTO
//PreparedStatement p = con1.prepareStatement(SQLHelpers.getInsertarUsuario());
PreparedStatement p = con1.prepareStatement(SQLHelpers.getInsertarMotos());

//(?,?,?,?,?);
p.setString(1, placa);
p.setString(2, cod_cliente);
p.setString(3, marca);
p.setString(4, color);
p.setString(5, kilometraje);
p.setString(6, modelo);
//luego ejecutamos la accion
p.execute();//este metodo no retorna filas 
//a diferencia del metodo executeQuery{}
if(p.getUpdateCount()>0){
  respuesta="Informacion Agregada";
}else{
  respuesta="Error, informacion no agregada";
}//fin si

}catch(Exception e){
respuesta+=":"+ e.getMessage()+ "Causa:"+ e.getCause();
}finally{try{con1.close();}catch(Exception e1){}}//fin finally
//con.close(); permite cerrar la conexion a la bd
return respuesta;
}//fin metodo ----regresamos a la capa de negocio MotosN

        
 
    public List<Empleado> ListadoEmpleado(Connection con) {
        List<Empleado> resultado = new ArrayList<Empleado>();
        try {
            PreparedStatement p = con.prepareStatement(SQLHelpers.getEmpleado());
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Empleado e = new Empleado();
                e.setNombre(r.getString(1));
                e.setClave(r.getString(2));
                e.setCargo(r.getString(3));

    
    resultado.add(e);
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    
    return resultado;
    
    
    
    }//fin metodo 
    
    
    
    public Empleado getEmpleado(Connection con,String emp){
 Empleado e=new Empleado();
  try{
 PreparedStatement p=  con.prepareStatement(SQLHelpers.getEmpleado(emp));
 ResultSet r=p.executeQuery();
 while(r.next()){
    e.setNombre(r.getString(1));
    e.setClave(r.getString(2));
    e.setCargo(r.getString(3));
  }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return e;
}//fin metodo
    
    
    
    public String getInsertarEmpleado(
        Connection con, 
        String doc_empleado,
        String nombre,
        String clave,
        String cargo ){
String respuesta="";
try{
PreparedStatement p = con.prepareStatement(SQLHelpers.getInsertarUsuario());
//(?,?,?,?,?);
p.setString(1, doc_empleado);
p.setString(2, nombre);
p.setString(3, clave);
p.setString(4, cargo);

//luego ejecutamos la accion
p.execute();//este metodo no retorna filas 
//a diferencia del metodo executeQuery{}
if(p.getUpdateCount()>0){
  respuesta="Empleado Agregado";
}else{
  respuesta="Error, Empleado no agregado";
}//fin si

}catch(Exception e){
respuesta+=":"+ e.getMessage()+ "Causa:"+ e.getCause();
}finally{try{con.close();}catch(Exception e1){}}//fin finally
//con.close(); permite cerrar la conexion a la bd
return respuesta;
}//fin metodo

    

    public List<Servicio> ListadoServicio(Connection con3) {
        List<Servicio> resultado = new ArrayList<Servicio>();
        try {
            PreparedStatement p = con3.prepareStatement(SQLHelpers.getServicio());
            ResultSet r = p.executeQuery();
            while (r.next()) {
                Servicio s = new Servicio();
                s.setCod_servicio(r.getString(1));
                s.setCod_producto(r.getString(2));
                s.setPlaca(r.getString(3));
                s.setFecha(r.getString(4));
                s.setValor(r.getString(5));


    resultado.add(s);
    
    }//fin mientras
            
    }//try
    
    catch(SQLException e2){}
    finally{}//fin finally
    try{con3.close();}//fin control cerrar conexion
    catch(SQLException clo1){}
    
    
    return resultado;
    
    
    
    }//fin metodo 
  
  
    
    public Servicio getServicio (Connection con3,String se){
 Servicio s=new Servicio();
  try{
 PreparedStatement p=  con3.prepareStatement(SQLHelpers.getUsuarios(se));
 ResultSet r=p.executeQuery();
 while(r.next()){
    s.setCod_servicio(r.getString(1));
    s.setCod_producto(r.getString(2));
    s.setPlaca(r.getString(3));
    s.setFecha(r.getString(4));
    s.setValor(r.getString(5));
    
  }//fin mientras
            
    }//try
    
    catch(SQLException e2){}
    finally{}//fin finally
    try{con3.close();}//fin control cerrar conexion
    catch(SQLException clo1){}
    
    //fin finally
    
    return s;
}//fin metodo

    
    
    public List<Clientes>ListadoClientes(Connection con){
    List<Clientes> resultado =new ArrayList<Clientes>();
    try{
        PreparedStatement p=  con.prepareStatement(SQLHelpers.getClientes());
    ResultSet r=p.executeQuery();
    while(r.next()){
    Clientes c= new Clientes();
    c.setCod_cliente(r.getString(1));
    c.setNombre(r.getString(2));
    c.setApellido(r.getString(3));
    c.setTelefono(r.getString(4));
    c.setDireccion(r.getString(5));
    c.setEmail(r.getString(6));

    resultado.add(c);
    
    }//fin mientras
            
    }//try
    
    catch(SQLException e2){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(SQLException clo1){}
    
    
    return resultado;
    
    
    
    }//fin metodo 
   
    
    
    public Clientes getClientes (Connection con, String Cli){
 Clientes c=new Clientes();
  try{
 PreparedStatement p=  con.prepareStatement(SQLHelpers.getUsuarios(Cli));
 ResultSet r=p.executeQuery();
 while(r.next()){
    c.setCod_cliente(r.getString(1));
    c.setNombre(r.getString(2));
    c.setApellido(r.getString(3));
    c.setTelefono(r.getString(4));
    c.setDireccion(r.getString(5));
    c.setEmail(r.getString(6));

  }//fin mientras
            
    }//try
    
    catch(SQLException e2){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(SQLException clo1){}
    
    //fin finally
    
    return c;
}
 
    
    
    public List<Sede>ListadoSedes(Connection con,String campo,String valor){
    List<Sede> resultado =new ArrayList<Sede>();
    try{
        PreparedStatement p=  con.prepareStatement(SQLHelpers.getSede(campo, valor));
    ResultSet r=p.executeQuery();
    while(r.next()){
    Sede u= new Sede();
    u.setConsc(r.getString(1));
    u.setNombre(r.getString(2));
    u.setEstado(r.getString(3));
    u.setUsuario_creador(r.getString(4));
    u.setFecha_creacion(r.getString(5));
    
    resultado.add(u);
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    
    return resultado;
    
    
    
    }//fin metodo
    
    
    
    public String getInsertarSede(
           Connection con,
           String consc, 
           String nombre,
           String estado,
           String usuario_creador,
           String fecha_creacion){
        
    String respuesta="";
    try{
    PreparedStatement p = con.prepareStatement(SQLHelpers.getInsertarSede());
    //(?,?,?,?,?);
    p.setString(1, consc);
    p.setString(2, nombre);
    p.setString(3, estado);
    p.setString(4, usuario_creador);
    p.setString(5, fecha_creacion);
    //luego ejecutamos la accion
    p.execute();//este metodo no retorna filas 
    //a diferencia del metodo executeQuery{}
    if(p.getUpdateCount()>0){
    respuesta="Sede Agregado";
    }else{
    respuesta="Error, Sede no agregado";
    }//fin si

    }catch(Exception e){
    respuesta+="Error:"+ e.getMessage()+ "Causa:"+ e.getCause();
    }finally{try{con.close();}catch(Exception e1){}}//fin finally
    //con.close(); permite cerrar la conexion a la bd
    return respuesta;
    
    }//fin metodo 
    
    
    
    public String getModificarSede(
           Connection con,
           String consc, 
           String nombre,
           String estado){
        
    String respuesta="";
    try{
    PreparedStatement p = con.prepareStatement(SQLHelpers.getActualizarSede());
    //set nombre=1?,estado=2? where consc=3?
    p.setString(1, nombre);
    p.setString(2, estado);
    p.setString(3, consc);
     //luego ejecutamos la accion
    p.execute();//este metodo no retorna filas 
    //a diferencia del metodo executeQuery{}
    if(p.getUpdateCount()>0){
    respuesta="Sede Modificada";
    }else{
    respuesta="Error, Sede no Modificada";
    }//fin si

    }catch(Exception e){
    respuesta+="Error:"+ e.getMessage()+ "Causa:"+ e.getCause();
    }finally{try{con.close();}catch(Exception e1){}}//fin finally
    //con.close(); permite cerrar la conexion a la bd
    return respuesta;
    
    }//fin metodo 
 
    
    
    public Sede getSedes(Connection con, String campo, String valor) {
            Sede u = new Sede();
            try {
                PreparedStatement p = con.prepareStatement(SQLHelpers.getSede(campo, valor));
                ResultSet r = p.executeQuery();
                while (r.next()) {
                    u.setConsc(r.getString(1));
                    u.setNombre(r.getString(2));
                    u.setEstado(r.getString(3));
                    u.setUsuario_creador(r.getString(4));
                    u.setFecha_creacion(r.getString(5));

                   

                }//fin mientras

            }//try
            catch (Exception e1) {
            } finally {
            }//fin finally
            try {
                con.close();
                
                
            }//fin control cerrar conexion
            catch (Exception clo) {
            }


           return u ;



        }//fin metodo<---------------capa de negocio

    
    
    public List<Producto>ListadoProducto(Connection con){
    List<Producto> resultado =new ArrayList<Producto>();
    try{
        PreparedStatement p=  con.prepareStatement(SQLHelpers.getProducto());
    ResultSet r=p.executeQuery();
    while(r.next()){
        
        //codpro, nombre, valor, costo, stock_min, stock_max, estado, tipo
    Producto pd= new Producto();
    pd.setCod_producto(r.getString(1));
    pd.setDescripcion(r.getString(2));
    pd.setValor(r.getString(3));
    pd.setCosto(r.getString(4));
    pd.setStock_min(r.getString(5));
    pd.setStock_max(r.getString(6));
    pd.setEstado(r.getString(7));
    pd.setTipo(r.getString(8));
    
    resultado.add(pd);
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    
    return resultado;
    
    
    
    }//fin metodo 
    

    
    public Producto getProducto (Connection con,String prod){
    Producto pd=new Producto();
    try{
    PreparedStatement p=con.prepareStatement(SQLHelpers.getProducto(prod));
    ResultSet r=p.executeQuery();
    while(r.next()){
    
    pd.setCod_producto(r.getString(1));
    pd.setDescripcion(r.getString(2));
    pd.setValor(r.getString(3));
    pd.setCosto(r.getString(4));
    pd.setStock_min(r.getString(5));
    pd.setStock_max(r.getString(6));
    pd.setEstado(r.getString(7));
    pd.setTipo(r.getString(8));
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return pd;
}//fin metodo
    
    
    
    public String getInsertarProducto(
           Connection con,
           String prod, 
           String cod_producto,
           String estado,
           String descripcion,
           String cantidad,
           String precio_compra){
    String respuesta="";
    try{
    PreparedStatement p = con.prepareStatement(SQLHelpers.getInsertarUsuario());
    //(?,?,?,?,?);
    p.setString(1, prod);
    p.setString(2, cod_producto);
    p.setString(3, estado);
    p.setString(4, descripcion);
    p.setString(5, cantidad);
    p.setString(6, precio_compra);
    //luego ejecutamos la accion
    p.execute();//este metodo no retorna filas 
    //a diferencia del metodo executeQuery{}
    if(p.getUpdateCount()>0){
    respuesta="Producto Agregado";
    }else{
    respuesta="Error, Producto no agregado";
    }//fin si

    }catch(Exception e){
    respuesta+="Error:"+ e.getMessage()+ "Causa:"+ e.getCause();
    }finally{try{con.close();}catch(Exception e1){}}//fin finally
    //con.close(); permite cerrar la conexion a la bd
    return respuesta;
    
    }//fin metodo
    
    
    
    public String getActualizarProducto(
           Connection con,
           String prod, 
           String cod_producto,
           String estado,
           String descripcion,
           String cantidad,
           String precio_compra){
    String respuesta="";
    try{
    PreparedStatement p = con.prepareStatement(SQLHelpers.getActualizarUsuario());
    //(?,?,?,?,?);
    p.setString(1, prod);
    p.setString(2, cod_producto);
    p.setString(3, estado);
    p.setString(4, descripcion);
    p.setString(5, cantidad);
    p.setString(6, precio_compra);
    
    p.execute(); 
    
    if(p.getUpdateCount()>0){
    respuesta="Producto Actualizado";
    }else{
    respuesta="Error, producto no actualizado";
    }//fin si

    }catch(Exception e){
    respuesta+="Error :"+ e.getMessage()+ "Causa:"+ e.getCause();
    }finally{try{con.close();}catch(Exception e1){}}//fin finally
    //con.close(); permite cerrar la conexion a la bd
    return respuesta;
    
    }//fin metodo
    
    
    
    public boolean getVerSiExisteProducto (Connection con,String prod){
    boolean pd= false;
    try{
    PreparedStatement p=  
             con.prepareStatement(SQLHelpers.getUsuarios(prod));
    ResultSet r=p.executeQuery();
    while(r.next()){
    pd=true;
    
    }//fin mientras
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return pd;
}//fin metodo
 
    
    
    public List<Venta>ListadoVenta(Connection con){
    List<Venta> resultado =new ArrayList<Venta>();
    try{
        PreparedStatement p=  con.prepareStatement(SQLHelpers.getVenta());
    ResultSet r=p.executeQuery();
    while(r.next()){
    Venta v= new Venta();
    v.setNrofactura(r.getString(1));
    v.setIdecliente(r.getString(2));
    v.setUsuario(r.getString(3));
    v.setFecha(r.getString(4));
    v.setSubtotal(r.getString(5));
    v.setIva(r.getString(6));
    v.setTipo(r.getString(7));
    
    
    resultado.add(v);
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    
    return resultado;
    }//fin metodo
    
    
    
    public Venta getVenta (Connection con,String vent){
    Venta v=new Venta();
    try{
    PreparedStatement p=con.prepareStatement(SQLHelpers.getVenta(vent));
    ResultSet r=p.executeQuery();
    while(r.next()){
    
    v.setNrofactura(r.getString(1));
    v.setIdecliente(r.getString(2));
    v.setUsuario(r.getString(3));
    v.setFecha(r.getString(4));
    v.setSubtotal(r.getString(5));
    v.setIva(r.getString(6));
    v.setTipo(r.getString(7));
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return v;
}//fin metodo
    
    
    
        public String getInsertarVenta(
                Connection con,
                String nrofactura,
                String idecliente,
                String usuario,
                String fecha,
                String subtotal,
                String iva,
                String tipo) {
            String respuesta = "";
            try {
                PreparedStatement p = con.prepareStatement(SQLHelpers.getInsertarVenta());
                p.setString(1, nrofactura);
                p.setString(2, idecliente);
                p.setString(3, usuario);
                p.setString(4, fecha);
                p.setString(5, subtotal);
                p.setString(6, iva);
                p.setString(7, tipo);

                //luego ejecutamos la accion
                p.execute();//este metodo no retorna filas 
                //a diferencia del metodo executeQuery{}
                if (p.getUpdateCount() > 0) {
                    respuesta = "Detalle de Venta Agregado";
                } else {
                    respuesta = "Error, Detalle de Venta no agregado";
                }//fin si

            } catch (Exception e) {
                respuesta += "Error:" + e.getMessage() + "Causa:" + e.getCause();
            } finally {
                try {
                    con.close();
                } catch (Exception e1) {
                }
            }//fin finally
            //con.close(); permite cerrar la conexion a la bd
            return respuesta;

        }//fin metodo ----regresamos a la capa de negocio 
    
    
    
    public List<Venta_detalle>ListadoVenta_detalle(Connection con){
    List<Venta_detalle> resultado =new ArrayList<Venta_detalle>();
    try{
        PreparedStatement p=  con.prepareStatement(SQLHelpers.getVenta_detalle());
    ResultSet r=p.executeQuery();
    while(r.next()){
    Venta_detalle vdl= new Venta_detalle();
    vdl.setNrofactura(r.getString(1));
    vdl.setCodprod(r.getString(2));
    vdl.setNombre(r.getString(3));
    vdl.setCantidad(r.getString(4));
    vdl.setTipo(r.getString(5));
    vdl.setValor(r.getString(6));
    vdl.setIva(r.getString(7));
    vdl.setTotal(r.getString(8));
    
    resultado.add(vdl);
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){
    
    e1.printStackTrace();
    }
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    
    return resultado;
    }//fin metodo
    
    
    
    public Venta_detalle getVenta_detalle (Connection con,String ventdetalle){
    Venta_detalle vdl=new Venta_detalle();
    try{
    PreparedStatement p=con.prepareStatement(SQLHelpers.getVenta_detalle(ventdetalle));
    ResultSet r=p.executeQuery();
    while(r.next()){
    
    vdl.setNrofactura(r.getString(1));
    vdl.setCodprod(r.getString(2));
    vdl.setNombre(r.getString(3));
    vdl.setCantidad(r.getString(4));
    vdl.setTipo(r.getString(5));
    vdl.setValor(r.getString(6));
    vdl.setIva(r.getString(7));
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return vdl;
}//fin metodo
    
    public String getInsertarVenta_detalle(
          Connection con,
          String nrofactura, 
          String codprod, 
          String cantidad, 
          String valor, 
          String iva ){
    String respuesta="";
    try{
    PreparedStatement p = con.prepareStatement(SQLHelpers.getInsertarVenta_detalle());
    p.setString(1, nrofactura);
    p.setString(2, codprod);
    p.setString(3, cantidad);
    p.setString(4, valor);
    p.setString(5, iva);
    
    //luego ejecutamos la accion
    p.execute();//este metodo no retorna filas 
    //a diferencia del metodo executeQuery{}
    if(p.getUpdateCount()>0){
    respuesta="Detalle de Venta Agregado";
    }else{
    respuesta="Error, Detalle de Venta no agregado";
    }//fin si

    }catch(Exception e){
    respuesta+="Error:"+ e.getMessage()+ "Causa:"+ e.getCause();
    e.printStackTrace();
    }finally{try{con.close();}catch(Exception e1){}}//fin finally
    //con.close(); permite cerrar la conexion a la bd
    return respuesta;
    
    }//fin metodo ----regresamos a la capa de negocio 
    
   
    
    public String getConsecutivo(Connection con,String tabla,String campo, int longitud){
        String cs=null;
    try{
    PreparedStatement p=con.prepareStatement(SQLHelpers.getConsecutivo(tabla, campo, longitud));
    ResultSet r=p.executeQuery();
    while(r.next()){
    cs=r.getString(1);
    
    }//fin mientras
            
    }//try
    
    catch(Exception e1){}
    finally{}//fin finally
    try{con.close();}//fin control cerrar conexion
    catch(Exception clo){}
    
    //fin finally
    
    return cs;
    }
}//fin Daos<----------