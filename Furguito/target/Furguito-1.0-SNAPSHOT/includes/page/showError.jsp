%@ page import="es.iespuertolacruz.furguito.exception.*" %>
<%@ page isErrorPage = "true" %>
<html>
   <head>
      <title>Error</title>
   </head>
   <body>
      <h1>Opps...</h1>
      <p>Sorry, an error occurred.</p>
      <p>Here is the exception stack trace: </p>
      <pre><% exception.printStackTrace(response.getWriter()); %></pre>
   </body>
</html>