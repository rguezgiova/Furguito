<!DOCTYPE html>
<%@page import="java.io.*" %>
    <%@page import="java.util.ArrayList" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <%@ page import='es.iespuertolacruz.furguito.api.Palmares' %>
                <%@ page import="es.iespuertolacruz.furguito.controller.PalmaresController" %>
                    <%@ page import="es.iespuertolacruz.furguito.exception.*" %>
                        <%@ page errorPage="../error/showError.jsp" %>
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
                                                <title>Palmares del equipo</title>
                                        </head>

                                        <body>

                                            <body>
                                                <div class="body">
                                                    <p>
                                                        Muestra el palmares completo del equipo
                                                    </p>
                                                </div>
                                                <div class="consulta">
                                                    <% String nombre=request.getParameter("nombreEquipo"); %>
                                                        <% ArrayList<Palmares> lista =
                                                            palmaresController.consultarPalmares(nombre); %>
                                                            <% for(Palmares palmares : lista){ %>
                                                                <table>
                                                                    <tr>
                                                                        <td>Id</td>
                                                                        <td>Equipo</td>
                                                                        <td>Ligas</td>
                                                                        <td>Copas del Rey</td>
                                                                        <td>Supercopa de Espana</td>
                                                                        <td>Supercopa de Europa</td>
                                                                        <td>Champions</td>
                                                                        <td>Mundial de Clubs</td>
                                                                    <tr>
                                                                        <td>
                                                                            <%= palmares.getId() %>
                                                                        </td>
                                                                        <td>
                                                                            <%= palmares.getEquipo() %>
                                                                        </td>
                                                                        <td>
                                                                            <%= palmares.getLigas() %>
                                                                        </td>
                                                                        <td>
                                                                            <%= palmares.getCopasDelRey() %>
                                                                        </td>
                                                                        <td>
                                                                            <%= palmares.getSuperEspana() %>
                                                                        </td>
                                                                        <td>
                                                                            <%= palmares.getSuperEuropa() %>
                                                                        </td>
                                                                        <td>
                                                                            <%= palmares.getChampions() %>
                                                                        </td>
                                                                        <td>
                                                                            <%= palmares.getMundialClubs() %>
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