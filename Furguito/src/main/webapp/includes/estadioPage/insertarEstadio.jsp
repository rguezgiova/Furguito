<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
    <title>Insertar estadio</title>
</head>
<body>
    <form method="POST" action="insertar.jsp">
        ID del estadio: <input type="number" name="idEstadio"><br>
        Nombre: <input type="text" name="nombreEstadio"><br>
        Equipo: <input type="text" name="equipoEstadio"><br>
        Capacidad: <input type="number" name="capacidadEstadio" placeholder="111111"><br>
        Construccion: <input type="number" name="construccionEstadio" placeholder="1111"><br>
        <input type="submit" value="Enviar">
    </form>
    <marquee scrollamount="12" behavior="alternate" direction="up">
        <img src="../images/balon.png" />
    </marquee>
</body>
<footer>
    <%@include file="../footer.jsp" %>
</footer>
</html>