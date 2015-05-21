<%-- 
    Document   : prueba
    Created on : 8/05/2014, 10:11:48 AM
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--crear el link para importar
        el javaScript -->
        <script type="text/javascript" src="js/validar.js">
   
    </script>
    
    </head>
    <body>
        <br>Nombres(letras)<input type="text" name="txtnombre" size="10" maxlength="20" id="">
        <br>Telefono(numeros)<input type="text" name="txttelefono" size="10" maxlength="20" onkeypress="return numeros(event);">
                   
  
            </body>

        </html>
