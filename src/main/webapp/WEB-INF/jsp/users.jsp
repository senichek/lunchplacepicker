<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<title>LunchPlace</title>
<head>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lunchplacepicker.admin.js" defer></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/luncplacepicker.common.js" defer></script>
</head>
<body>
</body>
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
</html>