<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Facebook 2.0 Social Network, Rest Services</title>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">

    <style>
        body {
            background-image: url("../Clientes/img/image-rest.png");
        }
        h1{
            margin-top: 50px;
            margin-bottom: 50px;
            text-align: center;
            text-decoration: dashed;
        }
        h2 {
            margin-top: 50px;
            margin-bottom: 50px;
            text-align: center;
            text-decoration: dashed;
        }

        .btn{
            margin-left: 330px;
        }

        #user{
            margin-left: 330px;
            margin-top: 5px;
        }

        #user2{
            margin-left: 420px;
            margin-top: 20px;
        }

    </style>
</head>

<body>

<h1>Facebook 2.0 Social Network</h1>

<h2>Rest Services</h2>

<button type="button" onclick="addInput()" class="btn btn-success">Mostrar publicaciones de un usuario</button>
<button type="button" class="btn btn-info">Realizar un post</button>


<span id="response"></span>
<script>
    function addInput()
    {
        //document.getElementById('response').innerHTML +='<br/><label id="user2"for="user">Username</label><br/><input type="text" name="username" id="user" /><br/>';
        //document.getElementById('response').innerHTML +='<br/> <button class="btn btn-info" type="submit">Buscar</button>'
        document.getElementById('response').innerHTML +='</br> <form action="search-rest" method="post"> <br/> <label id="user2"for="user">Username</label><br/><input type="text" name="username" id="user" /><br/> <br/> <button class="btn btn-info" type="submit">Buscar</button> </form>';
        document.getElementById('user').style.width="260px";

    }
</script>

</body>

</html>