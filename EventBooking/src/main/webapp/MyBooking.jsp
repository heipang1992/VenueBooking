<%-- 
    Document   : MyBooking
    Created on : May 10, 2023, 2:00:42 AM
    Author     : mahei
--%>

<%@page import="ict.bean.VenueBean"%>
<%@page import="ict.bean.BookingBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ict.db.BookingDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Booking</title>
        <%@include file="memberHeader.jsp" %>
    </head>
    <body>
        
        <h1>Check the processing booking record in the below table</h1>
        <%--<jsp:useBean id="cb" class="ict.bean.AccountBean" scope="session" />--%>

        
        <%
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");    
        BookingDB db = new BookingDB(dbUser, dbPassword, dbUrl);

        ArrayList<BookingBean> bookings = db.queryBookingByMemberEmail(cb.getEmail());
        BookingBean bb = bookings.get(0);
        VenueBean vb = db.queryVenueById(String.valueOf(bb.getVenueId()));
        String date = bb.getDate();
        // take the first 5 digits
        String startTime = bb.getStartTime();
        // take the last 5 digits
        String endTime = bookings.get(bookings.size()-1).getStartTime();
        int totalFee = bookings.size()*vb.getHourlyPrice();
        String isApproved ="";
        if (bb.getIsApproved()){
            isApproved ="Approved";
        }else{
            isApproved = "NOT Approved";
        }
        
        //HttpSession session = request.getSession(true);
        //session.setAttribute("bookingId", bb.getBookingId());
        request.getSession().setAttribute("memberEmail",cb.getEmail());
        request.getSession().setAttribute("bookingId",bb.getBookingId());
        %>
        <form action="EditGuestList.jsp" method="get">
            <table border="1">
                <tr><th>Venue</th><th>Date</th><th>Start Time</th><th>End Time</th><th>Total Fee</th><th>Status</th><th>Guest List</th></tr>
                <tr><td><%=vb.getName()%></td><td><%=date%></td>
                    <td><%=startTime.substring(0, 5)%></td>
                    <td><%=endTime.substring(8,13)%></td>
                    <td><%=totalFee%></td><td><%=isApproved%></td>
                    <td><input type="submit" name="guest" value="Edit Guest List"/></td>
                </tr>
            </table>
        </form>

    </body>
</html>
