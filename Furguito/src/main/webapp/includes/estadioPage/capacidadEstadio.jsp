<!DOCTYPE html>
<%@page import="java.io.*" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="es.iespuertolacruz.furguito.api.Estadio" %>
<%@ page import="es.iespuertolacruz.furguito.controller.EstadioController" %>
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
<%@ page errorPage="../page/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.EstadioController estadioController = new EstadioController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
<jsp:useBean id="estadioController" class="es.iespuertolacruz.furguito.controller.EstadioController" />
<jsp:useBean id="estadio" class="es.iespuertolacruz.furguito.api.Estadio" />
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
        <title>Capacidad del estadio</title>
</head>
<body>
    <div class="body">
        <p>
            Muestra la capacidad del estadio
        </p>
    </div>
    <div class="consulta">
        <% String nombre=request.getParameter("nombreEstadio"); %>
            <% try { estadio=estadioController.consultarInformacion(nombre);
                }catch(PersistenciaException e){ out.println(e); } %>
                <table>
                    <tr>
                        <td>Nombre</td>
                        <td>Capacidad</td>
                    <tr>
                        <td>
                            <%= estadio.getNombre() %>
                        </td>
                        <td>
                            <%= estadio.getCapacidad() %>
                        </td>
                    </tr>

                    </tr>
                </table>
    </div>
    <marquee scrollamount="12" behavior="alternate" direction="up">
        <img src="../images/balon.png" />
    </marquee>
    </body>
    <footer>
        <%@include file="../footer.jsp" %>
    </footer>
</html>