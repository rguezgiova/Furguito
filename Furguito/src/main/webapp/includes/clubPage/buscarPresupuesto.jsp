<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
        <title>Buscar Presupuesto</title>
</head>

<body>
    <div class="body">
        <form method="POST" action="presupuestoClub.jsp">
            Introduce el nombre del equipo: <input type="text" name="nombreEquipo"><br>
            <input type="submit" value="Enviar">
        </form>
    </div>
</body>
<footer>
    <%@include file="../footer.jsp" %>
</footer>
</html>