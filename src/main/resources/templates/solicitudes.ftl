
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Facebook 2.0 Social Network: Profile Page</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
</head>

<body>

<header>
    <div class="container" >
        <img src="img/logo.png" class="logo" alt="">
    <#if usera??>
        <div>
            <label for="name" > Hello: ${usera.nombre}</label>
            <a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Desconectarse</a>
        </div>
    </#if>
        <!-- <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>-->

        </form>
    </div>
</header>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/index">Home</a></li>
                <li class="active"><a href="/members">Members</a></li>
                <!--<li><a href="groups.ftl">Groups</a></li> -->
                <li><a href="/photos">Photos</a></li>
                <li><a href="/profile">Profile</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<section>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="profile">
                    <h1 class="page-header">${usera.nombre}</h1>
                    <div class="row">
                        <div class="col-md-4">
                            <!-- <img src="img/user.png" class="img-thumbnail" alt=""> -->

                        </div>
                        <div class="col-md-8">
                            <ul>
                            <#list listuser as user>
                                <h1 class="page-header">${user.nombre}</h1>
                                <img src="${user.foto_perfil.path}" class="img-thumbnail" alt=""height="250" width="250" />
                                <li><strong>Email :</strong> ${user.email}</li>
                                <li><strong>City: </strong> ${user.ciudad}</li>
                                <li><strong>Gender: </strong>${user.sexo}</li>
                                <li><strong>DOB: </strong> ${user.fecha_nacimiento?string.long}</li>

                                <button id="ola" onclick="myX(${user.id})" type="submit" class="btn btn-primary">Aceptar</button>
                            </#list>


                            </ul>
                        </div>
                    </div><br><br>

                </div>
            </div>


            <!--<div class="panel panel-default groups">
                <div class="panel-heading">
                <h3 class="panel-title">Latest Groups</h3>
              </div>
              <div class="panel-body">
                <div class="group-item">
                  <img src="img/group.png" alt="">
                  <h4><a href="#" class="">Sample Group One</a></h4>
                  <p>This is a paragraph of intro text, or whatever I want to call it.</p>
                </div>
                <div class="clearfix"></div>
                <div class="group-item">
                  <img src="img/group.png" alt="">
                  <h4><a href="#" class="">Sample Group Two</a></h4>
                  <p>This is a paragraph of intro text, or whatever I want to call it.</p>
                </div>
                <div class="clearfix"></div>
                <div class="group-item">
                  <img src="img/group.png" alt="">
                  <h4><a href="#" class="">Sample Group Three</a></h4>
                  <p>This is a paragraph of intro text, or whatever I want to call it.</p>
                </div>
                <div class="clearfix"></div>
                <a href="#" class="btn btn-primary">View All Groups</a>
              </div>
            </div> -->
        </div>
    </div>
    </div>
</section>

<footer>
    <div class="container">
        <p>Pucmm Student, copyright 2017</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="js/bootstrap.js"></script>
<script>
    function myX(id) {
        $.get("/solicitud_acept/"+id,function (data) {

        })

    }
</script>
</body>
</html>
