<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../style.css" title="style"/>
    <%@include file="includes/header.jsp" %>
    <title>Login</title>
</head>
<body>
    <form class="login-form">
        <p class="login-text">
          <span class="fa-stack fa-lg">
            <i class="fa fa-circle fa-stack-2x"></i>
            <i class="fa fa-lock fa-stack-1x"></i>
          </span>
        </p>
        <input type="email" class="login-username" autofocus="true" required="true" placeholder="Email" />
        <input type="password" class="login-password" required="true" placeholder="Password" />
        <input type="submit" name="Login" value="Login" class="login-submit" />
      </form>
      <a href="#" class="login-forgot-pass">forgot password?</a>
      <div class="underlay-photo"></div>
      <div class="underlay-black"></div> 
</body>
<footer>
    <%@include file="includes/footer.jsp" %>
</footer>
</html>