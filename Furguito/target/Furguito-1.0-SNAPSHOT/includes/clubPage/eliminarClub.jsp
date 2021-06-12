<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <title>Eliminar equipo</title>
    <%@include file="../pelota.jsp" %>
</head>
<body>
    <form method="POST" action="eliminar.jsp">
        Introduce la ID del equipo: <br><input type="number" name="idEquipo"><br>
        <input type="submit" value="Enviar">
    </form>
</body>
<footer>
    <%@include file="../pelota.jsp" %>
    <%@include file="../footer.jsp" %>
</footer>
</html>