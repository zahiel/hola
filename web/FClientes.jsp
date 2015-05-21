<%@page import="java.util.List"%>
<%@page import="sispildora.entidades.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String cod_cliente = request.getParameter("txtcod_cliente");
    String documento = request.getParameter("txtdocumento");
    String nombre = request.getParameter("txtnombre");
    String apellido = request.getParameter("txtapellido");
    String telefono = request.getParameter("txttelefono");
    String direccion = request.getParameter("txtdireccion");
    String email = request.getParameter("txtemail");
    String genero = request.getParameter("txtgenero");

    String dat = (String) request.getAttribute("datos");
    String men = (String) request.getAttribute("mensaje");

    List<Clientes> LC = (List<Clientes>) request.getAttribute("listado") != null
            ? (List<Clientes>) request.getAttribute("listado") : null;
    Clientes Cli = (Clientes) request.getAttribute("datocliente") != null
            ? (Clientes) request.getAttribute("datocliente") : null;
//los datos estan cargado en usu(objeto) de tipo Usuario
//cargamos los datos en las variables
    if (Cli != null) {
        documento = Cli.getDocumento();
        nombre = Cli.getNombre();
        apellido = Cli.getApellido();
        telefono = Cli.getTelefono();
        email = Cli.getEmail();
        genero = Cli.getGenero();

    }//fin si
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/styles.css">
<script type="text/javascript" src="js/validar.js"></script> 
<script type="text/javascript" src="js/validarClientes.js"></script> 

<head>

    <title>Clientes</title></head>


</head>
<div id=" " style="position: absolute; width: 480px;  z-index: 1; left: 300px;      top: 68px"> 
    <form name="xForm" method="POST" id="" action="./ClientesServlet" >  
        <p  id="titulo"><h4>Administración de Clientes</h4>

        </p>
        <body>
            <Form name="xform" id="" method="POST" action="./ClientesServlet">



                <table class="table table-striped">

                    <tr><td>ID cliente*</td>
                        <td><input type="text" class="texto" name="txtcod_cliente" value="<%=cod_cliente != null ? cod_cliente : ""%>" onkeypress="return numero(event);"></td>
                        <td>Documento*</td>
                        <td><input type="text" class="texto" name="txtdocumento" value="<%=documento != null ? documento : ""%>" onkeypress="return numero(event);"></td>

                        
                    <tr><td>Nombre*</td>
                        <td><input type="text" class="texto" name="txtnombre" value="<%=nombre != null ? nombre : ""%>" onkeypress="return numero(event);"></td>
                        <td>Apellido*</td>
                        <td><input type="text" class="texto" name="txtapellido" value="<%=apellido != null ? apellido : ""%>" onkeypress="return numero(event);"></td>
                    </tr>


                    <tr>
                        <td>Telefono*</td>
                        <td> <input type="text" class="texto" name="txttelefono" value="<%=telefono != null ? telefono : ""%>" onkeypress="return numero(event);">
                        <td>Direccion</td>
                        <td> <input type="text" class="texto" name="txtdireccion" value="<%=direccion != null ? direccion : ""%>" onkeypress="return numero(event);" >
                    </tr>

                    <tr><td>Email*</td>
                        <td><input type="text" class="texto" name="txtemail" value="@" onkeypress="return numero(event);"></td>
                        <td>Genero*</td>
                        <td><input type="radio" name="txtgenero" id="Masculino" value="Masculino" label for="Masculino">Masculino </label>
                            <input type="radio" name="txtgenero" id="Femenino" value="Femenino" label for="Femenino">Femenino </label>
                    </tr>

                </table>
                    
                <jsp:include page="FBotones.jsp" flush="true"/>

                <br>Datos enviados  <%=dat%>
                <br>Mensaje recibido <%=men%>
                <%if (Cli != null) {%>
                <table class="table table-hover">
                    <tr>
                        <td>cod_cliente</td>
                        <td>nombre</td>
                        <td>apellido</td>
                        <td>telefono</td>
                        <td>Direccion</td>
                        <td>email</td>
                    </tr>
                    <!--Recorrer para cargar datos-->
                    <%for (Clientes cli : LC) {%>
                    <tr>
                        <td><%=cli.getCod_cliente()%></td>
                        <td><%=cli.getNombre()%></td>
                        <td><%=cli.getApellido()%></td>
                        <td><%=cli.getTelefono()%></td>
                        <td><%=cli.getDireccion()%></td>
                        <td><%=cli.getEmail()%></td>
                    </tr>
                    <%}%>

                </table>
                <%}%>



                </div>

        </body>

        </html>
