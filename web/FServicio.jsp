<%-- 
    Document   : Servicios
    Created on : 5/08/2014, 12:02:15 PM
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="sispildora.entidades.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String cod_servicio = request.getParameter("txtcod_servicio");
    String cod_producto = request.getParameter("txtcod_producto");
    String placa = request.getParameter("txtplaca");
    String fecha = request.getParameter("txtfecha");
    String valor = request.getParameter("txtvalor");
    
String men =(String) request.getAttribute("mensajes");
String dat =(String) request.getAttribute("datos");
List<Servicio>LU=(List<Servicio>) request.getAttribute("listado")!=null?
        (List<Servicio>) request.getAttribute("listado"):null;
Servicio ser=(Servicio) request.getAttribute("datousuario") !=null?
        (Servicio) request.getAttribute("datousuario"):null;
//los datos estan cargado en usu(objeto) de tipo Usuario
//cargamos los datos en las variables
                if(ser!=null){
                cod_servicio= ser.getCod_servicio();
                cod_producto=ser.getCod_producto();
                placa= ser.getPlaca();
                fecha= ser.getFecha();
                valor= ser.getValor();
                
}//fin si
%>


        <script type="text/javascript" src="js/validar.js"></script> 
        <script type="text/javascript" src="js/validarServicio.js"></script> 
  
        <div id=" " style="position: absolute; width: 480px;  z-index: 1; left: 300px; top: 68px"> 
            <form name="xForm" method="POST" id="" action="./ServicioServlet" >  
                <p  id="titulo"><h4>Administración de Servicios</h4>

                </p>
                
                <table class="table table-striped">
                    <tr>
                        <td>Cod_servicio</td>
                        <td><input type="text" class="texto" name="txtusuario" value="" onkeypress="return numeros (event);"></td>
                        
                        <td>Cod_producto</td>
                        <td><input type="text" class="texto" name="txtusuario" value="" onkeypress="return numeros (event);"></td>
                        
                        <tr>
                        <td>Placa</td>
                        <td><input type="text" class="texto" name="txtusuario" value="" onkeypress="return numeros (event);"></td>
                        
                        
                        <td>Fecha</td>

                        </td>

                    </tr>  
                    <tr>
                        <td> Valor</td>
                        <td><input type="text" class ="texto" name="txtclave" value="" onkeypress="return numeros(event);"></td>
   
                    </tr>


                </table>      
               

                <jsp:include page="FBotones.jsp" flush="true"/>
                
              <br>Datos enviados  <%=dat%>
              <br>Mensaje recibido  <%=men%>
              <%if(LU!= null ){%>
              <table>
                  <tr>
                      <td>cod_servicio</td>
                      <td>Cod_producto</td>
                      <td>placa</td>
                      <td>fecha</td>
                      <td>valor</td>
                 </tr>
                  <!--Recorrer para cargar datos-->
                  <%for(Servicio se:LU){%>
                  <tr>
                      <td><%=se.getCod_servicio() %></td>
                      <td><%=se.getCod_producto() %></td>
                      <td><%=se.getPlaca()%></td>
                      <td><%=se.getFecha() %></td>
                      <td><%=se.getValor() %></td>
                      
                  </tr>
                  <%}%>
                  
              </table>
              <%}%>


            </form>
                 
        </div> 
    
   
    
