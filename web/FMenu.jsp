

<%@page import="sispildora.entidades.Usuario"%>
<%@page import="sispildora.entidades.Motos"%>

<%
    Usuario entUsuario = (Usuario) session.getAttribute("usuario");
    String user = entUsuario.getUsuario();
    String nombre = entUsuario.getNombre();
    String perfil = entUsuario.getPerfil();
    String estado = entUsuario.getEstado();
    String mail = entUsuario.getMail();
%>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css"> 
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> </link>


<div id='cssmenu'>
    <ul>

        <% if (!"0".equals(user)) {%>      

        <% if (!"Inactivo".equals(estado)) {%>      
        <% if ("Admin".equals(perfil)) {%>  
        
        <li><a href="./UsuarioServlet?action=mostrar" title="Usuarios"><img src="imagenes/16x16/approve_user.png">Administración de Usuarios</a></li>
        
        <li><a href="./MotosServlet?action=mostrar" title="Usuarios"><img src="imagenes/16x16/security_warning.png">Admininistración de Motos</a> </li>
        
        <li><a href="./ServicioServlet?action=mostrar" title=""><img src="imagenes/16x16/add_notes.png">Administración de Servicios</a> </li>
        
        <li><a href="./ClientesServlet?action=mostrar" title=""><img src="imagenes/16x16/use.png">Clientes</a> </li>
        
        <li><a href="./EmpleadoServlet?action=mostrar" title=""><img src="imagenes/16x16/add.png">Empleados</a> </li>
        
        <li class='active has-sub'><a href='#'><span><img src="imagenes/16x16/tag.png">Servicios</span></a>
            <ul>
                <li><a href="./VentaServlet?action=init&txtusuario=<%=user%>" title=""><img src="imagenes/16x16/shopping_cart.png">Ventas</a> </li>

            </ul>
        </li>

       
        <%}%>
        <% if ("Cliente".equals(perfil)) {%>      
        <li><a href="FProductos.jsp" title="">Productos</a> </li>
        <li><a href="Construccion.jsp" title="">Informacion</a> </li>
        <li><a href="Construccion.jsp" title="">Historial</a> </li>
        <li class='active has-sub'><a href='#'><span>Servicios</span></a>
            <ul>
                <li><a href="./VentaServlet?action=init&txtusuario=<%=user%>" title="">Ventas</a> </li>

            </ul>
        </li>

        <%}%>


        <li> <a href="./UsuarioServlet?action=salir" title="Cerrar sesion"><img src="imagenes/16x16/delete_user.png">Cerrar Sesion</a> </li>
        <li>    <%=nombre%></li> 
            <%} else {%>
        <tr><img src="imagenes/respuesta.png"></tr>
        <%}%>
        <%} else {%>
        <tr><td>Error al Ingresar al sistema..</td></tr>
        <%}%>
    </ul>

</div>

</body>
<html>



