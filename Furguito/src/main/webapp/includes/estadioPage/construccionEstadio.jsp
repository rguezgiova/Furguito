<!DOCTYPE html>
<%@page import="java.io.*" %>
    <%@page import="java.util.ArrayList" %>
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <%@ page import="es.iespuertolacruz.furguito.api.Estadio" %>
                <%@ page import="es.iespuertolacruz.furguito.controller.EstadioController" %>
                    <%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
                        <%@ page errorPage="../page/showError.jsp" %>
                            <% try { %>
                                <% es.iespuertolacruz.furguito.controller.EstadioController estadioController=new
                                    EstadioController(); %>
                                    <% } catch (PersistenciaException e) { out.println(e); } %>
                                        <jsp:useBean id="estadioController"
                                            class="es.iespuertolacruz.furguito.controller.EstadioController" />
                                        <jsp:useBean id="estadio" class="es.iespuertolacruz.furguito.api.Estadio" />
                                        <html lang="es">

                                        <head>
                                            <meta charset="UTF-8">
                                            <meta http-equiv="X-UA-Compatible" content="IE=edge">
                                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                            <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
                                            <%@include file="../header.jsp" %>
                                                <title>Construccion del estadio</title>
                                        </head>

                                        <body>

                                            <body>
                                                <div class="body">
                                                    <p>
                                                        Muestra la fecha de construccion del estadio
                                                    </p>
                                                </div>
                                                <div class="consulta">
                                                    <% String nombre=request.getParameter("nombreEstadio"); %>
                                                        <% try { estadio=estadioController.consultarInformacion(nombre);
                                                            }catch(PersistenciaException e){ out.println(e); } %>
                                                            <table>
                                                                <tr>
                                                                    <td>Id</td>
                                                                    <td>Nombre</td>
                                                                    <td>Construccion</td>
                                                                <tr>
                                                                    <td>
                                                                        <%= estadio.getId() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= estadio.getNombre() %>
                                                                    </td>
                                                                    <td>
                                                                        <%= estadio.getConstruccion() %>
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