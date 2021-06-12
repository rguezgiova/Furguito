<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.furguito.api.Estadio' %>
<%@ page import="es.iespuertolacruz.furguito.controller.EstadioController" %>
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
%@ page errorPage="../error/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.EstadioController estadioController = new EstadioController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
    
<%@include file="../header.jsp" %>

<jsp:useBean id="estadioController" class="es.iespuertolacruz.furguito.controller.EstadioController" />

<%
int idEstadio = Integer.parseInt(request.getParameter("idEstadio"));
String nombreEstadio = request.getParameter("nombreEstadio");
String equipoEstadio = request.getParameter("equipoEstadio");
int capacidadEstadio = Integer.parseInt(request.getParameter("capacidadEstadio));
int construccionEstadio = Integer.parseInt(request.getParameter("construccionEstadio"));

es.iespuertolacruz.furguito.api.Estadio estadio = new Estadio(idEstadio, nombreEstadio, equipoEstadio, capacidadEstadio, construccionEstadio);

try {
    estadioController.modificarEstadio(estadio);
} catch(PersistenciaException e) {
    out.println("El estadio que desea modificar no esta en la lista");
}
%>

<%@include file="../footer.jsp" %>