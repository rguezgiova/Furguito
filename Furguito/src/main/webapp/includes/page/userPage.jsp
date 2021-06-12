<!DOCTYPE html>
<html lang="es">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
   <%@include file="../header.jsp" %>
      <title>Pagina de usuario de Furguito</title>
</head>

<body>
   <div class="menuUser">
      <ul>
         <li><a href="../clubPage/buscarClub.jsp">Consultar informacion del club</a></li>
         <li><a href="../clubPage/buscarPresupuesto.jsp">Consultar presupuesto del club</a></li>
         <li><a href="../clubPage/buscarCiudad.jsp">Consultar ciudad del club</a></li>
         <li><a href="../estadioPage/buscarEstadio.jsp">Consultar informacion del estadio</a></li>
         <li><a href="../estadioPage/buscarCapacidad.jsp">Consultar capacidad del estadio</a></li>
         <li><a href="../estadioPage/buscarConstruccion.jsp">Consultar fecha de construccion del estadio</a></li>
         <li><a href="../jugadorPage/buscarJugador.jsp">Consultar informacion del jugador</a></li>
         <li><a href="../jugadorPage/maxGoles.jsp">Top 5 maximos goleadores</a></li>
         <li><a href="../jugadorPage/topExpulsados.jsp">Top 10 jugadores mas expulsados</a></li>
         <li><a href="../palmaresPage/buscarPalmares.jsp">Consultar palmares</a></li>
         <li><a href="../palmaresPage/topLigas.jsp">Equipos con mas ligas</a></li>
         <li><a href="../palmaresPage/topCopas.jsp">Equipos con mas copas</a></li>
         <li><a href="../../index.jsp">Volver</a></li>
      </ul>
   </div>
</body>
<footer>
   <%@include file="../footer.jsp" %>
</footer>

</html>