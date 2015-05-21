/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sispildora.utilidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades{
SimpleDateFormat formato = new  SimpleDateFormat("dd/MM/yyyy"); 


public static String getFecha()
{
   SimpleDateFormat formato = new  SimpleDateFormat("dd/MM/yyyy");
   String Fecha = formato.format(new Date());
   return Fecha;
}
public static void main(String args[]){
    Utilidades t = new   Utilidades();
System.out.println(t.getFecha());

}
}
