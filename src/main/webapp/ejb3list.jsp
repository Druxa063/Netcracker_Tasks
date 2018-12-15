<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Message</title>
</head>
<body>
    <form action="ejb3list">
        <input type="datetime-local" name="start">
        <input type="datetime-local" name="end">
        <input type="submit" value="Search">
    </form>
    <c:forEach items="${list}" var="massage">
        ${massage}<br>
    </c:forEach>
</body>
</html>
