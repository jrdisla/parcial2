<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Facebook 2.0 Social Network, Rest Services</title>
    <!-- Bootstrap core CSS -->
    <link href="/Clientes/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/Clientes/css/style.css" rel="stylesheet">
    <link href="css/font-awesome.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Práctica 2</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/Clientes/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/Clientes/css/style.css" rel="stylesheet">
    <link href="/Clientes/css/font-awesome.css" rel="stylesheet">

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
<section>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Wall</h3>
                    </div>
                    <div class="panel-body">
                        <form method="post" action="/post" enctype="multipart/form-data">
                            <div class="form-group">
                                <textarea  name="username"class="form-control" placeholder="Username"></textarea>
                                <textarea  name="opinion_2"class="form-control" placeholder="Write on the wall"></textarea>
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
                            <button type="submit" id="imageupload-enable" style="margin-top: 30px" class="btn btn-default">Submit</button>
                        </form>
                    </div>
                </div>



                            </div>
                        </div>
                    </div>
</section>

<span id="response"></span>
<script>
    function addInput()
    {
        //document.getElementById('response').innerHTML +='<br/><label id="user2"for="user">Username</label><br/><input type="text" name="username" id="user" /><br/>';
        //document.getElementById('response').innerHTML +='<br/> <button class="btn btn-info" type="submit">Buscar</button>'
        document.getElementById('response').innerHTML +='</br> <form action="/search-rest" method="post"> <br/> <label id="user2"for="user">Username</label><br/><input type="text" name="username" id="user" /><br/> <br/> <button class="btn btn-info" type="submit">Buscar</button> </form>';
        document.getElementById('user').style.width="260px";

    }
</script>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/Clientes/js/bootstrap.js"></script>
<script src="/Clientes/js/main.js"></script>


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
<script src="/Clientes/js/bootstrap-imageupload.js"></script>

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