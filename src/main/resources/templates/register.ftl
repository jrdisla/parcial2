<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Facebook Style Home Page Design - demo by w3lessons.info</title>
    <link rel="stylesheet" href="css/reg.css">
    </head>
<body class="login">
<!-- header starts here -->
<div id="facebook-Bar">
      <div id="facebook-Frame">
        <div id="logo"> <a href="http://w3lessons.info">Facebook 2.0</a> </div>
        <div id="header-main-right">
          <div id="header-main-right-nav">
            <form method="post" action="/loginProcess" id="login_form" name="login_form">
              <table border="0" style="border:none">
                <tr>
                  <td ><input type="text" tabindex="1"  id="email" placeholder="Email or Phone" name="username" class="inputtext radius1" value=""></td>
                  <td ><input type="password" tabindex="2" id="pass" placeholder="Password" name="password" class="inputtext radius1" ></td>
                  <td ><input type="submit" class="fbbutton" name="login" value="Login" /></td>
                </tr>
              </table>
            </form>
          </div>
        </div>
  </div>
</div>
<!-- header ends here -->
<div class="loginbox radius">
      <h2 style="color:#141823; text-align:center;">Welcome to Facebook</h2>
      <div class="loginboxinner radius">
        <div class="loginheader">
          <h4 class="title">Connect with friends and the world around you.</h4>
        </div>
        <!--loginheader-->
        <div class="loginform">
          <form id="login" action="/addUser" method="post">
            <div>
              <input type="text" id="firstname" name="firstname" placeholder="First Name" value="" class="radius mini" />
              <input type="text" id="lastname" name="lastname" placeholder="Last Name" value="" class="radius mini" />
            </div>
            <div>
              <input type="text" id="email" name="email" placeholder="Your Email" value="" class="radius" />
            </div>
            <div>
            <input type="text" id="remail" name="countrie" placeholder="Countries" class="radius" />
            </div>
              <div>
                  <input type="text" id="remail" name="city" placeholder="City" class="radius" />
              </div>
              <div>
                  <input type="text" id="remail" name="language" placeholder="Languages" class="radius" />
              </div>
              <div>
                  <input type="date" id="remail" name="date_b" placeholder="Birthday" class="radius" />
              </div>
            <div>
              <input type="password" id="password" name="password" placeholder="New Password" class="radius" />
            </div>
              <div>
              <button class="radius title" name="signup">Sign Up for Facebook</button>
            </div>
          </form>
        </div>
        <!--loginform-->
      </div>
      <!--loginboxinner-->
    </div>
<!--loginbox-->
</body>
</html>
