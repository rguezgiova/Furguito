<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>BIENVENIDO A FURGUITO</title>
    </head>
    <body style="font-size: 12px; font-weight: bold;">
        <h1>Introduzca sus credenciales para acceder a Furguito</h1>
        <form style="text-align: center;" method ="get" action="includes/page/validarUsuario.jsp">
            Usuario <input type="text" name="usuario"><br/><br/>
            Contraseña <input type="password" name ="password"><br/>
                <input type ="submit" value="SUBMIT">    
        </form>
    </body>
</html>