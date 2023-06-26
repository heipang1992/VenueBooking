<%-- 
    Document   : EditGuestList
    Created on : May 10, 2023, 3:43:10 AM
    Author     : mahei
--%>

<%@page import="ict.bean.BookingBean"%>
<%@page import="ict.bean.GuestBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="javax.persistence.Convert"%>
<%@page import="ict.db.BookingDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Guest List</title>
        <%@include file="memberHeader.jsp" %>
    </head>
    <body>
        <h1>I AM EDIT GUEST LIST PAGE</h1>
        <%! ArrayList<GuestBean> guests = new ArrayList(); %>
        
        <form action="?" method="GET">
            Guest Name:<input type="text" name="guestName"/></br>
            Guest Email:<input type="text" name="guestEmail"/></br>
            <input type="submit" value="Confirm"/>
        </form>
        <%
            if(request.getParameter("guestName")!= null){
           String guestName = request.getParameter("guestName");
           String guestEmail = request.getParameter("guestEmail");
           String memberEmail = cb.getEmail();
        
           //int bookingId = Integer.parseInt(request.getSession().getAttribute("bookingId").toString());
          
           
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");    
        BookingDB db = new BookingDB(dbUser, dbPassword, dbUrl);
        ArrayList<BookingBean> bookings = db.queryBookingByMemberEmail(memberEmail);
        int bookingId = bookings.get(0).getBookingId();
        
        
        boolean isAdded = db.addGuestList(bookingId, memberEmail, guestName, guestEmail);
        guests = db.getGuestListByBookingId_memberEmail(bookingId, memberEmail);
        
        
        out.println("<table border='1'><tr><th>Guest Name</th><th>Guest Email</th><th>Button</th></tr>");
        for(int i=0; i<guests.size();i++){
            out.println("<tr id="+i+"><td>"+guests.get(i).getGuestName()+"</td><td>"+
                        guests.get(i).getGuestEmail()+"</td>+" +
                        "<td><input type='submit'value='Delete' onclick='deleteguest("+i+")'></td></tr>");
        }
        out.println("</table>");
            }
        %>
    </body>
</html>
<script>
    function deleteguest(id){
        var guest = document.getElementById(id);
        guest.style.display = 'none';
    }
</script>

