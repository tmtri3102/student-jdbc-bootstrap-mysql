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
  <h1>Delete?</h1>
  <form method="post">
    <fieldset>
      <legend>Student information</legend>
      <table>
        <tr>
          <td>Name: </td>
          <td>${requestScope["student"].getName()}</td>
        </tr>
        <tr>
          <td>Description: </td>
          <td>${requestScope["student"].getDescription()}</td>
        </tr>
        <tr>
          <td>Price: </td>
          <td>${requestScope["student"].getPrice()}</td>
        </tr>
        <tr>
          <td><input type="submit" value="Delete student"></td>
          <td><a href="/students">Back to student list</a></td>
        </tr>
      </table>
    </fieldset>
  </form>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
          crossorigin="anonymous"></script>
  </body>
</html>
