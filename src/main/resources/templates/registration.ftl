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
        <img src="img/Social_Media.png" width="250px" height="140px" class="logo" alt="">
    </div>
</header>

<form id="reg_form" name="reg_form" class="form-horizontal mbn" action="https://secure.tagged.com/register.html?src=index_email&page=index&loc=en_US" method="post">
    <div id="first_step">
        <div class="row_v3 control-group">
            <div class="controls">
                <input class="input_v3 id-name" placeholder="First Name"  type="text" name="firstName" id="first_name" value="" size="35" maxlength="35"  tabindex="1"/>
                <input class="input_v3 id-name" placeholder="Last Name"  style="margin-left: 15px;" type="text" name="lastName" id="last_name" value="" size="35" maxlength="35" tabindex="2"/>
            </div>
            <div class="clear_both"></div>
        </div><div class="row_v3 control-group email disabled">
        <div class="controls">
            <input class="input_v3" type="email" name="email" placeholder="Email"                value=""
                   id="email"
                   tabindex="3"
                   title="We'll send you a welcome email, so be sure you can receive email at this address!" />
        </div>
        <div class="clear_both"></div>
    </div><div class="row_v3 control-group">
        <div class="controls id-password-container">
            <input class="input_v3" type="text" class="input-large" name="password" value="Password" id="password_holder" style="display:none;" tabindex="4" />
            <input class="input_v3" type="password" name="password" placeholder="Password" value="" id="password" tabindex="5" autocomplete="off"/>
        </div>
        <div class="clear_both"></div>
    </div><!--don't show zip code for international user-->
        <div id="zipCodeWrapper" class="row_v3 hide_me control-group">
            <div class="controls">
                <input type="text" class="input_v3" name="zipCode" id="zipCode" placeholder="Zip Code"  value="" size="5" maxlength="5" tabindex="6"/>
            </div>
            <div class="clear_both"></div>
        </div><!--show city for international user-->
        <div id="cityWrapper" class="row_v3 hide_me control-group">
            <div class="controls">
                <input tabindex="7" type="text" name="city" class="input_v3" placeholder="City"  value="" id="city" class="search-fields-text" />
                <input type="hidden" name="cityId" id="cityId" value="" />
            </div>
            <div id="cities" class="cities controls" ></div>
            <div class="clear_both"></div>
        </div><div class="row_v3 birthday_row control-group">
        <label class="label_v3 control-label id-birthday-label" for="birth_day">Birthday:</label>
        <div class="col_container controls id-birthday-controls">
            <!--day input-->
            <select tabindex="8" name="birthDay" id="birth_day" class="date" >
                <option value="0" id="day_option">Day</option>
                <option value="1"  >
                    1        </option>
                <option value="2"  >
                    2        </option>
                <option value="3"  >
                    3        </option>
                <option value="4"  >
                    4        </option>
                <option value="5"  >
                    5        </option>
                <option value="6"  >
                    6        </option>
                <option value="7"  >
                    7        </option>
                <option value="8"  >
                    8        </option>
                <option value="9"  >
                    9        </option>
                <option value="10"  >
                    10        </option>
                <option value="11"  >
                    11        </option>
                <option value="12"  >
                    12        </option>
                <option value="13"  >
                    13        </option>
                <option value="14"  >
                    14        </option>
                <option value="15"  >
                    15        </option>
                <option value="16"  >
                    16        </option>
                <option value="17"  >
                    17        </option>
                <option value="18"  >
                    18        </option>
                <option value="19"  >
                    19        </option>
                <option value="20"  >
                    20        </option>
                <option value="21"  >
                    21        </option>
                <option value="22"  >
                    22        </option>
                <option value="23"  >
                    23        </option>
                <option value="24"  >
                    24        </option>
                <option value="25"  >
                    25        </option>
                <option value="26"  >
                    26        </option>
                <option value="27"  >
                    27        </option>
                <option value="28"  >
                    28        </option>
                <option value="29"  >
                    29        </option>
                <option value="30"  >
                    30        </option>
                <option value="31"  >
                    31        </option>
            </select><!--month input-->
            <select tabindex="9" name="birthMonth" id="birth_month" class="date">
                <option value="0" id="month_option" >Month</option>
                <option id="birth_month1" value="1"  >
                    January        </option>
                <option id="birth_month2" value="2"  >
                    February        </option>
                <option id="birth_month3" value="3"  >
                    March        </option>
                <option id="birth_month4" value="4"  >
                    April        </option>
                <option id="birth_month5" value="5"  >
                    May        </option>
                <option id="birth_month6" value="6"  >
                    June        </option>
                <option id="birth_month7" value="7"  >
                    July        </option>
                <option id="birth_month8" value="8"  >
                    August        </option>
                <option id="birth_month9" value="9"  >
                    September        </option>
                <option id="birth_month10" value="10"  >
                    October        </option>
                <option id="birth_month11" value="11"  >
                    November        </option>
                <option id="birth_month12" value="12"  >
                    December        </option>
            </select><!-- year input -->
            <select tabindex="10" name="birthYear"  id="birth_year" class="date" >
                <option value="0" id="year_option">Year</option>
                <option value="2004"  >
                    2004        </option>
                <option value="2003"  >
                    2003        </option>
                <option value="2002"  >
                    2002        </option>
                <option value="2001"  >
                    2001        </option>
                <option value="2000"  >
                    2000        </option>
                <option value="1999"  >
                    1999        </option>
                <option value="1998"  >
                    1998        </option>
                <option value="1997"  >
                    1997        </option>
                <option value="1996"  >
                    1996        </option>
                <option value="1995"  >
                    1995        </option>
                <option value="1994"  >
                    1994        </option>
                <option value="1993"  >
                    1993        </option>
                <option value="1992"  >
                    1992        </option>
                <option value="1991"  >
                    1991        </option>
                <option value="1990"  >
                    1990        </option>
                <option value="1989"  >
                    1989        </option>
                <option value="1988"  >
                    1988        </option>
                <option value="1987"  >
                    1987        </option>
                <option value="1986"  >
                    1986        </option>
                <option value="1985"  >
                    1985        </option>
                <option value="1984"  >
                    1984        </option>
                <option value="1983"  >
                    1983        </option>
                <option value="1982"  >
                    1982        </option>
                <option value="1981"  >
                    1981        </option>
                <option value="1980"  >
                    1980        </option>
                <option value="1979"  >
                    1979        </option>
                <option value="1978"  >
                    1978        </option>
                <option value="1977"  >
                    1977        </option>
                <option value="1976"  >
                    1976        </option>
                <option value="1975"  >
                    1975        </option>
                <option value="1974"  >
                    1974        </option>
                <option value="1973"  >
                    1973        </option>
                <option value="1972"  >
                    1972        </option>
                <option value="1971"  >
                    1971        </option>
                <option value="1970"  >
                    1970        </option>
                <option value="1969"  >
                    1969        </option>
                <option value="1968"  >
                    1968        </option>
                <option value="1967"  >
                    1967        </option>
                <option value="1966"  >
                    1966        </option>
                <option value="1965"  >
                    1965        </option>
                <option value="1964"  >
                    1964        </option>
                <option value="1963"  >
                    1963        </option>
                <option value="1962"  >
                    1962        </option>
                <option value="1961"  >
                    1961        </option>
                <option value="1960"  >
                    1960        </option>
                <option value="1959"  >
                    1959        </option>
                <option value="1958"  >
                    1958        </option>
                <option value="1957"  >
                    1957        </option>
                <option value="1956"  >
                    1956        </option>
                <option value="1955"  >
                    1955        </option>
                <option value="1954"  >
                    1954        </option>
                <option value="1953"  >
                    1953        </option>
                <option value="1952"  >
                    1952        </option>
                <option value="1951"  >
                    1951        </option>
                <option value="1950"  >
                    1950        </option>
                <option value="1949"  >
                    1949        </option>
                <option value="1948"  >
                    1948        </option>
                <option value="1947"  >
                    1947        </option>
                <option value="1946"  >
                    1946        </option>
                <option value="1945"  >
                    1945        </option>
                <option value="1944"  >
                    1944        </option>
                <option value="1943"  >
                    1943        </option>
                <option value="1942"  >
                    1942        </option>
                <option value="1941"  >
                    1941        </option>
                <option value="1940"  >
                    1940        </option>
                <option value="1939"  >
                    1939        </option>
                <option value="1938"  >
                    1938        </option>
                <option value="1937"  >
                    1937        </option>
                <option value="1936"  >
                    1936        </option>
                <option value="1935"  >
                    1935        </option>
                <option value="1934"  >
                    1934        </option>
                <option value="1933"  >
                    1933        </option>
                <option value="1932"  >
                    1932        </option>
                <option value="1931"  >
                    1931        </option>
                <option value="1930"  >
                    1930        </option>
                <option value="1929"  >
                    1929        </option>
                <option value="1928"  >
                    1928        </option>
                <option value="1927"  >
                    1927        </option>
                <option value="1926"  >
                    1926        </option>
                <option value="1925"  >
                    1925        </option>
                <option value="1924"  >
                    1924        </option>
                <option value="1923"  >
                    1923        </option>
                <option value="1922"  >
                    1922        </option>
                <option value="1921"  >
                    1921        </option>
                <option value="1920"  >
                    1920        </option>
                <option value="1919"  >
                    1919        </option>
                <option value="1918"  >
                    1918        </option>
                <option value="1917"  >
                    1917        </option>
                <option value="1916"  >
                    1916        </option>
                <option value="1915"  >
                    1915        </option>
                <option value="1914"  >
                    1914        </option>
                <option value="1913"  >
                    1913        </option>
                <option value="1912"  >
                    1912        </option>
                <option value="1911"  >
                    1911        </option>
                <option value="1910"  >
                    1910        </option>
                <option value="1909"  >
                    1909        </option>
                <option value="1908"  >
                    1908        </option>
                <option value="1907"  >
                    1907        </option>
                <option value="1906"  >
                    1906        </option>
                <option value="1905"  >
                    1905        </option>
                <option value="1904"  >
                    1904        </option>
                <option value="1903"  >
                    1903        </option>
                <option value="1902"  >
                    1902        </option>
            </select>    </div>
        <div class="clear_both"></div>
    </div><div class="row_v3 gender_row control-group">
        <div class="col_container controls inline">
            <label class="radio inline ptn" for="male">
                <input type="radio" class="radio pln mtn" name="gender" id="male" value="M"   tabindex="11" />
                <span class="sex_label">Male</span>
            </label>
            <label class="radio inline ptn">
                <input type="radio" class="radio mtn" name="gender" id="female" value="F"  tabindex="12" />
                <span class="sex_label">Female</span>
            </label>
        </div>

</form>
</body>

</html>