<%--
  Created by IntelliJ IDEA.
  User: ismail
  Date: 1/17/21
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/start" method="post">
    <input type="text" name="username">
    <input type="submit" value="Login">
</form>
</body>
</html>
