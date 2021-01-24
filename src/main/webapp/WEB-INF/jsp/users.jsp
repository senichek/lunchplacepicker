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
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js" defer></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lunchplacepicker.admin.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/luncplacepicker.common.js" defer></script>
</head>
<body>
<br>
<div class="container-fluid">
    <button class='addUser' id="addNewUserBtn" style="offset-after: auto">Add User</button>
    <br>
    <br>
    <%--UPDATE USER MODAL START--%>
    <%--<div class="container">
        <div class="modal fade" id="UpdateUserModal" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">Lunchplacepicker App</button>
                    </div>
                    <div class="modal-body">
                        <p>Enter user's details</p>
                        &lt;%&ndash;USER UPDATE FORM START&ndash;%&gt;
                        <div class="container">
                            <form id="detailsForm">
                                &lt;%&ndash;<input type="hidden" id="id" name="id">&ndash;%&gt;
                                <div class="form-group">
                                    <label for="userName">Name:</label>
                                    <input type="text" class="form-control" , style="width: 35%" id="userName">
                                </div>
                                <div class="form-group">
                                    <label for="userEmail">Password:</label>
                                    <input type="text" class="form-control" , style="width: 35%" id="userEmail">
                                </div>
                                    <div class="form-group">
                                        <label for="role_admin">ADMIN</label>
                                        <input type="checkbox" id="roleAdmin" name="updRoles" value="ADMIN">
                                        <label for="role_user">USER</label>
                                        <input type="checkbox" id="roleUser" name="updRoles" value="USER">
                                    </div>
                            </form>
                        </div>
                        &lt;%&ndash;USER UPDATE FORM END&ndash;%&gt;
                    </div>
                    <div class="modal-footer">
                        <button id="saveUserBtn" type="button" class="btn btn-primary">Save</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>
                </div>

            </div>
        </div>
    </div>--%>
    <%--UPDATE USER MODAL END--%>
    <table id='users_table' class="display">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Registered</th>
            <th>Roles</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
    </table>
</div>

<%--ADD NEW USER MODAL START--%>
<div class="container">
    <div class="modal fade" id="userModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">Lunchplacepicker App</button>
                </div>
                <div class="modal-body">
                    <p>Enter user's details</p>
                    <%--ADD NEW USER FORM START--%>
                    <div class="container">
                        <form id="userForm">
                            <input type="hidden" id="userId" name="id">
                            <div class="form-group">
                                <label for="userName">Name:</label>
                                <input type="text" class="form-control" , style="width: 35%" id="userName" name="name">
                            </div>
                            <div class="form-group">
                                <label for="userEmail">Email:</label>
                                <input type="text" class="form-control" , style="width: 35%" id="userEmail" name="email">
                            </div>
                                <%--<div class="form-group">
                                    <label for="userPassword">Temporary password:</label>
                                    <input type="password" class="form-control" , style="width: 35%" id="userPassword" name="password">
                                </div>--%>
                                <div class="form-group">
                                    <label for="role_admin">ADMIN</label>
                                    <input type="checkbox" id="role_admin" name="roles" value="ADMIN">
                                    <label for="role_user">USER</label>
                                    <input type="checkbox" id="role_user" name="roles" value="USER">
                                </div>
                        </form>
                    </div>
                    <%--ADD NEW USER FORM END--%>
                </div>
                <div class="modal-footer">
                    <button id="saveUserBtn" type="button" class="btn btn-primary">Save</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                </div>
            </div>

        </div>
    </div>
</div>
<%--ADD USER MODAL END--%>
</body>
</html>