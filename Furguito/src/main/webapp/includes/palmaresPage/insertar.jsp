<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import='es.iespuertolacruz.furguito.api.Palmares' %>
<%@ page import="es.iespuertolacruz.furguito.controller.PalmaresController" %>
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
%@ page errorPage="../error/showError.jsp" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.PalmaresController palmaresController = new PalmaresController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
    
<%@include file="../header.jsp" %>

<jsp:useBean id="palmaresController" class="es.iespuertolacruz.furguito.controller.PalmaresController" />

<%
int idPalmares = Integer.parseInt(request.getParameter("idPalmares"));
String nombreEquipo = request.getParameter("nombreEquipo");
int ligasEquipo = Integer.parseInt(request.getParameter("ligasEquipo"));
int copasReyEquipo = Integer.parseInt(request.getParameter("copasReyEquipo"));
int superEspanaEquipo = Integer.parseInt(request.getParameter("superEspanaEquipo"));
int superEuropaEquipo = Integer.parseInt(request.getParameter("superEuropaEquipo"));
int championsEquipo = Integer.parseInt(request.getParameter("championsEquipo"));
int mundialClubsEquipo = Integer.parseInt(request.getParameter("mundialClubsEquipo"));

es.iespuertolacruz.furguito.api.Palmares palmares = new Palmares(idPalmares, nombreEquipo, ligasEquipo, copasReyEquipo,
superEspanaEquipo, superEuropaEquipo, championsEquipo, mundialClubsEquipo);

try {
    palmaresController.insertarPalmares(palmares);
} catch(PersistenciaException e) {
    out.println("El palmares que desea insertar ya esta en la lista");
}
%>

<%@include file="../footer.jsp" %>