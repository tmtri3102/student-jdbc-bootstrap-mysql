<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<div class="container py-4">
<h1 class="py-4">Edit student</h1>
<p>
    <a class="btn btn-light" href="/students">Back to student list</a>
</p>
<form method="post" class="d-flex flex-column gap-3" style="max-width: 300px">
    <input class="form-control" type="text" name="name" id="name" value="${requestScope["student"].getName()}">
    <input class="form-control" type="text" name="class_id" id="class_id" value="${requestScope["student"].getClassId()}">
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span>
        </c:if>
    </p>
    <input class="btn btn-outline-primary btn-sm" type="submit" value="Update student">
</form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

</body>
</html>
