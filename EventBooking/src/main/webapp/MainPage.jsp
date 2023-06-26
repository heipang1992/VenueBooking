<%-- 
    Document   : MainPage
    Created on : 2023年5月2日, 下午7:05:24
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Booking</title>
    </head>
    <body>
        <h1>Hello This is Main Page!</h1>
        <form method="post" action="LoginHandler">
            <input type="hidden" name="type" value="member"/>
            <input type="submit" value="Member Login" />
        </form>
        <br/>
        <br/>
        <form method="post" action="StaffLogin.jsp">
            <input type="hidden" name="type" value="staff"/>
            <input type="submit" value="Staff Login" />
        </form>
        <br/><br/><br/><br/><br/>
        <a href="CreateAccount.jsp">Create Member Account</a>
    </body>
</html>
