<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Validacion</title>
</head>
<body>
    <jsp:useBean id="validarUsuario" class="es.iespuertolacruz.furguito.validaciones.ValidarUsuario"/>
        
        <jsp:setProperty name="validarUsuario" property="user"/>
        <jsp:setProperty name="validarUsuario" property="password"/>
          
        <%if(validarUsuario.validar()){%>
            <%@ include file="adminPage.jsp" %>
        <%}else{%>
            <%@ include file="userPage.jsp" %>
        <%}%>
</body>
</html>