<%-- 
    Document   : StaffPage
    Created on : 2023年5月3日, 下午1:31:44
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.StaffBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff</title>
    </head>
    <body>
        <%
        StaffBean sb = (StaffBean)request.getAttribute("StaffBean");
        if (sb != null) {
            out.println("<h1>Welcome! " + sb.getName() + "</h1>");
        } else {
           out.println("<h1>Welcome!</h1>");
        }              
        %>        
        
        <h1>Hello This is Staff Page!</h1>
        <br/><a href="MainPage.jsp">Return to Main Page</a>
    </body>
</html>
