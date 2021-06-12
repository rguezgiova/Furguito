<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.furguito.api.Equipo' %>
<%@ page import="es.iespuertolacruz.furguito.controller.EquipoController" %>
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
%@ page errorPage="../error/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.EquipoController equipoController = new EquipoController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
    
<%@include file="../header.jsp" %>

<jsp:useBean id="equipoController" class="es.iespuertolacruz.furguito.controller.EquipoController" />

<%
int idEquipo = Integer.parseInt(request.getParameter("idEquipo"));
String nombreEquipo = request.getParameter("nombreEquipo");
String ciudadEquipo = request.getParameter("ciudadEquipo");
String estadioEquipo = request.getParameter("estadioEquipo");
int fundacionEquipo = Integer.parseInt(request.getParameter("fundacionEquipo"));
int sociosEquipo = Integer.parseInt(request.getParameter("sociosEquipo"));
int presupuestoEquipo = Integer.parseInt(request.getParameter("presupuestoEquipo"));
String coloresEquipo = request.getParameter("coloresEquipo");

es.iespuertolacruz.furguito.api.Equipo equipo = new Equipo(idEquipo, nombreEquipo, ciudadEquipo, estadioEquipo, fundacionEquipo,
sociosEquipo, presupuestoEquipo, coloresEquipo);

try {
    equipoController.modificarEquipo(equipo);
} catch(PersistenciaException e) {
    out.println("El equipo que desea modificar no esta en la lista");
}
%>

<%@include file="../footer.jsp" %>