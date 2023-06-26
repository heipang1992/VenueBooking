<%-- 
    Document   : EditVenue
    Created on : 2023年5月10日, 下午2:57:24
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.VenueBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello This is Edit Venue Page!</h1>
        <%
            VenueBean vb = (VenueBean)request.getAttribute("vb");
            out.print("<h1>The Venue Id is : " + vb.getVenueId() +"</h1>");
        %>
        <form method="get" action="VenuePage">
            Name : <input type="text" name="name" value="<%= vb.getName() %>" /><br/>
            Address : <input type="text" name="address" value="<%= vb.getAddress() %>" /><br/>
            Person In Charge : <input type="text" name="pic" value="<%= vb.getPic() %>" /><br/>
            Phone : <input type="text" name="phone" value="<%= vb.getPhone() %>" /><br/>
            Email : <input type="text" name="email" value="<%= vb.getEmail() %>" /><br/>
            Hourly Price : <input type="number" name="price" value="<%=  vb.getHourlyPrice() %>" /><br/>
            <input type="hidden" name="id" value="<%= vb.getVenueId() %>" />
           <input type="submit" name="submit" value="editsubmit" />

        </form>
    </body>
</html>
