<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/12/2024
  Time: 1:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>View student details</title>
</head>
<body>
<div class="container">
    <h1 class="text-primary text-center mb-4">Student Details</h1>
    <p class="text-center">
        <a href="/students" class="btn btn-success">Back to student list</a>
    </p>
    <div class="card p-4 col-md-12 col-lg-6 mx-auto">
        <table class="table table-striped">
            <tr>
                <td>Name:</td>
                <td>${requestScope["student"].getName()}</td>
            </tr>
            <tr>
                <td>Class ID:</td>
                <td>${requestScope["student"].getClassId()}</td>
            </tr>
        </table>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
