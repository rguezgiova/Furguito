<!DOCTYPE html>
<%@page import="java.io.*" %>
<%@page import="java.util.ArrayList" %>
<%@ page errorPage = "../error/showError.jsp" %>
<%@page import="es.iespuertolacruz.furguito.api.Jugador" %>"
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
<%@ page import="es.iespuertolacruz.furguito.controller.JugadorController" %>
<% try { %>
    <% es.iespuertolacruz.furguito.controller.JugadorController jugadorController=new JugadorController(); %>
<% } catch (PersistenciaException e) { out.println(e); } %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style" />
    <%@include file="../header.jsp" %>
        <title>Maximos Goleadores</title>
</head>
<body>
    <div class="body">
        <p>
            Muestra los maximos goleadores
        </p>
    </div>
    <div class="result">
        <p>
            <%
                try {
                    ArrayList<Jugador> lista = new ArrayList();
                    out.println(lista.toString()) ;
                }
                catch (Exception e) {
                    out.println("An exception occurred: " + e.getMessage());
                }
            %>
        </p>
    </div>
</body>
<footer>
    <%@include file="../footer.jsp" %>
</footer>
</html>