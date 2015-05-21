
<%@page import="java.util.List"%>
<%@page import="sispildora.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    String nombre = request.getParameter("txtnombre");
    String clave = request.getParameter("txtclave");
    String Cargo = request.getParameter("txtCargo");

    String men = (String) request.getAttribute("mensajes");
    String dat = (String) request.getAttribute("datos");

    List<Empleado> LE = (List<Empleado>) request.getAttribute("listado") != null
            ? (List<Empleado>) request.getAttribute("listado") : null;
    Empleado emp = (Empleado) request.getAttribute("datoempleado") != null
            ? (Empleado) request.getAttribute("datoempleado") : null;



    if (emp != null) {
        nombre = emp.getNombre();
        clave = emp.getClave();
        Cargo = emp.getCargo();

    }//fin si
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="css/styles.css">
        <script type="text/javascript" src="js/validar.js"></script> 
        <script type="text/javascript" src="js/validarUsuarioo.js"></script> 
        
    </head>
    
    <body >
        <div id=" " style="position: absolute; width: 480px;  z-index: 1; left: 300px;      top: 68px"> 
            <form name="xForm" method="POST" id="" action="./EmpleadoServlet" >  
                <p  id="titulo"><h4>Administración de Empleados</h4>
                
                <table class="table table-striped">
                    <tr>      
                        <td>Nombre</td>
                        <td><input type="text"  name="txtnombre" class="texto" value="<%=nombre != null ? nombre : ""%>" onkeypress="return soloLetras(event);"></td>
                    </tr>  
                    <tr>
                        <td>Clave</td>
                        <td><input type="text" class ="texto" name="txtclave" value="<%=clave != null ? clave : ""%>" onkeypress="return numeros(event);"></td>
                    </tr>     
                    <tr>
                        <td>Cargo</td>
                        <td><select  name="txtCargo" class="texto">
                                <option value="">*Seleccione*</option>
                                <option value="Electrico"<%if ("Electrico".equals(Cargo)) {%>selected<%}%>>Electrico</option>
                                <option value="Mecanico"<%if ("Mecanico".equals(Cargo)) {%>selected<%}%>>Mecanico</option>
                                <option value="Pintor"<%if ("Pintor".equals(Cargo)) {%>selected<%}%>>Pintor</option>
                                <option value="Vendedor"<%if ("vendedor".equals(Cargo)) {%>selected<%}%>>Vendedor</option>
                            </select>
                        </td>

                    </tr>     
                </table>      


                <jsp:include page="FBotones.jsp" flush="true"/>
                
                
                <br>Datos enviados  <%=dat%>
                <br>Mensaje recibido  <%=men%>
                <%if (LE != null) {%>
                <table class="table table-hover">
                    <tr>

                        <td>Nombre</td>
                        <td>Clave</td>
                        <td>Cargo</td>

                    </tr>

                    <%for (Empleado us : LE) {%>
                    <tr>

                        <td><%=us.getNombre()%></td>
                        <td><%=us.getClave()%></td>
                        <td><%=us.getCargo()%></td>

                    </tr>
                    <%}%>

                </table>
                <%}%>


            </form>

        </div> 


    </body>
</html>