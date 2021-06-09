<!DOCTYPE html>
<%@ page import="es.iespuertolacruz.furguito.exception.PersistenciaException" %>
    <%@ page import="es.iespuertolacruz.furguito.controller.JugadorController" %>
        <% try { %>
            <% es.iespuertolacruz.furguito.controller.JugadorController jugadorController=new JugadorController(); %>
                <% } catch (PersistenciaException e) { System.out.println(e); } %>
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
                        <h1>Muestra los maximos goleadores</h1>


                    </body>
                    <footer>
                        <%@include file="../footer.jsp" %>
                    </footer>

                    </html>