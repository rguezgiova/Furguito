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
    out.println("1- Informacion del club");
    out.println("2- Consultar presupuesto del club");
    out.println("3- Consultar ciudad del club");
    out.println("4- Informacion del estadio");
    out.println("5- Capacidad del estadio");
    out.println("6- Fecha de construccion del estadio");
    out.println("7- Informacion del jugador");
    out.println("8- Top 5 maximos goleadores");
    out.println("9- Top 10 jugadores mas expulsados");
    out.println("10- Consultar palmares");
    out.println("11- Equipos con mas ligas");
    out.println("12- Equipos con mas copas");
    out.println("13- Salir");

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
               out.println("It\'s Friday.");
               break;
            default:
               out.println("Debe escribir un numero de 1 a 13");
        }
    %>
</body>
</html>