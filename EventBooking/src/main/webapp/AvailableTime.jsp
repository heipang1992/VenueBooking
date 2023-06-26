<%-- 
    Document   : AvailableTime
    Created on : May 6, 2023, 5:06:43 PM
    Author     : mahei
--%>

<%@page import="java.util.*, ict.bean.BookingBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Time Slot</title>
        <%@include file="memberHeader.jsp" %>
    </head>
    <body>
        <%
        //ArrayList<BookingBean> book_list = new ArrayList();
        ArrayList<BookingBean> book_list = (ArrayList<BookingBean>)request.getSession().getAttribute("BookingsBean");
        if (book_list != null) {
            out.println("<h1>This is the available time slot on  " + book_list.get(0).getDate() + "</h1>");
            out.println("<form action='RequestBookingHandler' method='post'>");
            out.println("<table><tr><th>Time</th><th>Book</th></tr>");
            for (int i=0;i<book_list.size();i++){
                String startTime = book_list.get(i).getStartTime();
                out.println("<tr><td>"+startTime + "<td>");
                out.println("<td><input type='checkbox' name='checkAll' value='"+startTime+"'/></td></tr>");
            }
            out.println("</table>");
            out.println("<input type='submit' value='Request'/></form>");
        } else {
            out.println("<h1>No Available Time Slot. Please check the other date</h1>");
        }  
        %>   

    </body>
</html>
