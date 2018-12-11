<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Message Bean</title>
</head>
<body>
    <form method="post">
        <input type="text" name="text">
        <input type="submit" value="Send">
    </form>
    <br>
    <c:forEach items="${messages}" var="massage">
        ${massage}<br>
    </c:forEach>
</body>
</html>
