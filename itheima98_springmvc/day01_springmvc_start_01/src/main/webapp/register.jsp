<%--
  Created by IntelliJ IDEA.
  User: ssqswyf
  Date: 2021/8/6
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/register" method="post">
        name<input type="text" name="name"><br>
        age<input type="text" name="age"><br>
        addr<input type="text" name="address"><br>
<%--        birthday<input type="text" name="birthday"><br>--%>
        hobby
        <input type="checkbox" name="hobby" value="1">1
        <input type="checkbox" name="hobby" value="2">2
        <input type="checkbox" name="hobby" value="3">3
        <input type="checkbox" name="hobby" value="4">4
        <input type="checkbox" name="hobby" value="5">5
        <br>
        <input type="submit" value="zhuce">
    </form>
</body>
</html>
