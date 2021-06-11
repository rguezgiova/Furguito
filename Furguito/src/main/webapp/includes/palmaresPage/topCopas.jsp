<!DOCTYPE html>
<%@page import="java.io.*" %>
    <%@page import="java.util.*" %>
        <%@ page errorPage="../error/showError.jsp" %>
            <%@page import="es.iespuertolacruz.furguito.api.Palmares" %>
                <%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
                    <%@ page import="es.iespuertolacruz.furguito.controller.PalmaresController" %>
                        <% try { %>
                            <% es.iespuertolacruz.furguito.controller.PalmaresController palmaresController=new
                                PalmaresController(); %>
                                <% } catch (PersistenciaException e) { out.println(e); } %>
                                    <jsp:useBean id="palmaresController"
                                        class="es.iespuertolacruz.furguito.controller.PalmaresController" />
                                    <html lang="es">

                                    <head>
                                        <meta charset="UTF-8">
                                        <meta http-equiv="X-UA-Compatible" content="IE=edge">
                                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                        <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
                                        <%@include file="../header.jsp" %>
                                            <title>Equipos con mas copas</title>
                                    </head>

                                    <body>
                                        <div class="body">
                                            <p>
                                                Muestra los 3 equipos con mas copas
                                            </p>
                                            <div class="consulta">
                                                <% ArrayList<Palmares> lista =
                                                    palmaresController.consultarCopas(); %>
                                                    <% for(Palmares palmares : lista){ %>

                                                        <table>
                                                            <tr>
                                                                <td>Id</td>
                                                                <td>Equipo</td>
                                                                <td>Copas del Rey</td>

                                                            </tr>
                                                            <tr>
                                                                <td>
                                                                    <%= palmares.getId() %>
                                                                </td>

                                                                <td>
                                                                    <%= palmares.getEquipo() %>
                                                                </td>
                                                                <td>
                                                                    <%= palmares.getCopasDelRey() %>
                                                                </td>
                                                            </tr>
                                                        </table>
                                                        <% } %>
                                            </div>

                                        </div>

                                    </body>
                                    <footer>
                                        <%@include file="../footer.jsp" %>
                                    </footer>

                                    </html>