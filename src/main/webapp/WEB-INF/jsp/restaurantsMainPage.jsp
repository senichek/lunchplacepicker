<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<title>LunchPlacePicker</title>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="${pageContext.request.contextPath}/">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lunchplacepicker.restaurantCards.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/luncplacepicker.common.js" defer></script>

</head>
<body>
<br>
<div class="container-fluid">
    <%--mr-1 - spacing between the buttons--%>
        <a href="login" class="btn btn-dark float-right mr-1" id="enterAsUserBtn">Enter as User</a>
        <a href="login" class="btn btn-dark float-right mr-1" id="enterAsAdminBtn">Enter as Admin</a>
        <a href="register" class="btn btn-info float-right mr-1" id="enterAsAdminBtn">Register</a>
    <br>
    <br>
       <div class="card-deck">

       </div>
</div>
</body>
</html>