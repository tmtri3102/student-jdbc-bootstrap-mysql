<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/12/2024
  Time: 2:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Delete</title>
  </head>
  <body>
  <div class="container py-4">
    <h1 class="py-4">Delete this student?</h1><p>
    <a class="btn btn-light" href="/students">Back to student list</a>
    <form method="post" class="d-flex flex-column gap-3" style="max-width: 300px">
    <table class="table table-bordered table-hover">
      <tr>
        <td>Name</td>
        <td>Class ID</td>
      </tr>
      <tr>
        <td>${requestScope["student"].getName()}</td>
        <td>${requestScope["student"].getClassId()}</td>
      </tr>
    </table>
    <input class="btn btn-outline-danger btn-sm" type="submit" value="Delete">
  </form>


  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
          crossorigin="anonymous"></script>
  </body>
</html>
