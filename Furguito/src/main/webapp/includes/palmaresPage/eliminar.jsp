<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.furguito.api.Palmares' %>
<%@ page import="es.iespuertolacruz.furguito.controller.PalmaresController" %>
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
<%@ page errorPage="../error/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.PalmaresController palmaresController = new PalmaresController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
    
<%@include file="../header.jsp" %>

<jsp:useBean id="palmaresController" class="es.iespuertolacruz.furguito.controller.PalmaresController" />

<%
int idPalmares = Integer.parseInt(request.getParameter("idPalmares"));

try {
    palmaresController.eliminarPalmares(idPalmares);
} catch(Exception e) {
    out.println("El palmares que desea eliminar no esta en la lista");
}
%>

<%@include file="../footer.jsp" %>