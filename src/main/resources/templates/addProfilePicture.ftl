<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Facebook Style Home Page Design - demo by w3lessons.info</title>
    <link rel="stylesheet" href="css/reg.css">
    <link rel="stylesheet" href="css/bootstrap-imageupload.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-imageupload.js"></script>
</head>
<body class="login">
<div id="facebook-Bar">
    <div id="facebook-Frame">
        <div id="logo"> <a href="http://w3lessons.info">Facebook 2.0</a> </div>
        <div id="header-main-right">

        </div>
    </div>
</div>
<div class="loginbox radius">
    <h2 style="color:#141823; text-align:center;">Compleme Your Profile</h2>
    <div class="loginboxinner radius">
        <div class="loginheader">

        </div>
        <!--loginheader-->

        <div class="row">
            <div class="col-md-4">
                <img src="img/user.png" class="img-thumbnail" alt="">

            </div>
            <div>
                <p>
                </p>
            </div>
            <div>
                <a id="flip"  class="btn btn-danger"  role="button">Image</a>
            </div>


        <!--loginform-->
    </div>
    <!--loginboxinner-->
</div>
<!--loginbox-->

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
</body>
</html>