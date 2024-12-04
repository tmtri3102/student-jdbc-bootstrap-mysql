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

    <title>Product List</title>
</head>
<body>
<h1>All Products</h1>
<a href="/products?action=create">Create a product</a>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Price</td>
        <td>Update</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()}">${product.getName()}</a></td>
            <td>${product.getDescription()}</td>
            <td>${product.getPrice()}</td>
            <td><button><a href="/products?action=update&id=${product.getId()}">Update</a></button></td>
            <td><button><a href="/products?action=delete&id=${product.getId()}">Delete</a></button></td>
        </tr>
    </c:forEach>

</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
