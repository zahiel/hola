<%
String targetModulo = request.getAttribute("targetModulo") == null ? "FBlanco.jsp":(String)request.getAttribute("targetModulo");
%>
<meta charset='utf-8'>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css"> 
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> </link>

<script src="js/jquery-latest.min.js" type="text/javascript"></script>
<script src="js/script.js"></script>

<br>
<table>
    <tr>
        <td width="60%">
        <jsp:include page="FMenu.jsp" flush="true"></jsp:include>
        </td>
    </tr>
    <tr>
        <td width="*">
           
         <jsp:include page="<%=targetModulo%>" flush="true"></jsp:include>
         
        </td>
    </tr>
</table>
 