<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns="http://www.w3.org/1999/html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Facebook Style Home Page Design - demo by w3lessons.info</title>
    <link rel="stylesheet" href="css/reg.css">
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

            <form id="login" action="/addUser" method="post">

                <div>
                    <input type="text" id="email" name="estudios" placeholder="Study's Places" value="" class="radius" />
                </div>
                <div>
                    <input type="text" id="remail" name="ig" placeholder="Your IG Account" class="radius" />
                </div>
                <div>
                    <input type="text" id="remail" name="idiomas" placeholder="Languages" class="radius" />
                </div>
                <div>
                    <br />
                    <label>Male: </label><input type="radio" name="sex" value="male" />
                    <br />
                    <label>Female: </label> <input type="radio" name="sex" value="female" />
                    <br /><br />
                </div>
                <div>
                    <label>Describe Yourself:</label>

                    <form >
                        <div class="form-group">
                            <textarea name="description" class="form-control" rows="6" cols="60" required></textarea>
                        </div>
                    </form>
                </div>
                <div>
                    <button class="radius title" name="cont">Continues</button>
                </div>
            </form>

        <!--loginform-->
    </div>
    <!--loginboxinner-->
</div>
<!--loginbox-->
</body>
</html>