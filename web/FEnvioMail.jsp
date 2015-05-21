<%-- 
    Document   : FEnvioMail
    Created on : 11/09/2014, 10:38:03 AM
    Author     : Usuario
--%>

<%
String men =(String) request.getAttribute("mensaje")!=null?(String) request.getAttribute("mensaje"):null;
%>


    <!-- form -->
    <form id="fondoformulario" name ="xForm" method="POST" action="./MailServlet"/>
    <center><img src="imagenes/logo3.jpg"></center>
    <table >
    <tr>
    <td>Mail</td>
    <td> <input type="text"  name="txtmail"   id ="estilo" size="30"></td>     
    <td><button type="submit" class="btn1" name="action" value="envio"> Envio</button></td>
    </tr>
    <%if (men != null) {%>
    <div id="dialog" title="Ingreso a Notas">
        <%=men%>
    </div>     
    <%}%>
    </table>
</form>