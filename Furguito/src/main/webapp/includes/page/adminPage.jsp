<%! int opcion = 0; %>
<!DOCTYPE html>
<html lang="es">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <link rel="stylesheet" type="text/css" href="../style.css" title="style"/>
   <%@include file="../header.jsp" %>
   <title>Pagina de administracion de Furguito</title>
</head>
<body>
   <div class="menuAdmin">
      <ol>
         <li>Insertar club</li>
         <li>Modificar club</li>
         <li>Borrar club</li>
         <li>Insertar estadio</li>
         <li>Modificar estadio</li>
         <li>Borrar estadio</li>
         <li>Insertar jugador</li>
         <li>Modificar jugador</li>
         <li>Borrar jugador</li>
         <li>Insertar palmares</li>
         <li>Modificar palmares</li>
         <li>Borrar palmares</li>
         <li><a href="../../index.jsp">Salir</a></li>
       </ol>
   </div>
</body>
<footer>
   <%@include file="../footer.jsp" %>
</footer>
</html>