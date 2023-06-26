<%-- 
    Document   : Login
    Created on : 2023年5月2日, 下午7:05:56
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.AccountBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
        AccountBean cb = (AccountBean)request.getAttribute("AccountBean");
        if (cb != null) {
            out.println("<h1>Welcome! " + cb.getName() + "</h1>");
        } else {
            out.println("<h1>Hello This is Login Page</h1>");
        }  
        %>          
        <h2>Login :</h2>
        <form method=post action="LoginHandler"/>
        E-Mail <input type="email" name="email"/><br/>
        Password <input type="password" name="password"/><br/><br/>
        <input type="hidden" name="type" value="member"/>
        <input type="hidden" name="action" value="authenticate" />
        <input type="submit" name="submit" value="Login"/><br/><br/>

        </form>
        <a href="CreateAccount.jsp">Create Member Account</a>
        <br/><a href="MainPage.jsp">Return to Main Page</a>
    </body>
</html>
