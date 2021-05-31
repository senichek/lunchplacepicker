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
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="webjars/noty/3.1.4/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/userUI/lunchplacepicker.userRegistration.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/luncplacepicker.common.js" defer></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

</head>
<body>
<form class="form-signin" id="signUpForm">
    <h2 class="form-signin-heading">Please sign up</h2>
    <p>
        <label for="username" class="sr-only">Username</label>
        <input type="text" id="userName" name="username" class="form-control"
               placeholder="Username" required autofocus>
    </p>
    <p>
        <label for="userEmail" class="sr-only">Useremail</label>
        <input type="text" id="userEmail" name="email" class="form-control"
               placeholder="Email" required autofocus>
    </p>
    <p>
        <label for="userPassword" class="sr-only">Password</label>
        <input type="password" id="userPassword" name="password" class="form-control"
               placeholder="Password" required>
    </p>
    <p>
        <label for="userPasswordConfirmation" class="sr-only">Password</label>
        <input type="password" id="userPasswordConfirmation" name="password" class="form-control"
               placeholder="Confirm Password" required>
    </p>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <button class="btn btn-lg btn-primary btn-block" type="button" id="registerBtn">Sign Up</button>
    <button class="btn btn-lg btn-dark btn-block" type="button" id="backToIndexBtn">Back to Index</button>
    <%--By assigning the button <type="button"> we override the standard button behavior in the <form>
    and preventing the form from reloading when the button is clicked.--%>
</form>
</body>
</html>