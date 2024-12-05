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
<div class="container py-4">
    <h1 class="py-4">All Students</h1>
    <form action="/students" method="post" class="d-flex pb-4">
        <input type="hidden" name="action" value="search">
        <input type="text" name="name" class="form-control me-2" placeholder="Search student">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <table class="table table-bordered">
        <tr>
            <td>Class ID</td>
            <td>Class Name</td>
<%--            <td colspan="2">Actions</td>--%>
        </tr>
        <c:forEach items='${requestScope["classes"]}' var="clazz">
            <tr>
                <td>${clazz.getId()}</td>
                <td>${clazz.getName()}</td>
            </tr>
        </c:forEach>
    </table>

    <br>

    <table class="table table-bordered">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Class ID</td>
            <td colspan="2">Actions</td>
        </tr>
        <c:forEach items='${requestScope["students"]}' var="student">
            <tr>
                <td>${student.getId()}</td>
                <td><a class="text-black text-decoration-none" href="/students?action=view&id=${student.getId()}">${student.getName()}</a></td>
                <td><a class="text-black text-decoration-none" href="/students?action=view&id=${student.getId()}">${student.getClassId()}</a></td>
                <td><a class="text-primary text-decoration-none"  href="/students?action=update&id=${student.getId()}">Update</a></td>
                <td><a class="text-danger text-decoration-none"  href="/students?action=delete&id=${student.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <a class="btn btn-primary text-white" href="/students?action=create">Add a student</a>
    </p>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
