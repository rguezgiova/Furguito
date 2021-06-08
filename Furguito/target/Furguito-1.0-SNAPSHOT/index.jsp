<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="includes/style.css" title="style" />
        <title>BIENVENIDO A FURGUITO</title>
    </head>

    <body>
        <div class="login">
            <h1>
                Introduzca sus credenciales para acceder a Furguito
            </h1>
            <form method="get" action="includes/page/validarUsuario.jsp">
                Usuario <input type="text" name="usuario"><br />
                Contraseña <input type="password" name="password"><br />
                <input type="submit" value="Enviar">
            </form>
            <br>
            <a href="includes/page/userPage.jsp">
                <p>Entrar como invitado</p>
            </a>
        </div>

    </body>

    </html>