<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BIENVENIDO A FURGUITO</title>
    </head>

    <body
        style="text-align: center; font-size: 14px; color: rgb(255, 255, 255); font-weight: bold; background-image: url('imagenes/fondo2.jpeg'); background-repeat: no-repeat; background-size: cover;">
        <div class="login" style="margin-top: 27%; background-color: rgb(104, 101, 100, 50%);">
            <h1>
                Introduzca sus credenciales para acceder a Furguito
            </h1>
            <form style="text-align: center; text" method="get" action="includes/page/validarUsuario.jsp">
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