<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
    <title>Insertar palmares</title>
</head>
<body>
    <form method="POST" action="insertar.jsp">
        ID del palmares: <input type="number" name="idPalmares"><br>
        Equipo: <input type="text" name="nombreEquipo"><br>
        Ligas: <input type="number" name="ligasEquipo" placeholder="11"><br>
        Copas del Rey: <input type="number" name="copasReyEquipo" placeholder="11"><br>
        Supercopas de España: <input type="number" name="superEspanaEquipo" placeholder="11"><br>
        Supercopas de Europa: <input type="number" name="superEuropaEquipo" placeholder="11"><br>
        Champions: <input type="number" name="championsEquipo" placeholder="11"><br>
        Mundial de Clubes: <input type="number" name="mundialClubsEquipo" placeholder="11"><br>
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