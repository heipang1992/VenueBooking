<%-- 
    Document   : EditAccount
    Created on : 2023年5月5日, 下午10:58:28
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello This is Edit Page!</h1>
        
        <jsp:useBean id="cb" scope="request" class="ict.bean.AccountBean"  /> 
        <%
            String name = cb.getName() !=null? cb.getName() : "";
            String password = cb.getPassword() !=null? cb.getPassword() : "";
            String email = cb.getEmail() !=null? cb.getEmail() : "";
            String phone = cb.getPhone() !=null? cb.getPhone() : "";
        %>

        <form  method=“get" action="HandleAccount">
            <input type="hidden" name="action"  value="confirmEdit" />
            Name <input name="name"  type="text" value="<%= name %>"/> <br>
            Password <input name="password"  type="password" value="<%= password %>"/> <br>
            Email <input name="email"  type="email" value="<%= email %>"/> <br>
            Phone <input name="phone"  type="text" value="<%= phone %>"/> <br>
            <td ><input type="submit" value="submit"/> <br>
   </form>        
    </body>
    <br/><a href="MainPage.jsp">Return to Main Page</a>
</html>
