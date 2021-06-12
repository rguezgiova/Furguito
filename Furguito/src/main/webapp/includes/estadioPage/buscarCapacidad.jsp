<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
        <title>Buscar capacidad del estadio</title>
</head>
<body>
    <div class="body">
        <form method="POST" action="capacidadEstadio.jsp">
            Introduce el nombre del estadio: <br><input type="text" name="nombreEstadio"><br>
            <input type="submit" value="Enviar">
        </form>
    </div>
    <marquee scrollamount="12" behavior="alternate" direction="up">
        <img src="../images/balon.png" />
    </marquee>
</body>
<footer>
    <%@include file="../footer.jsp" %>
</footer>
</html>