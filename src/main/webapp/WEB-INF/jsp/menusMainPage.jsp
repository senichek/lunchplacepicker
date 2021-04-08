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
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lunchplacepicker.menuCards.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/luncplacepicker.common.js" defer></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

</head>
<body>
<br>
<div class="container-fluid">
    <a href="restaurants" class="btn btn-info float-left mr-1" id="menusBtn">Restaurants</a>

    <a class="btn btn-dark dropdown-toggle" href="#" role="button" id="sortByLikesDropDown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Sort by likes
    </a>
    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
        <a class="dropdown-item" href="menus?sort=desc" id="fromMoreToLess">From more to less</a>
        <a class="dropdown-item" href="menus?sort=asc" id="fromLessToMore">From less to more</a>
    </div>

    <jsp:include page="header.jsp"/>
    <br>
    <br>
       <div class="card-deck">
       </div>
</div>
</body>
</html>