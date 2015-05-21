
<%@page import="sispildora.entidades.Venta_detalle"%>
<%@page import="sispildora.entidades.Producto"%>
<%@page import="sispildora.entidades.Venta"%>
<%@page import="java.util.List"%>
<%@page import="sispildora.entidades.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String cod_cliente = request.getParameter("txtcod_cliente");
    String nombre = request.getParameter("txtnombre");
    String apellido = request.getParameter("txtapellido");
    String telefono = request.getParameter("txttelefono");
    String direccion = request.getParameter("txtdireccion");
    String email = request.getParameter("txtemail");

    String user = request.getParameter("txtusuario");
    String fecha = request.getParameter("txtfecha");
    String nrofactura = request.getParameter("txtnrofactura");
    String idecliente = request.getParameter("txtidecliente");
    String subtotal = request.getParameter("txtsubtotal");
    String iva = request.getParameter("txtiva");
    String tipo = request.getParameter("txttipo");

    String codpro = request.getParameter("cboproducto");
    String nombrep = request.getParameter("txtnombre");
    String valor = request.getParameter("txtvalor");
    String costo = request.getParameter("txtcosto");
    String stock_min = request.getParameter("txtstock__min");
    String stock_max = request.getParameter("txtstock__max");
    String estado = request.getParameter("txtestado");


    String men = (String) request.getAttribute("mensajes");


    String dat = (String) request.getAttribute("datos");
    Clientes Cli = (Clientes) request.getAttribute("datocliente") != null
            ? (Clientes) request.getAttribute("datocliente") : null;
    List<Venta> VN = (List<Venta>) request.getAttribute("listado") != null
            ? (List<Venta>) request.getAttribute("listado") : null;
    List<Producto> PN = (List<Producto>) request.getAttribute("listadoproducto") != null
            ? (List<Producto>) request.getAttribute("listadoproducto") : null;
    List<Clientes> CL = (List<Clientes>) request.getAttribute("listadoclientes") != null
            ? (List<Clientes>) request.getAttribute("listadoclientes") : null;



    List<Venta_detalle> VD = (List<Venta_detalle>) request.getAttribute("listadodetalle") != null
            ? (List<Venta_detalle>) request.getAttribute("listadodetalle") : null;
//los datos estan cargado en usu(objeto) de tipo Usuario
//cargamos los datos en las variables
    if (Cli != null) {
        nombre = Cli.getNombre();
        apellido = Cli.getApellido();
        telefono = Cli.getTelefono();
        email = Cli.getEmail();
    }

    Venta ven = (Venta) request.getAttribute("datoventa") != null
            ? (Venta) request.getAttribute("datoventa") : null;
//los datos estan cargado en usu(objeto) de tipo Usuario
//cargamos los datos en las variables
    if (ven != null) {
        fecha = ven.getFecha();
        user = ven.getUsuario();
        nrofactura = ven.getNrofactura();
        idecliente = ven.getIdecliente();
        subtotal = ven.getSubtotal();
        iva = ven.getIva();
        tipo = ven.getTipo();
    }//fin si

    Producto pn = (Producto) request.getAttribute("datoproducto") != null
            ? (Producto) request.getAttribute("datoproducto") : null;

    if (pn != null) {
        codpro = pn.getCod_producto();
        nombrep = pn.getDescripcion();
        valor = pn.getValor();
        costo = pn.getCosto();
        stock_min = pn.getStock_min();
        stock_max = pn.getStock_max();
        estado = pn.getEstado();
        tipo = pn.getTipo();


    }
%>

<html>

    <head>

        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"> 
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> </link>


        <script type="text/javascript" src="js/validar.js"></script> 
        <script type="text/javascript" src="js/validarVentas.js"></script> 


    </head>
    <body> 

        <div id=""style="position:absolute;width:510px;haigth:80px;z-index:2;left:260px;top:70px">
            <Form name="xform" id="" method="POST" action="./VentaServlet"> 

                <p  id="titulo"><h4>Ventas</h4></p>



                <table class="table table-striped">

                    <tr>

                        <td>No.Factura*</td>
                        <td><input type="text" name="txtnrofactura" value="<%=nrofactura%>" id="" size="10" maxlength="10"></td>

                        <td>Estado*</td>
                        <td><input type="text" name="txtestado" id="" size="10" maxlength="10"></td>

                    </tr>

                    <tr>

                        <td>Fecha*</td>
                        <td><input type="text" name="txtfecha" value="<%=fecha%>" id="" size="10" maxlength="10" ></td>

                        <td>Usuario*</td>
                        <td><input type="text" name="txtusuario" value="<%=user%>" id="" size="10" maxlength="10"></td>

                    </tr>   

                    <tr>
                        <td>ID Cliente*</td>
                        <td><input type="text" name="txtusuario" value="<%=cod_cliente%>" id="" size="10" maxlength="10"></td>
                        
                        <td>Email</td>
                        <td><input type="text" name="txtmail" size="30" maxlength="100" value="@"></td>

                    </tr>

                    <tr>
                        <td>Nombre*</td>
                        <td><input type="text"  name="txtnombre" value="<%=nombre != null ? nombre : ""%>" onkeypress="return soloLetras(event);"></td>

                        <td>Apellido*</td>
                        <td><input type="text" name="txtapellido" id="" size="20" maxlength="30" ></td>

                    </tr>


                    <tr>

                        <td>Telefono</td>
                        <td> <input type="text" name="telefono" size="20" maxlength="30">

                        <td>Direccion*</td>
                        <td> <input type="text" name="direccion" size="30" maxlength="30" >

                    </tr>

                </table>


                <table class="table table-hover"> 
                    <tr>

                        <td>Producto*</td>
                        <td><select name="cboproducto" >
                                <option value="">-Seleccione-</option>
                                <%if (PN != null) {%>
                                <%for (Producto p : PN) {%>
                                <option value="<%=p.getCod_producto()%>"> <%=p.getDescripcion() + " " + p.getValor()%>  </option>
                                <%}%>  <%--cierra el ciclo for --%>
                                <%}%> <%--cierra el ciclo if --%>

                            </select></td>

                        <td>Cantidad*</td>
                        <td><input type="text" name="txtcantidad" id="" size="10" maxlength="30" onkeypress="return numeros(event);"></td>

                        <td><button input type="submit" class="btn btn-default" name="action" value="guardardetalle" id="" title ="agregar a la venta">+</button></td>




                </table>
                <jsp:include page="FBotones.jsp"/>                


                <br>Datos enviados  <%=dat%>
                <br>Mensaje recibido  <%=men%>
                <%if (VD != null) {%>

                <table class="table table-hover">
                    <tr>
                        <td>Producto</td>
                        <td>Tipo</td>
                        <td>Precio</td>
                        <td>Total</td>
                    </tr>
                    <%for (Venta_detalle det : VD) {%>          
                    <tr>

                        <td><%= det.getNombre()%></td>
                        
                        <td><%= det.getCantidad()%></td>

                        <td><%= det.getValor()%></td>
                        
                        <td><%= det.getTotal()%></td>

                    </tr>
                    <%}%>
                </table>

                <%}%>

            </form>       
    </body>
</div>



</html>
