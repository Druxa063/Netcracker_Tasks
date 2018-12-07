<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
    <form method="post" action="jdbcServlet">
        <input type="number" name="empno" value="${emp.empno}" hidden/><br>
        Ename : <input type="text" name="ename" value="${emp.ename}"/><br>
        Job : <input type="text" name="job" value="${emp.job}"/><br>
        Manager : <input type="number" name="mgr" value="${emp.mgr}"/><br>
        Hire date : <input type="date" name="hiredate" value="${emp.hireDate}"/><br>
        Salary : <input type="number" name="salary" value="${emp.salary}"/><br>
        Commission : <input type="number" name="comm" value="${emp.comm}"/><br>
        Number department : <input type="number" name="deptno" value="${emp.dept.deptno}"/><br>
        <input type="submit" value="Submit"/>
    </form>
    <br/>

    <form method="get" name="findWorker" action="jdbcServlet?action=find">
        Number Worker : <input type="text" name="numberWorker">
        <button onclick="checkNumber();">Submit</button>
    </form>
    <br/>

    <table border="1">
        <thead>
            <th>EmpNO</th>
            <th>Ename</th>
            <th>Job</th>
            <th>Manager</th>
            <th>Hire date</th>
            <th>Salary</th>
            <th>Commission</th>
            <th>Number department</th>
            <th>Dept name</th>
            <th>Location</th>
            <th>Delete</th>
            <th>Update</th>
        </thead>
        <tbody>
            <c:forEach items="${emps}" var="emp">
                <jsp:useBean id="emp" scope="page" type="jdbc.model.Employee"/>
                <tr>
                    <td>${emp.empno}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.job}</td>
                    <td><a href="jdbcServlet?action=find&id=${emp.mgr}">${emp.mgr}</a></td>
                    <td>${emp.hireDate}</td>
                    <td>${emp.salary}</td>
                    <td>${emp.comm}</td>
                    <td>${emp.dept.deptno}</td>
                    <td>${emp.dept.dname}</td>
                    <td>${emp.dept.loc}</td>
                    <td><a href="jdbcServlet?action=delete&id=${emp.empno}">Delete</a></td>
                    <td><a href="jdbcServlet?action=update&id=${emp.empno}">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
<script language="javascript" type="text/javascript">
    function checkNumber() {
        var x = document.findWorker.numberWorker.value;
        var patt = /\w/g;
        if (patt.test(x)) {
            alert("необходимо ввести число");
            return false;
        }
        document.findWorker.submit();
    }
</script>
</html>
