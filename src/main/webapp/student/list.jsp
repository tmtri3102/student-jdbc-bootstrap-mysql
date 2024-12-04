<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/12/2024
  Time: 11:50 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Student List</title>
</head>
<body>
<div class="container">
<h1>All Students</h1>
<a href="/students?action=create">Create a student</a>
<table  class="table-responsive table-bordered table-light table-striped table-hover">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Class ID</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["students"]}' var="student">
        <tr>
            <td>${student.getId()}</td>
            <td><a href="/students?action=view&id=${student.getId()}">${student.getName()}</a></td>
            <td>${student.getClassId()}</td>
            <td><button><a href="/students?action=update&id=${student.getId()}">Update</a></button></td>
            <td><button><a href="/students?action=delete&id=${student.getId()}">Delete</a></button></td>
        </tr>
    </c:forEach>

</table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
