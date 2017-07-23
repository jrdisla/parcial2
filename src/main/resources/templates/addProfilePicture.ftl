<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Facebook Style Home Page Design</title>
    <link rel="stylesheet" href="css/reg.css">
    <link rel="stylesheet" href="css/bootstrap-imageupload.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/bootstrap-imageupload.js"></script>
</head>
<body class="login">
<div id="facebook-Bar">
    <div id="facebook-Frame">
        <div id="logo"> Facebook 2.0 </div>
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

        <div class="container">


            <div class="container">

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
                            <form action="/file" method="post" enctype="multipart/form-data">

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

                </form>
            </div>

            <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="crossorigin="anonymous"></script>
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
            <script src="js/bootstrap-imageupload.js"></script>

    <!--loginboxinner-->
</div>
<!--loginbox-->

    <script>
        document.getElementById('getval').addEventListener('change', readURL, true);
         function readURL(){
         var file = document.getElementById("getval").files[0];
         var reader = new FileReader();
            reader.onloadend = function(){
            document.getElementById('clock').style.backgroundImage = "url(" + reader.result + ")";
         }
             if(file){
         reader.readAsDataURL(file);
         }else{
         }
    }
    </script>

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