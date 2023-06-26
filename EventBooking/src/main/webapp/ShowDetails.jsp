<%-- 
    Document   : ShowDetails
    Created on : 2023年5月10日, 下午1:21:07
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.GuestBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="list" class="java.util.ArrayList<GuestBean>" scope="request"/>
    <body>
        <h1>Hello This is Details Page!</h1>
        <table>
            
            
            <%
                if (list.size()==0) {
                out.print("<h1>No Guest</h1>");
                } else {
                    out.print("<h1>Member Email :" + list.get(0).getMemberEmail() + "</h1>");
                    out.print("<tr><th>Booking ID</th><th>Guest Name</th><th>Guest Email</th><th></th></tr>");
                for (int i=0; i<list.size(); i++) {
                    out.print("<tr><td>" + list.get(i).getBookingId() + "</td><td>" + list.get(i).getGuestName() + "</td><td>" + list.get(i).getGuestEmail() +  "</td></tr>");
                }
                }
            %>
        </table>
    </body>
</html>
