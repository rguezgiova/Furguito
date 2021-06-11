<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.furguito.api..Equipo' %>
<%@ page import="es.iespuertolacruz.furguito.controller.EquipoController" %>
<%@ page errorPage = "include/page/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.EquipoController equipoController = new EquipoController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
    
<%@include file="../header.jsp" %>

<%
int idEquipo = request.getParameter("idEquipo");
String nombreEquipo = request.getParameter("nombreEquipo");
String ciudadEquipo = request.getParameter("ciudadEquipo");
String estadioEquipo = request.getParameter("estadioEquipo");
int fundacionEquipo = request.getParameter("fundacionEquipo");
int sociosEquipo = request.getParameter("sociosEquipo");
int presupuestoEquipo = request.getParameter("presupuestoEquipo");
String coloresEquipo = request.getParameter("coloresEquipo");

<% es.iespuertolacruz.furguito.api.Equipo equipo = new Equipo(idEquipo, nombreEquipo, ciudadEquipo, estadioEquipo, fundacionEquipo,
sociosEquipo, presupuestoEquipo, coloresEquipo); %>

try {
    EquipoController.insertarEquipo(equipo);
} catch(Exception e) {
    System.out.print(e);
    e.printStackTrace();
}
%>

<%@include file="../footer.jsp" %>