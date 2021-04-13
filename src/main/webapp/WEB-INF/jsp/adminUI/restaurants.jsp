<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<title>LunchPlacePicker</title>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.4/lib/noty.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js" defer></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/noty/3.1.4/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/adminUI/lunchplacepicker.restaurants.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/luncplacepicker.common.js" defer></script>

    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

</head>
<body>
<br>
<div class="container-fluid">
    <button class='addRestaurant' id="addNewRestBtn" style="offset-after: auto">Add Restaurant</button>
    <br>
    <br>
    <table id='restaurants_table' class="display">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>Registered</th>
            <th>Description</th>
            <th>Likes</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
    </table>
        <button id="allUsers">Users</button></a>
        <button id="mainPageBtn">Main page</button></a>
</div>

<%--RESTAURANT MODAL START--%>
<div class="container">
    <div class="modal fade" id="restaurantModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">Lunchplacepicker App</button>
                </div>
                <div class="modal-body">
                    <p>Enter restaurant's details</p>
                    <%--RESTAURANT FORM START--%>
                    <div class="container">
                        <form id="restaurantForm">
                            <input type="hidden" id="restaurantId" name="id">
                            <div class="form-group">
                                <label for="restaurantName">Name:</label>
                                <input type="text" class="form-control" , style="width: 35%" id="restaurantName" name="name">
                            </div>
                            <div class="form-group">
                                <label for="restaurantAddress">Address:</label>
                                <input type="text" class="form-control" , style="width: 35%" id="restaurantAddress" name="address">
                            </div>
                            <div class="form-group">
                                <label for="restaurantDescription">Description:</label>
                                <input type="text" class="form-control" , style="width: 35%" id="restaurantDescription" name="description">
                            </div>
                        </form>
                    </div>
                    <%--RESTAURANT FORM END--%>
                </div>
                <div class="modal-footer">
                    <button id="saveRestaurantBtn" type="button" class="btn btn-primary">Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                </div>
            </div>
        </div>
    </div>
</div>
<%--RESTAURANT MODAL END--%>
</body>
</html>