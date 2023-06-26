<%-- 
    Document   : ManagerPage
    Created on : 2023年5月3日, 下午1:31:36
    Author     : USER
--%>

<%@page import="ict.db.BookingDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.StaffBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager</title>
    </head>
    <body>
        <%
        StaffBean sb = (StaffBean)request.getAttribute("StaffBean");
        if (sb != null) {
            out.println("<h1>Welcome! " + sb.getName() + "</h1>");
        } else {
           out.println("<h1>Welcome!</h1>");
        }
            String dbUser = this.getServletContext().getInitParameter("dbUser");
            String dbPassword = this.getServletContext().getInitParameter("dbPassword");
            String dbUrl = this.getServletContext().getInitParameter("dbUrl");  
            BookingDB db = new BookingDB(dbUser, dbPassword, dbUrl);
            boolean result = db.checkUnavailableBooking();
        
        %>
        <h1>Hello This is Manager Page!</h1>
    <a href="MemberListHandler">Show Account List</a><br/>
    <br/><a href="BookingList?action=list">Show Booking List</a> <br/>
    <% if(result){%>
    New Booking that are not checked!!
    <%}%>
    
    <br/><a href="VenuePage?action=list">Show Venue Page</a><br/>
    <br/><a href="RecordPage?action=list">Show Report</a><br/>
   
    <br/><a href="CsvJdbcFile.jsp">Export all booking record to csv format</a>
    <br/>
     <br/><a href="MainPage.jsp">Return to Main Page</a><br/>
    </body>
</html>
