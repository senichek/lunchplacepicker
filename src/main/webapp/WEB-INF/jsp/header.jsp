<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 07.03.2021
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="webjars/noty/3.1.4/demo/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/lib/noty.css"/>
    <script type="text/javascript" src="webjars/noty/3.1.4/lib/noty.min.js" defer></script>
</head>
<body>
<%--mr-1 - spacing between the buttons--%>
<a href="admin/users" class="btn btn-dark float-right mr-1" id="enterAsAdminBtn">Admin Profile</a>
<a href="profile/restaurants/all" class="btn btn-dark float-right mr-1" id="enterAsUserBtn">User Profile</a>
<a href="register" class="btn btn-info float-right mr-1" id="registerBtn">Register</a>
<a href="login" class="btn btn-info float-right mr-1" id="loginBtn">Login</a>
</body>
</html>
