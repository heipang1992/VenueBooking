<%-- 
    Document   : StaffLogin
    Created on : 2023年5月3日, 下午1:43:32
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Login</title>
    </head>
    <body>
        <h1>Hello This is Staff Login Page!</h1>
        <form method=post action="LoginHandler"/>
        Name <input type="text" name="name"/><br/>
        Password <input type="password" name="password"/><br/><br/>
        <input type="hidden" name="type" value="staff"/>
        <input type="submit" name="submit" value="Login"/><br/><br/>
        </form>
        <br/><a href="MainPage.jsp">Return to Main Page</a>
    </body>
</html>
