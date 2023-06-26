<%-- 
    Document   : CreateAccount
    Created on : 2023年5月2日, 下午7:07:42
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Hello This is Create Account Page!</h1>
        <form method="post" action="CreateAccount">
            User Name:<input type="text" name="name"><br/>
            Password:<input type="password" name="password"><br/>
            E-Mail<input type="email" name="email"><br/>
            Phone Number<input type="number" name="phone"><br/>  
            <input type="submit" name="submit" value="Submit">
        </form>
        <br/><a href="MainPage.jsp">Return to Main Page</a>
    </body>
</html>
