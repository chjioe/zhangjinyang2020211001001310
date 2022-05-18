<%--
  Created by IntelliJ IDEA.
  User: zjy
  Date: 2022/5/18
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyJsp</title>
</head>
<body>
<h1>
    i am MyJsp.jsp
</h1>
<form method="post" action=<%=request.getContextPath()%>/Lab1/MyDear.jsp>
    name<input type="text" name="name"/><br/>
    class<input type="text" name="class"/><br/>
    ID<input type="text" name="ID"/><br/>
    <input type="submit" value="Send data to server" name="submit"/>
</form>
</body>
</html>
