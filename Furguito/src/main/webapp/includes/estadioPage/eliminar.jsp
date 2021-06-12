<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.furguito.api.Estadio' %>
<%@ page import="es.iespuertolacruz.furguito.controller.EstadioController" %>
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
<%@ page errorPage="../error/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.EstadioController estadioController = new EstadioController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
    
<%@include file="../header.jsp" %>

<jsp:useBean id="estadioController" class="es.iespuertolacruz.furguito.controller.EstadioController" />

<%
int idEstadio = Integer.parseInt(request.getParameter("idEstadio"));

try {
    estadioController.eliminarEstadio(idEstadio);
} catch(Exception e) {
    out.println("El estadio que desea eliminar no esta en la lista");
}
%>

<%@include file="../footer.jsp" %>