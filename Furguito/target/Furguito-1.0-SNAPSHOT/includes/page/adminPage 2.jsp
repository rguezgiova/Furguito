<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagina de administrador de Furguito</title>
</head>
<body>
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