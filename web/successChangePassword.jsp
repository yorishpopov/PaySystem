<%@ page import="ru.home.dao.User" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 21.06.16
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Change Password</title>
    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="login-page">
    <div class="form">
        <p class="textSuccess">Пароль успешно изменен!!!</p>
        <%User user = (User) session.getAttribute("user");
        if (user.getRoleId().equals("RES")){%>
            <form action="residentPage.jsp" method="post">
                <input type="submit" name="return" value="ОК"/>
            </form>
        <%}%>
        <%if (user.getRoleId().equals("ADM")){%>
            <form action="adminPage.jsp" method="post">
                <input type="submit" name="return" value="ОК"/>
            </form>
        <%}%>
    </div>
</div>
</body>
</html>
