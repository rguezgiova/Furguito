<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="includes/style.css" title="style" />
    <link rel="stylesheet" type="text/css" href="includes/style.scss" title="style" />
    <%@include file="includes/header.jsp" %>
    <title>BIENVENIDO A FURGUITO</title>
</head>

<body>
    <div class="body">
        <form>
            <div class="inset">
            <p>
              <label for="user">User</label>
              <input type="text" name="email" id="email">
            </p>
            <p>
              <label for="password">Password</label>
              <input type="password" name="password" id="password">
            </p>
            <p class="p-container">
                <input type="submit" name="go" id="go" value="Log in">
            </p>
            </div>
          </form>
        <marquee scrollamount="25" behavior="alternate">
            <img src="includes/images/balon.png" />
        </marquee>
    </div>
</body>
<footer>
    <%@include file="includes/footer.jsp" %>
</footer>
</html>