
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
      <#if user??>
          <div>
              <label for="name" > Hello: ${user.nombre}</label>
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
            <li class="active"><a href="/index">Home</a></li>
              <li><a href="/zonaAdmin">Zona Administracion</a></li>
              <li><a href="/members">Members</a></li>
            <!--<li><a href="groups.ftl">Groups</a></li> -->
            <#if user.esAdmin>

            </#if>
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
              <h1 class="page-header">${user.nombre}</h1>
              <div class="row">
                <div class="col-md-4">
                 <!-- <img src="img/user.png" class="img-thumbnail" alt=""> -->
                    <img src="${ver}" class="img-thumbnail" alt="error" />
                </div>
                <div class="col-md-8">
                  <ul>
                      <#if user??>
                    <li><strong>Name: </strong> ${user.nombre}</li>
                    <li><strong>Email :</strong> ${user.email}</li>
                    <li><strong>City: </strong> ${user.ciudad}</li>
                    <li><strong>Gender: </strong>${user.sexo}</li>
                    <li><strong>DOB: </strong> ${user.fecha_nacimiento?date}</li>
                    <li><strong>Pais: </strong>${user.lugar_nacimiento}</li>
                    <li><strong>Instagram: </strong> ${user.ig_cuenta}</li>
                      </#if>
                  </ul>
                </div>
              </div><br><br>
              <div class="row">
                <div class="col-md-12">
                  <div class="panel panel-default">
                    <div class="panel-heading">
                      <h3 class="panel-title">Profile Wall</h3>
                    </div>
                    <div class="panel-body">
                      <form action = "/addText" method="post">
                        <div class="form-group">
                          <textarea class="form-control" name="opinion" placeholder="Write on the wall"></textarea>
                        </div>
                        <button type="submit" style="margin-bottom: 30px" class="btn btn-default">Submit</button>
                        <div class="pull-right">
                          <div class="btn-toolbar">
                         <!--<button type="button" class="btn btn-default"><i class="fa fa-pencil"></i>Text</button> -->
                            <button type="button" class="btn btn-default"><i class="fa fa-file-image-o"></i>Image</button>
                            <!--<button type="button" class="btn btn-default"><i class="fa fa-file-video-o"></i>Video</button> -->
                          </div>
                        </div>
                      </form>
                        <#if user??>
                            <#if user.articulos??>
                              <#list articulo as Articulos>
                                  <textarea class="form-control" style="margin-bottom: 30px" name= "opinion" readonly> ${Articulos.body}</textarea>
                              </#list>
                            </#if>
                        </#if>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="panel panel-default friends">
              <div class="panel-heading">
                <h3 class="panel-title">My Friends</h3>
              </div>
              <div class="panel-body">
                <ul>
                  <!-- <#--<#if user??>
                      <#if user.amigos??>
                        <#list amigos as Usuario>
                            <li> <a href="/profile"$Usuario.email></a></li>
                        </#list>
                      </#if>
                   </#if>
                   -->-->
                <#list image as images>
                    <li><a href="/ver/${images.usuario.id}" class="thumbnail"><img src="${images.usuario.foto_perfil.path}" alt="">${images.usuario.nombre}</a></li>
                </#list>

                <div class="clearfix"></div>
                <a class="btn btn-primary" href="#">View All Friends</a>
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

  <style>
      .btn-file {
          position: relative;
          overflow: hidden;
          min-width: 100%;
      }
      .btn-file input[type=file] {
          position: absolute;
          top: 0;
          right: 0;
          min-height: 100%;
          font-size: 100px;
          text-align: right;
          filter: alpha(opacity=0);
          opacity: 0;
          outline: none;
          background: white;
          cursor: inherit;
          display: block;
      }

      #img-upload{
          width: 100%;
      }
  </style>

  <style>
      #clock{
          background-image:url('');
          background-size:cover;
          background-position: center;
          height: 200px; width: 200px;
          border: 1px solid #bbb;
      }
  </style>

  <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
  <script src="js/bootstrap-imageupload.js"></script>

  <script>
      var $imageupload = $('.imageupload');
      $imageupload.imageupload();

      $('#imageupload-disable').on('click', function() {
          $imageupload.imageupload('disable');
          $(this).blur();
      })

      $('#imageupload-enable').on('click', function() {
          $imageupload.imageupload('enable');
          $(this).blur();
      })

      $('#imageupload-reset').on('click', function() {
          $imageupload.imageupload('reset');
          $(this).blur();
      });
  </script>

  </body>
</html>
