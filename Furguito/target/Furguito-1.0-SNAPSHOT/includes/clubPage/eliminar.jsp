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

try {
    equipoController.eliminarEquipo(idEquipo);
} catch(Exception e) {
    out.println("El equipo que desea eliminar no esta en la lista");
}
%>

<%@include file="../pelota.jsp" %>
<%@include file="../footer.jsp" %>