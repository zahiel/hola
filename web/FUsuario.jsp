 <%-- 
    Document   : FUsuarioo
    Created on : 15/05/2014, 11:38:10 AM
    Author     : Usuario
--%>

<%@page import="java.util.List"%>
<%@page import="sispildora.entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
    String user = request.getParameter("txtusuario");
    String nombre = request.getParameter("txtnombre");
    String clave = request.getParameter("txtclave");
    String perfil = request.getParameter("cboperfil");
    String estado = request.getParameter("cboestado");
    String mail = request.getParameter("txtmail");
    
String men =(String) request.getAttribute("mensajes");
String dat =(String) request.getAttribute("datos");
List<Usuario>LU=(List<Usuario>) request.getAttribute("listado")!=null?
        (List<Usuario>) request.getAttribute("listado"):null;
Usuario usu=(Usuario) request.getAttribute("datousuario") !=null?
        (Usuario) request.getAttribute("datousuario"):null;
//los datos estan cargado en usu(objeto) de tipo Usuario
//cargamos los datos en las variables
                if(usu!=null){
                user= usu.getUsuario();
                nombre= usu.getNombre();
                clave= usu.getClave();
                perfil= usu.getPerfil();
                estado= usu.getEstado();
                mail= usu.getMail();
}//fin si
                
                String ed=(String)request.getAttribute("edicion")!=null?
                        (String)request.getAttribute("edicion"):"";
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Motos Pildora</title>
         <link rel="stylesheet" href="css/styles.css">
         
        <script type="text/javascript" src="js/validar.js"></script> 
		 <script type="text/javascript" src="js/validarUsuario.js"></script> 
    </head>
    <body >
        <div id=" " style="position: absolute; width: 480px;  z-index: 1; left: 300px;      top: 68px"> 
            <form name="xForm" method="POST" id="" action="./UsuarioServlet" >  
                <p  id="titulo"><h4>Administración de Usuarios</h4>

                </p>
                 <table class="table table-striped">
                    
                    
                    <tr>
                        <td>Usuario*</td>
                        <td><input type="text" class="texto" name="txtusuario" <%=ed%> value="<%=user!=null?user:""%>" onkeypress="return soloLetras(event);"></td>
                        <td>Nombre*</td>
                        <td><input type="text"  name="txtnombre" class="texto" value="<%=nombre!=null?nombre:""%>" onkeypress="return soloLetras(event);"></td>
                    </tr>  
                    <tr>
                        <td>Clave*</td>
                        <td><input type="password" class ="texto" name="txtclave" value="<%=clave!=null?clave:""%>" onkeypress="return numeros(event);"></td>
                        
                        <td>Correo*</td>
                        <td><input type="text" class="texto" name="txtmail" <%=ed%> value="<%=mail!=null?mail:""%>" ></td>
                        
                    </tr>     

                    <tr>
                        <td>Perfil*</td>
                        <td><select  name="cboperfil" class="texto">
                                <option value="">-Seleccione-</option>
                                <option value="Admin"<%if("Admin".equals(perfil)){%>selected<%}%> >Admin</option>
                                <option value="Cliente"<%if("Cliente".equals(perfil)){%>selected<%}%>  >Cliente</option>
                                <option value="Otro"<%if("Otro".equals(perfil)){%>selected<%}%> >Otro</option>     
                            </select>
                        </td>
                        <td>Estado*</td>
                        <td><select  name="cboestado" class="texto">
                                <option value="">-Seleccione-</option>
                                <option value="Activo"<%if("Activo".equals(estado)){%>selected<%}%>>Activo</option>
                                <option value="Inactivo"<%if("Inactivo".equals(estado)){%>selected<%}%>>Inactivo</option>

                            </select>
                        </td>
                    </tr>     


 
                </table>      
               
              

                <jsp:include page="FBotones.jsp" flush="true"/>
                
                
              <br>Datos enviados  <%=dat%>
              <br>Mensaje recibido  <%=men%>
              <%if(LU!= null ){%>
              <table class="table table-hover">
                  <tr>
                      <td>Usuario</td>
                      <td>Nombre</td>
                      <td>Perfil</td>
                      <td>Estado</td>
                      <td>Mail</td>
                      
                  </tr>
                  <!--Recorrer para cargar datos-->
                  <%for(Usuario us:LU){%>
                  <tr>
                      <td><%=us.getUsuario() %></td>
                      <td><%=us.getNombre() %></td>
                      <td><%=us.getPerfil() %></td>
                      <td><%=us.getEstado() %></td>
                      <td><%=us.getMail() %></td>
                      <td><a href="./UsuarioServlet?action=buscar&txtusuario=<%=us.getUsuario() %>"><img src="imagenes/24x24/busqueda.png"></a></td>
                      
                  </tr>
                  <%}%>
                  
              </table>
              <%}%>


            </form>
      
       
        </div> 
    
                      
    </body>
</html>