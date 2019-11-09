<%--
  Created by IntelliJ IDEA.
  User: ASUS-PC
  Date: 2019/8/22
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/testFileUpload" enctype="multipart/form-data">
    desc<input type="text" name="desc"><p></p>
    file<input type="file" name="file">
    <input type="submit">
</form>
</body>
</html>
