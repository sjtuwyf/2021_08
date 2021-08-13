<%--
  Created by IntelliJ IDEA.
  User: ssqswyf
  Date: 2021/8/7
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>

    <h1>ssm_test</h1>
    <form action="/account/findAll" method="get" enctype="multipart/form-data">
<%--        file： <input type="file" name="upload"/><br/>--%>
        text:<input type="text" name="myText"/>
    hobby
    <input type="checkbox" name="hobby" value="1">1
    <input type="checkbox" name="hobby" value="2">2
    <input type="checkbox" name="hobby" value="3">3
    <input type="checkbox" name="hobby" value="4">4
    <input type="checkbox" name="hobby" value="5">5
    <br>
        <input type="submit" value="上传"/>
    </form>

</body>
</html>
