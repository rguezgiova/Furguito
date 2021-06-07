<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Pagina de verificacion de usuario</title>
    </head>
    <body>
        <h1>Verificacion Usuario</h1>

        <jsp:useBean id="validarUsuario" class="es.iespuertolacruz.furguito.validaciones.ValidarUsuario"/>
        
        <jsp:setProperty name="validarUsuario" property="usuario"/>
        <jsp:setProperty name="validarUsuario" property="password"/>
          
        <%if(validarUsuario.validar()){%>
            <jsp:include page = "adminPage.jsp"> </jsp:include>
        <%}else{%>
            <jsp:include page = "userPage.jsp"> </jsp:include>
        <%}%>  
    </body>
</html>