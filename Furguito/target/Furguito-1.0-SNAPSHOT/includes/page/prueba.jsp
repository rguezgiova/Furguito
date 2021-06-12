<!DOCTYPE html>
<%@page import="java.util.*" %>
    <%@page import="java.util.List" %>
        <%@page import="java.util.ArrayList" %>
            <html lang="es">

            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
            </head>

            <body>

                <p>
                    <%! List<String> lista= new ArrayList();%>
                        <%! String hola="hola" ; %>
                            <%lista.add(hola);%>
                                <% for(int i=0; i<lista.size(); i++) { out.println(hola.get(i)); } %>

                </p>

            </body>

            </html>