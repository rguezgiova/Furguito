<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="includes/style.css" title="style" />
    <%@include file="includes/header.jsp" %>
    <title>BIENVENIDO A FURGUITO</title>
</head>

<body>
    <div class="log-form">
        <h2>Login to your account</h2>
        <form>
          <input type="text" title="username" placeholder="username" />
          <input type="password" title="username" placeholder="password" />
          <button type="submit" class="btn">Login</button>
          <a class="forgot" href="#">Forgot Username?</a>
        </form>
      </div>

        <marquee scrollamount="25" behavior="alternate">
            <img src="includes/images/balon.png" />
        </marquee>

    </div>

</body>
<footer>
    <%@include file="includes/footer.jsp" %>
</footer>
</html>