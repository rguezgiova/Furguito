<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
        <title>Buscar Equipo</title>
</head>
<body>
    <div class="body">
        <form method="POST" action="infoJugador.jsp">
            Introduce el nombre del jugador: <br> <input type="text" name="nombreJugador"><br>
            <input type="submit" value="Enviar">
        </form>
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