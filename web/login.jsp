<%--
  Created by IntelliJ IDEA.
  User: Liana
  Date: 2/24/2018
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body style="background-color: cadetblue">



<div style="background-color: blue;  margin-top: 200px; width: 300px;height: 300px; float: left;margin-left: 20px">
  <div id="errorMessageLogin" style="color: red"></div>
  <form id="loginForm" action="/showUserServlet" onsubmit="event.preventDefault(); checkLogin()">
    <input id="userEmail" type="email" placeholder="input your email" name="userEmail"/><br>
    <input id="userPassword" type="password" placeholder="input your password" name="userPassword"/>
    <input type="submit" value="Login">
  </form>

</div>

<div style="background-color: blue; margin-top: 200px; width: 300px;height: 300px; float:left;margin-left: 20px">
  <div id="errorMessageRegister" style="color: red"></div>

  <form id="registerForm"  action="/registerServlet" method="post" enctype="multipart/form-data">

    <input id="name" type="text" placeholder="input your name" name="name"/>
    <input id="surname" type="text" placeholder="input your surname" name="surname"/>
    <input id="email" type="email" placeholder="input your email" name="email"/>
    <input id="password" type="password" placeholder="input your password" name="password"/>
    <input id="picUrl" type="file" name="picture"/>

    <input type="submit" value="Register">
  </form>

</div>



<script>
    function checkLogin() {
        var email = document.getElementById("userEmail").value;
        var password = document.getElementById("userPassword").value;
        var err = "";
        if (email == "") {
            err += "Please input email <br>";
        }
        if (password == "") {
            err += "Please input password <br>";
        }

        if (err != "") {
            document.getElementById("errorMessageLogin").innerHTML = err;
        } else {
            document.getElementById("loginForm").submit();
        }
    }

    function checkRegister() {
        var name= document.getElementById("name").value;
        var surname = document.getElementById("surname").value;
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var picUrl = document.getElementById("picUrl").value;
        var err = "";
        if (name == "") {
            err += "Please input name <br>";
        }

        if (surname == "") {
            err += "Please input surname <br>";
        }

        if (email== "") {
            err += "Please input email <br>";
        }

        if (password == "") {
            err += "Please input password <br>";
        }
        if (picUrl == "") {
            err += "Please choose picture <br>";
        }

        if (err != "") {
            document.getElementById("errorMessageRegister").innerHTML = err;
        } else {
            document.getElementById("registerForm").submit();
        }
    }

</script>
</body>
</html>