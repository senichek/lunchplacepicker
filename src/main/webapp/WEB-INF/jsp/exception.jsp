<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 05.04.2021
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${errorMessages}" var="errors">
    ${errors}
    <br>
</c:forEach>