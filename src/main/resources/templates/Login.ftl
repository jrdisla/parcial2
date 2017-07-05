<!DOCTYPE html>
<html>

<head>
    <title>Facebook 2.0</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <link rel="stylesheet" href="css/Login.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>
<body>

<div class="wrapper">
    <form class="form-signin" action="/loginProcess" method="post">

        <h1 style="font-size: 60px; font-family: 'Helvetica Neue'" class="text-center text-primary text-uppercase">Facebook</h1>

        <h2 class="title form-signin-heading text-center">Login!</h2>
        <h4 class="subtitle text-center">Inicia seccion en la mejor Red Social</h4>

        <div class="space">
            <label for = "username">Username</label>
            <input id = "username" type="text" title="Email example: Parcial2@gmail.com" class="form-control" name="username" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" placeholder="Email Address" required="" autofocus="" />
        </div>

        <div class="space">
            <label for = "password">Password</label>
            <input id = "paswword" type="password" class="form-control" name="password" placeholder="Password" required=""/>
        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>

        <a href="/register" style="margin-top: 30px" class="btn btn-lg btn-success btn-block" type="submit">Registrarse</a>

    </form>


</div>

<script src="http://code.jquery.com/jquery-latest.js"></script>

</body>
</html>