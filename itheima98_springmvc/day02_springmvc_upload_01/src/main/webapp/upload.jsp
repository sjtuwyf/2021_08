<%--
  Created by IntelliJ IDEA.
  User: ssqswyf
  Date: 2021/8/7
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
    <h1>一,springmvc传统方式文件上传</h1>
    <form action="/file/upload" method="post" enctype="multipart/form-data">
        图片： <input type="file" name="upload"/><br/>
        图片描述:<input type="text" name="pdesc"/>
        <input type="submit" value="上传"/>
    </form>

</body>
</html>
