
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
    <title>Insertar jugador</title>
</head>
<body>
    <form method="POST" action="insertar.jsp">
        ID del jugador: <input type="text" name="idJugador"><br>
        Equipo: <input type="text" name="nombreEquipo"><br>
        Nombre: <input type="text" name="nombreJugador"><br>
        Dorsal: <input type="number" name="dorsalJugador" placeholder="11"><br>
        Goles: <input type="number" name="golesJugador" placeholder="11"><br>
        Asistencias: <input type="number" name="asistenciasJugador" placeholder="11"><br>
        Amarillas: <input type="number" name="amarillasJugador" placeholder="11"><br>
        Rojas: <input type="number" name="rojasJugador" placeholder="11"><br>
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