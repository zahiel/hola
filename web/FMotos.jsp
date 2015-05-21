
<%@page import="java.util.List"%>
<%@page import="sispildora.entidades.Motos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String placa = request.getParameter("txtplaca");
    String cod_cliente = request.getParameter("txtcod_cliente");
    String marca = request.getParameter("txtmarca");
    String color = request.getParameter("txtcolor");
    String kilometraje = request.getParameter("txtkilometraje");
    String modelo = request.getParameter("txtmodelo");

    String men = (String) request.getAttribute("mensajes");
    String dat =(String) request.getAttribute("datos");
    List<Motos> LO = (List<Motos>) request.getAttribute("listado1") != null? 
            (List<Motos>) request.getAttribute("listado1") : null;
    Motos mot = (Motos) request.getAttribute("datomoto") != null? 
            (Motos) request.getAttribute("datomoto") : null;
//los datos estan cargado en mot(objeto) de tipo Usuario
//cargamos los datos en las variables
    if (mot != null) {
        placa = mot.getPlaca();
        cod_cliente = mot.getCod_Cliente();
        marca = mot.getMarca();
        color = mot.getColor();
        kilometraje = mot.getKilometraje();
        modelo = mot.getModelo();
    }//fin si
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/styles.css">
        <script type="text/javascript" src="js/validar.js"></script> 
        <script type="text/javascript" src="js/validarMoto.js"></script> 
    </head>
    <body >
        <div id=" " style="position: absolute; width: 480px;  z-index: 1; left: 300px;      top: 68px"> 
            <form name="xForm" method="POST" id="" action="./MotosServlet" >  
                <p  id="titulo"><h4>Administración de Motos</h4>

                </p>
                
                <table class="table table-striped">
                    <tr>
                        <td>Placa*</td>
                        <td><input type="text" class="texto" name="txtplaca" value="<%=placa != null ? placa : ""%>" onkeypress="return;"></td>

                        <td>ID Cliente*</td>
                        <td><input type="text"  name="txtcod_cliente" class="texto" value="<%=cod_cliente != null ? cod_cliente : ""%>" onkeypress="return numeros(event);"></td>
                    </tr>  
                    <tr>
                        <td>Marca*</td>
                        <td><input type="text" class ="texto" name="txtmarca" value="<%=marca != null ? marca : ""%>" onkeypress="return;"></td>

                        <td>Color*</td>
                        <td><input type="text" class ="texto" name="txtcolor" value="<%=color != null ? color : ""%>" onkeypress="return soloLetras(event);"></td>


                    </tr>     

                    <tr>
                        <td>Kilometraje*</td>
                        <td><input type="text" class ="texto" name="txtkilometraje" value="<%=kilometraje != null ? kilometraje : ""%>" onkeypress="return numeros(event);"></td>

                        <td>Modelo*</td>
                        <td><input type="text" class ="texto" name="txtmodelo" value="<%=modelo != null ? modelo : ""%>" onkeypress="return;"></td>

                    </tr>     
                </table>      
                
                        
                        <jsp:include page="FBotones.jsp" flush="true"/>
                        
                
                <br>Datos enviados  <%=dat%>
              <br>Mensaje recibido  <%=men%>
                <%if (LO != null) {%>
                <table class="table table-hover">
                    <tr>
                        <td>Placa</td>
                        <td>Codigo Cliente</td>
                        <td>Marca</td>
                        <td>Color</td>
                        <td>Kilometraje</td>
                        <td>Modelo</td>
                    </tr>
                    <%-- Recorrer para cargar datos--%>
                    <%for (Motos mo : LO) {%>
                    <tr>
                        <td><%=mo.getPlaca()%></td>
                        <td><%=mo.getCod_Cliente()%></td>
                        <td><%=mo.getMarca()%></td>
                        <td><%=mo.getColor()%></td>
                        <td><%=mo.getKilometraje()%></td>
                        <td><%=mo.getModelo()%></td>
                       
                    </tr>
                    <%}%>

                </table>
                <%}%>


            </form>



        </div> 


    </body>
</html>