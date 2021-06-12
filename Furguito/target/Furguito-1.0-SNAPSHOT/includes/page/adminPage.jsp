<!DOCTYPE html>
<html lang="es">

<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
   <%@include file="../header.jsp" %>
      <title>Pagina de administracion de Furguito</title>
</head>

<body>
   <div class="menuAdmin">
      <ul>
         <li><a href="../clubPage/insertarClub.jsp">Insertar club</a></li>
         <li><a href="../clubPage/modificarClub.jsp">Modificar club</a></li>
         <li><a href="../clubPage/eliminarClub.jsp">Borrar club</a></li>
         <li><a href="../estadioPage/insertarEstadio.jsp">Insertar estadio</a></li>
         <li><a href="../estadioPage/modificarEstadio.jsp">Modificar estadio</a></li>
         <li><a href="../estadioPage/eliminarEstadio.jsp">Borrar estadio</a></li>
         <li><a href="../jugadorPage/insertarJugador.jsp">Insertar jugador</a></li>
         <li><a href="../jugadorPage/modificarJugador.jsp">Modificar jugador</a></li>
         <li><a href="../jugadorPage/eliminarJugador.jsp">Borrar jugador</a></li>
         <li><a href="../palmaresPage/insertarPalmares.jsp">Insertar palmares</a></li>
         <li><a href="../palmaresPage/modificarPalmares.jsp">Modificar palmares</a></li>
         <li><a href="../palmaresPage/eliminarPalmares.jsp">Borrar palmares</a></li>
         <li><a href="../../index.jsp">Salir</a></li>
      </ul>
   </div>
</body>
<footer>
   <%@include file="../footer.jsp" %>
</footer>

</html>