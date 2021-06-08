<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign in</title>
</head>

<body>
    <div class="login">
        <h1>Introduzca sus credenciales</h1>
        <br>
        <form method="get" action="includes/page/validarUsuario.jsp">
            <label for="user" class="user">User</label>
            <input type="text" name="user">
            <label for="password" class="password">Password</label>
            <input type="password" name="password">
            <input type="submit" value="Enviar">
        </form>
        <br>
        <a href="includes/page/userPage.jsp">
            <p>Entrar como invitado</p>
        </a>
    </div>
</body>

</html>