
<%
String mensajeError = (String) request.getAttribute("mensajeError");
String usuario = request.getParameter("usuario") == null ? "" : request.getParameter("usuario");
//String usuario = request.getParameter("usuario");
%>

     
 <link rel="stylesheet" href="css/styles1.css">

<script LANGUAGE= "javascript" TYPE="text/javascript" src="./scripts/validar.js"></script>

<script type="text/javascript">
    function popup(url,ancho,alto) {
    var posicion_x; 
    var posicion_y; 
    posicion_x=(screen.width/2)-(ancho/2); 
    posicion_y=(screen.height/2)-(alto/2); 
    window.open(url, "tusitio.com", "width="+ancho+",height="+alto+",menubar=0,toolbar=0,directories=0,scrollbars=no,resizable=no,left="+posicion_x+",top="+posicion_y+"");
    }
    </script>

<div  style="position: absolute; width: 180px; height: 100px; z-index: 1; left: 300px; top: 200px" >
<form id="fondoformulario" name ="xForm" method="POST" action="./Autenticacion" Onsubmit= "return valida_envia();"/>
        <table>
        <tr>
            <td>Usuario</td>
            <td>
            <input name="txtusuario" type="text" class="texto"  id ="estilo" value="<%=usuario%>" size="10">
            </td>       </tr>
        <tr>
            <td>Clave</td>
            <td>
                <input name="txtclave" id="estilo" class="texto" type="password" value="" size="10">
            </td> 
        </tr>
         <tr>
           
            <td><button type="submit" name="action"  value="ingresar" class="btn1" > Aceptar</button></td>
       <tr> <td> <a href="javascript:popup('./FEnvioMail.jsp',400,300)"><img src="imagenes/pregunta.png" border="0">Recordar clave?</a></td></tr>
             
         </tr>
        <%if (mensajeError != null) {%>
       		
	   <div id="dialog" title="Ingreso a citas">
                <%=mensajeError%>
       
           </div>     
        <%}%>
   </table>
        
</form>
</div>
