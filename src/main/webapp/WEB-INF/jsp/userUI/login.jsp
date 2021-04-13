<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<title>LunchPlacePicker</title>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="${pageContext.request.contextPath}/">

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous"/>
    <link rel="stylesheet" href="webjars/noty/3.1.4/lib/noty.css"/>
    <script type="text/javascript" src="webjars/noty/3.1.4/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/luncplacepicker.common.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/userUI/lunchplacepicker.logInOnClick.js" defer></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

</head>
<body>
<br>
<body>
<div class="container">
    <form class="form-signin" id="loginForm" method="post" action="/lunchplacepicker/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <p>
            <label for="username" class="sr-only">Username</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
            <label for="password" class="sr-only">Password</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" id="loginBtn" type="submit">Log in</button>
        <button class="btn btn-lg btn-dark btn-block" id="enterAsAdminBtn" type="submit">Admin</button>
        <button class="btn btn-lg btn-dark btn-block" id="enterAsUserBtn" type="submit">User</button>
    </form>
</div>
</body>




<%--<div class="row centered-form">
    <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title text-center"> <b>Please Sign Up</b> </h3>
            </div>
            <div class="panel-body">
                <form role="form">

                    <div class="form-group">
                        <input type="text" name="name" id="userName" class="form-control input-sm"
                               placeholder="Username">
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" id="userEmail" class="form-control input-sm"
                               placeholder="Email Address">
                    </div>

                    <div class="row">
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="password" name="password" id="userPassword" class="form-control input-sm"
                                       placeholder="Password">
                            </div>
                        </div>
                        <div class="col-xs-6 col-sm-6 col-md-6">
                            <div class="form-group">
                                <input type="password" name="password_confirmation" id="userPassword_confirmation"
                                       class="form-control input-sm" placeholder="Confirm Password">
                            </div>
                        </div>
                    </div>

                    <input type="submit" id="registerBtn" value="Register" class="btn btn-info btn-block">
                </form>
            </div>
        </div>
    </div>
</div>--%>
</body>
</html>