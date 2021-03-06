
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Facebook 2.0 Social Network: Members Page</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
  </head>

  <body>

  <header>
    <div class="container">
      <img src="img/logo.png" class="logo" alt="">
      <form class="form-inline">
        <div class="form-group">
          <label class="sr-only" for="exampleInputEmail3">Email address</label>
          <input type="email" class="form-control" id="exampleInputEmail3" placeholder="Enter email">
        </div>
        <div class="form-group">
          <label class="sr-only" for="exampleInputPassword3">Password</label>
          <input type="password" class="form-control" id="exampleInputPassword3" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-default">Sign in</button><br>
        <div class="checkbox">
          <label>
            <input type="checkbox"> Remember me
          </label>
        </div>
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
            <li><a href="/members">Members</a></li>
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
            <div class="members">
              <h1 class="page-header">Members</h1>
              <div class="row member-row">
                <div class="col-md-3">
                  <img src="img/user.png" class="img-thumbnail" alt="">
                  <div class="text-center">
                    SomeUser01
                  </div>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-success btn-block"><i class="fa fa-users"></i> Add Friend</a></p>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-default btn-block"><i class="fa fa-envelope"></i> Send Message</a></p>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-primary btn-block"><i class="fa fa-edit"></i> View Profile</a></p>
                </div>
              </div>
              <div class="row member-row">
                <div class="col-md-3">
                  <img src="img/user.png" class="img-thumbnail" alt="">
                  <div class="text-center">
                    SomeUser01
                  </div>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-success btn-block"><i class="fa fa-users"></i> Add Friend</a></p>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-default btn-block"><i class="fa fa-envelope"></i> Send Message</a></p>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-primary btn-block"><i class="fa fa-edit"></i> View Profile</a></p>
                </div>
              </div>
              <div class="row member-row">
                <div class="col-md-3">
                  <img src="img/user.png" class="img-thumbnail" alt="">
                  <div class="text-center">
                    SomeUser02
                  </div>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-success btn-block"><i class="fa fa-users"></i> Add Friend</a></p>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-default btn-block"><i class="fa fa-envelope"></i> Send Message</a></p>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-primary btn-block"><i class="fa fa-edit"></i> View Profile</a></p>
                </div>
              </div>
              <div class="row member-row">
                <div class="col-md-3">
                  <img src="img/user.png" class="img-thumbnail" alt="">
                  <div class="text-center">
                    SomeUser03
                  </div>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-success btn-block"><i class="fa fa-users"></i> Add Friend</a></p>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-default btn-block"><i class="fa fa-envelope"></i> Send Message</a></p>
                </div>
                <div class="col-md-3">
                  <p><a href="#" class="btn btn-primary btn-block"><i class="fa fa-edit"></i> View Profile</a></p>
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
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.ftl" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                </ul>
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
        <p>Pucmm Students, Copyright 2017</p>
      </div>
    </footer>

  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/main.js"></script>


  <script>
      $(document).ready(function(){
          $("#flip").click(function(){
              $("#panel").slideDown("slow");
          });
      });
  </script>
  <script>
      $(document).ready(function(){
          $("#flip").dblclick(function(){
              $("#panel").hide();
          });
      });
  </script>


  <style>
      #panel, #flip {
          padding: 5px;
          text-align: center;
          border: solid 1px #c3c3c3;
      }

      #panel {
          padding: 5px;
          display: none;
      }
      #textarea {
          width: 175px;
          height: 75px;
      }
  </style>
  <style>
      .btn-file {
          position: relative;
          overflow: hidden;
      }
      .btn-file input[type=file] {
          position: absolute;
          top: 0;
          right: 0;
          min-width: 100%;
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
