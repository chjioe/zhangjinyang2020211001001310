<%--
  Created by IntelliJ IDEA.
  User: zjy
  Date: 2022/5/11
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>

<form method="Post" action="register">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender:<br/> <input type="radio" name="gender" value="male"/>Male <input type="radio" name="gender" value="female"/>Female<br/>
    Date of Birth :<input type="text" name="birthdate"/><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
