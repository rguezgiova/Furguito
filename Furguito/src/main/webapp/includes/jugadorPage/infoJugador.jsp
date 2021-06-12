<!DOCTYPE html>
<%@page import="java.io.*" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.furguito.api.Jugador' %>
<%@ page import="es.iespuertolacruz.furguito.controller.JugadorController" %>
<%@ page import="es.iespuertolacruz.furguito.exception.*" %>
<%@ page errorPage="../error/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.JugadorController jugadorController = new JugadorController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
<jsp:useBean id="jugadorController"
    class="es.iespuertolacruz.furguito.controller.JugadorController" />
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
        <title>Informacion del jugador</title>
</head>
<body>
    <body>
        <div class="body">
            <p>
                Muestra la informacion completa del jugador
            </p>
        </div>
        <div class="consulta">
            <% String nombre=request.getParameter("nombreJugador"); %>
                <% ArrayList<Jugador> lista =
                    jugadorController.consultarInformacion(nombre); %>
                    <% for(Jugador jugador : lista){ %>
                        <table>
                            <tr>
                                <td>Equipo</td>
                                <td>Nombre</td>
                                <td>Dorsal</td>
                                <td>Goles</td>
                                <td>Asistencias</td>
                                <td>Amarillas</td>
                                <td>Rojas</td>
                            <tr>
                                <td>
                                    <%= jugador.getEquipo() %>
                                </td>
                                <td>
                                    <%= jugador.getNombre() %>
                                </td>
                                <td>
                                    <%= jugador.getDorsal() %>
                                </td>
                                <td>
                                    <%= jugador.getGoles() %>
                                </td>
                                <td>
                                    <%= jugador.getAsistencias() %>
                                </td>
                                <td>
                                    <%= jugador.getAmarillas() %>
                                </td>
                                <td>
                                    <%= jugador.getRojas() %>
                                </td>
                            </tr>
                            </tr>
                        </table>
                        <% } %>
        </div>
    </body>
    <footer>
        <%@include file="../footer.jsp" %>
    </footer>
</html>