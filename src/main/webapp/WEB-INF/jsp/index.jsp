<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <base href="${pageContext.request.contextPath}/">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark py-0">
    <div class="container">
        <a href="restaurants" class="navbar-brand"><img src="resources/images/icon_meal.png"> Lunch Place Picker </a>
        <a href="restaurants" class="btn btn-primary float-right mr-1" id="enterAsUserBtn">Main page</a>
        <a href="register" class="btn btn-info float-right mr-1" id="registerBtn">Register</a>
        <a href="login" class="btn btn-info float-right mr-1" id="loginBtn">Login</a>
        <div class="collapse navbar-collapse" id="navbarNav">
        </div>
    </div>
</nav>
<div class="jumbotron">
    <div class="container">
        <div class="lead py-4">
            <b>Application stack:</b>
            <br>
            <a href="http://projects.spring.io/spring-security/">Spring Security</a>,
            <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Spring MVC</a>,
            <a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>,
            <a href="https://spring.io/projects/spring-restdocs">Spring REST Docs</a>,
            <a href="http://spring.io/blog/2014/05/07/preview-spring-security-test-method-security">Spring Security
                Test</a>,
            <a href="http://hibernate.org/orm/">Hibernate ORM</a>,
            <a href="http://hibernate.org/validator/">Hibernate Validator</a>,
            <a href="http://www.slf4j.org/">SLF4J</a>,
            <a href="https://github.com/FasterXML/jackson">Json Jackson</a>,
            <a href="http://ru.wikipedia.org/wiki/JSP">JSP</a>,
            <a href="http://en.wikipedia.org/wiki/JavaServer_Pages_Standard_Tag_Library">JSTL</a>,
            <a href="http://tomcat.apache.org/">Apache Tomcat</a>,
            <a href="http://datatables.net/">DataTables plugin</a>,
            <a href="http://www.postgresql.org/">PostgreSQL</a>,
            <a href="http://junit.org/">JUnit</a>,
            <a href="http://jquery.com/">jQuery</a>,
            <a href="http://getbootstrap.com/">Bootstrap</a>.
        </div>
    </div>
</div>
<div class="container">
    <div class="lead py-4">
        <p class="lead">
            <b> Project description: a voting system for deciding where to have lunch.</b>
            <br>
            2 types of users: admin and regular users.
            Admin can input a restaurant and it's lunch menu of the day.
            Menu changes each day (admins do the updates).
            Users can vote at which restaurant they want to have lunch. Only one vote counted per user (one unique vote
            per user). If a user votes again the same day:
            <br>
            - if it is before 11:00 A.M. we assume that a user changed his mind;
            <br>
            - if it is after 11:00 A.M. then it is too late, vote can't be changed;
            <br>
            Each restaurant provides a new menu each day.
        </p>
        <p class="lead">
            <a class="btn btn-success btn-lg" href="api-doc" role="button">REST API Documentation</a>
        </p>
    </div>
</div>
</body>
</html>