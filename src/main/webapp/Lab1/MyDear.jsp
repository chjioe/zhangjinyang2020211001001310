<%--
  Created by IntelliJ IDEA.
  User: zjy
  Date: 2022/5/18
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyDear</title>
</head>
<body>
<h4>
    name:<%=request.getParameter("name")%><br>
    submit:<%=request.getParameter("submit")%><br>
    class:<%=request.getParameter("class")%><br>
    id:<%=request.getParameter("ID")%><br>

</h4>

</body>
</html>
