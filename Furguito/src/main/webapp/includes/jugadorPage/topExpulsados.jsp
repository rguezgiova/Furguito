<!DOCTYPE html>
<%@page import="java.io.*" %>
    <%@page import="java.util.*" %>
        <%@ page errorPage="../error/showError.jsp" %>
            <%@page import="es.iespuertolacruz.furguito.api.Jugador" %>
                <%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
                    <%@ page import="es.iespuertolacruz.furguito.controller.JugadorController" %>
                        <% try { %>
                            <% es.iespuertolacruz.furguito.controller.JugadorController jugadorController=new
                                JugadorController(); %>
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
                                            <title>Top 10 Expulsiones</title>
                                    </head>

                                    <body>
                                        <div class="body">
                                            <p>
                                                Muestra los jugadores mas expulsados
                                            </p>
                                            <div class="result">
                                                <p>
                                                    <% ArrayList<Jugador> lista =
                                                        jugadorController.consultarMasExpulsados(); %>

                                                        <% for(Jugador jugador : lista){ %>
                                                            <table>
                                                                <tr>
                                                                    <td>Id</td>
                                                                    <td>
                                                                        <%= jugador.getId() %>
                                                                    </td>
                                                                </tr>
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
                                                                    <td>Dorsal</td>
                                                                    <td>
                                                                        <%= jugador.getDorsal() %>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Goles</td>
                                                                    <td>
                                                                        <%= jugador.getGoles() %>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Amarillas</td>
                                                                    <td>
                                                                        <%= jugador.getAmarillas() %>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td>Rojas</td>
                                                                    <td>
                                                                        <%= jugador.getRojas() %>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <% } %>
                                                </p>
                                            </div>

                                        </div>


                                    </body>
                                    <footer>
                                        <%@include file="../footer.jsp" %>
                                    </footer>

                                    </html>