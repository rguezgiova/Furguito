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
                                            <title>Equipos con mas ligas</title>
                                    </head>

                                    <body>
                                        <div class="body">
                                            <p>
                                                Muestra los 3 equipos con mas ligas
                                            </p>
                                            <% ArrayList<Palmares> lista =
                                                palmaresController.consultarCopas(); %>
                                                <% for(Palmares palmares : lista){ %>
                                                    <table>
                                                        <tr>
                                                            <td>Id</td>
                                                            <td>
                                                                <%= palmares.getId() %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Equipo</td>
                                                            <td>
                                                                <%= palmares.getEquipo() %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Ligas</td>
                                                            <td>
                                                                <%= palmares.getLigas() %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Copas del Rey</td>
                                                            <td>
                                                                <%= palmares.getCopasDelRey() %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Supercopa de España</td>
                                                            <td>
                                                                <%= palmares.getSuperEspana() %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Supercopa de Europa</td>
                                                            <td>
                                                                <%= palmares.getSuperEuropa() %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Champions</td>
                                                            <td>
                                                                <%= palmares.getChampions() %>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>Mundial de Clubs</td>
                                                            <td>
                                                                <%= palmares.getMundialClubs() %>
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