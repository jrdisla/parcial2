
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Facebook 2.0 Social Network</title>

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
    <#if user??>
        <div>
            <label for="name" > Hello: ${user.nombre}</label>
            <a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Desconectarse</a>
        </div>
    </#if>
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
           <!-- <li><a href="groups.ftl">Groups</a></li> -->
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
            <div class="panel panel-default">
              <div class="panel-heading">
                <h3 class="panel-title">Wall</h3>
              </div>
              <div class="panel-body">
                <form method="post" action="/addText" enctype="multipart/form-data">
                  <div class="form-group">
                    <textarea formenctype="multipart/form-data" name="opinion_2" class="form-control" placeholder="Write on the wall"></textarea>
                  </div>

                  <div class="pull-right">
                    <div class="btn-toolbar">
                      <!--<button type="button" class="btn btn-default"><i class="fa fa-pencil"></i>Text</button> -->
                        <a id="flip"  class="btn btn-danger"  role="button">Image</a>
                     <!-- <button type="button" class="btn btn-default"><i class="fa fa-file-video-o"></i>Video</button> -->
                        <div id = "panel">
                            <div class="imageupload panel panel-default">
                                    <div class="panel-heading clearfix">
                                        <h3 class="panel-title pull-left">Upload Image</h3>
                                        <div class="btn-group pull-right">
                                        </div>
                                    </div>
                                    <div class="file-tab panel-body">
                                        <label class="btn btn-default btn-file">
                                            <div>
                                                <span>Browse</span></div>
                                            <!-- The file is stored here. -->
                                            <input type="file"  name="image-file" formenctype="multipart/form-data">

                                        </label>
                                        <button type="button" class="btn btn-default">Remove</button>
                                    </div>
                                    <div class="url-tab panel-body">
                                        <div class="input-group">
                                            <input type="text" class="form-control hasclear" placeholder="Image URL">
                                            <div class="input-group-btn">
                                                <button type="button" class="btn btn-default">Submit</button>
                                            </div>
                                        </div>
                                        <button type="button" style="margin-top: 30px" class="btn btn-default">Remove</button>
                                        <!-- The URL is stored here. -->
                                        <input type="hidden" name="image-url">
                                    </div>
                                </div>

                                <!-- bootstrap-imageupload method buttons. -->

                                <button type="submit" id="imageupload-enable" style="margin-top: 30px" class="btn btn-success">Upload</button>



                        </div>
                    </div>
                  </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
              </div>
            </div>
            <div class="panel panel-default post">
              <div class="panel-body">
                 <div class="row">

                   <div class="col-sm-10">
                     <div class="bubble">
                       <div class="pointer">

                           <#if articulos??>

                               <#list articulos as Articulos>

                                   <a href="">${Articulos.usuario.nombre}
                                   <textarea class="form-control" style="margin-bottom: 30px" name= "opinion" readonly> ${Articulos.body}</textarea>
                                   <li><a href="/hola" class="thumbnail"><img src="${Articulos.imagen.path}" alt=""></a></li>
                               </#list>
                           </#if>

                       </div>
                       <div class="pointer-border"></div>
                     </div>
                     <p class="post-actions"><a href="#">Comment</a> - <a href="#">Like</a> - <a href="#">Follow</a> - <a href="#">Share</a></p>
                     <div class="comment-form">
                       <form class="form-inline">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="enter comment">
                        </div>
                        <button type="submit" class="btn btn-default">Add</button>
                      </form>
                     </div>
                     <div class="clearfix"></div>
                     <div class="comments">
                       <div class="comment">
                         <a href="#" class="comment-avatar pull-left"><img src="img/user.png" alt=""></a>
                         <div class="comment-text">
                           <p></p>
                         </div>
                       </div>
                       <div class="clearfix"></div>
                       <div class="comment">
                         <a href="#" class="comment-avatar pull-left"><img src="img/user.png" alt=""></a>
                         <div class="comment-text">
                           <p></p>
                         </div>
                       </div>
                       <div class="clearfix"></div>
                     </div>
                   </div>
                 </div>
              </div>
            </div>
            <!--<div class="panel panel-default post">
              <div class="panel-body">
                 <div class="row">
                   <div class="col-sm-2">
                     <a href="profile.ftl" class="post-avatar thumbnail"><img src="img/user.png" alt=""><div class="text-center">DevUser1</div></a>
                     <div class="likes text-center">7 Likes</div>
                   </div>
                   <div class="col-sm-10">
                     <div class="bubble">
                       <div class="pointer">
                         <p>Hey I was wondering if you wanted to go check out the football game later. I heard they are supposed to be really good!</p>
                       </div>
                       <div class="pointer-border"></div>
                     </div>
                     <p class="post-actions"><a href="#">Comment</a> - <a href="#">Like</a> - <a href="#">Follow</a> - <a href="#">Share</a></p>
                     <div class="comment-form">
                       <form class="form-inline">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="enter comment">
                        </div>
                        <button type="submit" class="btn btn-default">Add</button>
                      </form>
                     </div>
                     <div class="clearfix"></div>

                     <div class="comments">
                       <div class="comment">
                         <a href="#" class="comment-avatar pull-left"><img src="img/user.png" alt=""></a>
                         <div class="comment-text">
                           <p>I am just going to paste in a paragraph, then we will add another clearfix.</p>
                         </div>
                       </div>
                       <div class="clearfix"></div>
                       <div class="comment">
                         <a href="#" class="comment-avatar pull-left"><img src="img/user.png" alt=""></a>
                         <div class="comment-text">
                           <p>I am just going to paste in a paragraph, then we will add another clearfix.</p>
                         </div>
                       </div>
                       <div class="clearfix"></div>
                     </div>
                   </div>
                 </div>
              </div>
            </div>
            <div class="panel panel-default post">
              <div class="panel-body">
                 <div class="row">
                   <div class="col-sm-2">
                     <a href="profile.ftl" class="post-avatar thumbnail"><img src="img/user.png" alt=""><div class="text-center">DevUser1</div></a>
                     <div class="likes text-center">7 Likes</div>
                   </div>
                   <div class="col-sm-10">
                     <div class="bubble">
                       <div class="pointer">
                         <p>Hey I was wondering if you wanted to go check out the football game later. I heard they are supposed to be really good!</p>
                       </div>
                       <div class="pointer-border"></div>
                     </div>
                     <p class="post-actions"><a href="#">Comment</a> - <a href="#">Like</a> - <a href="#">Follow</a> - <a href="#">Share</a></p>
                     <div class="comment-form">
                       <form class="form-inline">
                        <div class="form-group">
                          <input type="text" class="form-control" placeholder="enter comment">
                        </div>
                        <button type="submit" class="btn btn-default">Add</button>
                      </form>
                     </div>
                     <div class="clearfix"></div>

                     <div class="comments">
                       <div class="comment">
                         <a href="#" class="comment-avatar pull-left"><img src="img/user.png" alt=""></a>
                         <div class="comment-text">
                           <p>I am just going to paste in a paragraph, then we will add another clearfix.</p>
                         </div>
                       </div>
                       <div class="clearfix"></div>
                       <div class="comment">
                         <a href="#" class="comment-avatar pull-left"><img src="img/user.png" alt=""></a>
                         <div class="comment-text">
                           <p>I am just going to paste in a paragraph, then we will add another clearfix.</p>
                         </div>
                       </div>
                       <div class="clearfix"></div>
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
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
                  <li><a href="profile.html" class="thumbnail"><img src="img/user.png" alt=""></a></li>
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
        <p>Pucmm students, copyright 2017</p>
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
