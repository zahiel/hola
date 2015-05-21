/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import sispildora.persistencia.SQLHelpers;



public class Conexion {
    Connection Con, con1;
    public Conexion(){} //constructor de la clase
    static{
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    
    }
    catch(ClassNotFoundException e1){
    System.out.println("ClassNotFoundException"+e1.getMessage());
    }
    catch(InstantiationException e2){
    System.out.println("InstantiationException"+e2.getMessage());
    
    }
    catch(IllegalAccessException e3){
    System.out.println("IllegalAccessException"+e3.getMessage());
    }
    catch(Exception e){
    System.out.println("Exception"+e.getMessage());
    }
    
    }//fin static
    public Connection getCon() {
      ConexionDB();
        return Con;
    }

    public void setCon(Connection Con) {
        this.Con = Con;
    }
    
  
    
    public void ConexionDB(){
    String host="localhost";
    String puerto="1521";
    String SID="xe";
    //String user="administrador";
    //String password="123";
    String user="administrador";
    String password="123";
    
    
    try{
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
   setCon(DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+puerto+":"+SID, user, password)); 
        
        
    }
    catch(SQLException e4){
    System.out.println("SQLException"+ e4.getMessage());
    
    }
    
    catch(Exception e){
    System.out.println("Exception"+ e.getMessage()); 
    }
//    
    }//metodo vacio sin parametros

public static void main (String param[]){
Conexion c= new Conexion();
try{
    ResultSet r = c.getCon().prepareStatement(SQLHelpers.getProducto("0000000020")).executeQuery();
    if (r.next()) {
System.out.print("Usuario"+r.getString(3));

while (r.next()) {

System.out.print("Usuario"+r.getString(3));

}//fin mientras


}else{
System.out.print("¡..No hay datos..!");
}//fin si    
    
    
}catch(Exception e){
System.out.print("¡Error:"+e.getMessage()+ "Causa:"+e.getCause());

}//fin catch 



    }//fin main
   
    
    
}//fin conexion
