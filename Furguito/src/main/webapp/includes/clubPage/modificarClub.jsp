<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
    <title>Modificar club</title>
</head>
<body>
    <form method="POST" action="modificar.jsp">
        ID del equipo: <input type="number" name="idEquipo"><br>
        Nombre: <input type="text" name="nombreEquipo"><br>
        Ciudad: <input type="text" name="ciudadEquipo"><br>
        Estadio: <input type="text" name="estadioEquipo"><br>
        Fundacion: <input type="number" name="fundacionEquipo" placeholder="1111"><br>
        Numero de socios: <input type="number" name="sociosEquipo" placeholder="11111111"><br>
        Presupuesto: <input type="number" name="presupuestoEquipo" placeholder="1111111111"><br>
        Colores: <input type="text" name="coloresEquipo"><br>
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