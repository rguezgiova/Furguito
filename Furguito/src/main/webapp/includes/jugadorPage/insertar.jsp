<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.furguito.api.Jugador' %>
<%@ page import="es.iespuertolacruz.furguito.controller.JugadorController" %>
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
<%@ page errorPage="../error/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.JugadorController jugadorController = new JugadorController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
    
<%@include file="../header.jsp" %>

<jsp:useBean id="jugadorController" class="es.iespuertolacruz.furguito.controller.JugadorController" />

<%
int idJugador = Integer.parseInt(request.getParameter("idJugador"));
String nombreEquipo = request.getParameter("nombreEquipo");
String nombreJugador = request.getParameter("nombreJugador");
int dorsalJugador = Integer.parseInt(request.getParameter("dorsalJugador"));
int golesJugador = Integer.parseInt(request.getParameter("golesJugador"));
int asistenciasJugador = Integer.parseInt(request.getParameter("asistenciasJugador"));
int amarillasJugador = Integer.parseInt(request.getParameter("amarillasJugador"));
int rojasJugador = Integer.parseInt(request.getParameter("rojasJugador"));

es.iespuertolacruz.furguito.api.Jugador jugador = new Jugador(idJugador, nombreEquipo, nombreJugador, dorsalJugador, golesJugador,
asistenciasJugador, amarillasJugador, rojasJugador);

try {
    jugadorController.insertarJugador(jugador);
    response.sendRedirect("../page/adminPage.jsp");
} catch(PersistenciaException e) {
    out.println("El jugador que desea insertar ya esta en la lista");
}
%>

<%@include file="../footer.jsp" %>