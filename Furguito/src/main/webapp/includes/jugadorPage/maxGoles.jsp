<!DOCTYPE html>
<%@page import="java.io.*" %>
<%@page import="java.util.ArrayList" %>
<%@ page errorPage="../error/showError.jsp" %>
 <%@page import="es.iespuertolacruz.furguito.api.Jugador" %>"
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
<%@ page import="es.iespuertolacruz.furguito.controller.JugadorController" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.JugadorController jugadorController=new JugadorController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
<jsp:useBean id="jugadorController" class="es.iespuertolacruz.furguito.controller.JugadorController" />
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
        <title>Maximos Goleadores</title>
</head>
<body>
    <div class="body">
        <p>
            Muestra los maximos goleadores
        </p>
    </div>
    <div class="result">
            <% ArrayList<Jugador> lista = jugadorController.consultarMaximosGoleadores(); %>
                <% for(Jugador jugador : lista){ %>
                    <table>
                        <tr>
                            <td>Equipo</td>
                            <td>
                                <%= jugador.getEquipo() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Nombre</td>
                            <td>
                                <%= jugador.getNombre() %>
                            </td>
                        </tr>
                        <tr>
                            <td>Goles</td>
                            <td>
                                <%= jugador.getGoles() %>
                            </td>
                        </tr>
                    </table>
                <% } %>
    </div>
</body>
<footer>
    <%@include file="../footer.jsp" %>
</footer>
</html>