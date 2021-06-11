<!DOCTYPE html>
<%@page import="java.io.*" %>
    <%@page import="java.util.ArrayList" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <%@ page import='es.iespuertolacruz.furguito.api.Equipo' %>
                <%@ page import="es.iespuertolacruz.furguito.controller.EquipoController" %>
                    <%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
                        <%@ page errorPage="../error/showError.jsp" %>
                            <% try { %>
                                <% es.iespuertolacruz.furguito.controller.EquipoController equipoController=new
                                    EquipoController(); %>
                                    <% } catch (PersistenciaException e) { out.println(e); } %>
                                        <jsp:useBean id="equipoController"
                                            class="es.iespuertolacruz.furguito.controller.EquipoController" />
                                        <jsp:useBean id="equipo" class="es.iespuertolacruz.furguito.api.Equipo" />
                                        <html lang="es">

                                        <head>
                                            <meta charset="UTF-8">
                                            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                            <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
                                            <%@include file="../header.jsp" %>
                                                <title>Informacion del equipo</title>
                                        </head>

                                        <body>

                                            <body>
                                                <div class="body">
                                                    <p>
                                                        Muestra la informacion completa del club
                                                    </p>
                                                </div>
                                                <div class="consulta">
                                                    <% String nombre=request.getParameter("nombreEquipo"); %>
                                                        <% try { equipo=equipoController.consultarInformacion(nombre);
                                                            }catch(PersistenciaException e){ out.println(e); } %>
                                                            <table>
                                                                <tr>
                                                                    <td>Id</td>
                                                                    <td>Nombre</td>
                                                                    <td>Ciudad</td>
                                                                    <td>Estadio</td>
                                                                    <td>Fundacion</td>
                                                                    <td>Numero de socios</td>
                                                                    <td>Presupuesto</td>
                                                                    <td>Colores</td>
                                                                <tr>
                                                                    <td>
                                                                        <%= equipo.getId() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= equipo.getNombre() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= equipo.getCiudad() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= equipo.getEstadio() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= equipo.getFundacion() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= equipo.getNumeroSocios() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= equipo.getPresupuesto() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= equipo.getColores() %>
                                                                    </td>
                                                                </tr>

                                                                </tr>
                                                            </table>

                                                </div>

                                            </body>
                                            <footer>
                                                <%@include file="../footer.jsp" %>
                                            </footer>

                                        </html>