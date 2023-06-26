<%-- 
    Document   : BookingList
    Created on : 2023年5月9日, 下午11:32:47
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ict.bean.BookingBean, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="list" scope="request" class="java.util.ArrayList<BookingBean>" />
    <body>
        <h1>Hello This is Booking List Page!</h1>
<%!    public String getApproved(Boolean isapproved) {
                if ( isapproved == true) {
                    return "Approved";
                } else {
                    return "Not Approved";
                    }
                }

        public String getVenue(int venue) {
         if (venue ==1) {
            return "Sha Tin Meeting Room";
        }
        else  if (venue ==2) {
            return "Tsing Yi Conference Room";
}
       else if (venue ==3) {
            return "Lee Wai Lee Classroom";
}
    else if (venue ==4) {
            return "Tuen Mun";
        }
        else{
            return "Chai Wan Dining Room";
        }
}

%>
        
        <%
            int bookingid, venueid;
            String date;
            String time;
            String email;
            Boolean available, isapproved;         
        %>
        <%
        out.print("<table border='1'>");
        out.print("<tr><th>Booking ID</th><th>Venue</th><th>Date</th><th>Time</th><th>Email</th><th>States</th><th>Details</th></tr>");
        for (int i = 0; i<list.size(); i++) {
            out.print("<tr><td>" + list.get(i).getBookingId() + "</td><td>" + getVenue(list.get(i).getVenueId()) + "</td><td>" + list.get(i).getDate() + "</td><td>" + list.get(i).getStartTime() + "</td><td>" + list.get(i).getMemberEmail() + "</td><td>" + "<a href='BookingList?action=approve&bookingid=" + list.get(i).getBookingId() + "'>" + getApproved(list.get(i).getIsApproved()) + "</a></td><td>"  + "<a href='BookingList?action=detail&bookingid=" + list.get(i).getBookingId() + "'>" + "Show Details" +"</a></td></tr>");  
            }
      
        out.print("</table>");
        %>
        <br/><a href="MainPage.jsp">Return to Main Page</a>
    </body>
</html>
