/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.negocio;
import java.util.List;
import sispildora.entidades.Sede;
import sispildora.persistencia.Daos;
import sispildora.utilidades.Conexion;

public class SedeN {
    Daos dao;
    Conexion c=new Conexion(); 
    public SedeN(){
    dao = new Daos();
}//fin constructor
     
   public List<Sede> listadoSede(String campo, String valor)
   {return dao.ListadoSedes(c.getCon(), campo, valor);
   } 
    
   public Sede getSede(String campo, String valor)
   {return dao.getSedes(c.getCon(), campo, valor);
   }
   
   public void  grabarSede(Sede hijosede)throws Exception{
   String consc= hijosede.getConsc();
   String nombre= hijosede.getNombre();
   String estado= hijosede.getEstado();
   String usuario_creador= hijosede.getUsuario_creador();
   String fecha_creacion= hijosede.getFecha_creacion();
   String mensaje="";
   
   if("".equals(consc)||null==(consc)){
   mensaje="<br>Ingrese consecutivo";
   }
   
   if("".equals(nombre)||null==(nombre)){
   mensaje="<br>Ingrese nombre";
   }
   
   if("".equals(estado)||null==(estado)){
   mensaje="<br>Ingrese estado";
   }
   
   if("".equals(usuario_creador)||null==(usuario_creador)){
   mensaje="<br>Ingrese Usuario";
   }
   
   if("".equals(fecha_creacion)||null==(fecha_creacion)){
   mensaje="<br>Ingrese fecha creación";
   }
   
   //lanzar excepcion
   
   if(!"".equals(mensaje)){
   throw new Exception(mensaje);
   }
   
   mensaje = dao.getInsertarSede(c.getCon(), consc, nombre, estado, usuario_creador, fecha_creacion);
   
   if(!"".equals(mensaje)){
   throw new Exception(mensaje);
   }
   
   }//fin grabar Sede
   
   }//fin clase SedeN
