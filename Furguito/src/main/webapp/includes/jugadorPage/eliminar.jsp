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

try {
    estadioController.eliminarEquipo(idJugador);
} catch(Exception e) {
    out.println("El jugador que desea eliminar no esta en la lista");
}
%>

<%@include file="../footer.jsp" %>