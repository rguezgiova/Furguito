<%! int opcion = 0; %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagina de usuario de Furguito</title>
</head>
<body>
    <ol>
        <li>Consultar nformacion del club</li>
        <li>Consultar presupuesto del club</li>
        <li>Consultar ciudad del club</li>
        <li>Consultar informacion del estadio</li>
        <li>Consultar capacidad del estadio</li>
        <li>Consultar fecha de construccion del estadio</li>
        <li>Consultar informacion del jugador</li>
        <li>Top 5 maximos goleadores</li>
        <li>Top 10 jugadores mas expulsados</li>
        <li>Consultar palmares</li>
        <li>Equipos con mas ligas</li>
        <li>Equipos con mas copas</li>
        <li>Salir</li>
      </ol>

    <%
        switch(opcion) {
            case 1:
               out.println("It\'s Monday.");
               break;
            case 2:
               out.println("It\'s Tuesday.");
               break;
            case 3:
               out.println("It\'s Wednesday.");
               break;
            case 4:
               out.println("It\'s Thursday.");
               break;
            case 5:
               out.println("It\'s Friday.");
               break;
            case 6:
               out.println("It\'s Friday.");
               break;
            case 7:
               out.println("It\'s Friday.");
               break;
            case 8:
               out.println("It\'s Friday.");
               break;
            case 9:
               out.println("It\'s Friday.");
               break;
            case 10:
               out.println("It\'s Friday.");
               break;
            case 11:
               out.println("It\'s Friday.");
               break;
            case 12:
               out.println("It\'s Friday.");
               break;
            case 13:
               <%@ include file="src/main/webapp/index.jsp" %>
               break;
            default:
               out.println("Debe escribir un numero de 1 a 13");
        }
    %>
</body>
</html>