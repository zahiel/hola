
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<% 
  String target= request.getAttribute("target")!=null?(String)request.getAttribute("target"):"FLoginBox.jsp";


%>
<html>
    
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"> 
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> </link>
    
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taller de motos "Pildora"</title>
        <link rel="shortcut icon" href="imagenes/favicon.ico" >
         <link rel="stylesheet" href="css/styles.css">
   
     
 </head>
 <body> 
    <table class="table table-striped">
    <tr>
    <td><jsp:include page="<%=target%>" flush="true"></jsp:include></td>

    </tr>      
    </table>
    
     <div id="layer1" style="position: absolute; width:280px; height: 300px; z-index: 1; left: 500px; top: 150px">
      <img alt="" height="280" src="imagenes/logo.jpg" width="300" /></div>
                 

           
    </body>
     </div>
                 
      

    
	
	
	        

           
           
    </body>
</html>
