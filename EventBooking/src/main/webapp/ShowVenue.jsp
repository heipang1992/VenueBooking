<%-- 
    Document   : ShowVenue
    Created on : 2023年5月10日, 下午1:51:43
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
        <h1>This is Show Venue Page!</h1>
        <jsp:useBean id="list" class="java.util.ArrayList<VenueBean>" scope="request" />
     
                <table border="1">
                    <tr><th>Venue</th><th>Location</th><th>Person-in-charge</th><th>Booking Fee</th><th>Edit</th><th>Delete</th></tr>
            <%
            for (int i = 0; i<list.size() ; i++ ) {
               out.println("<tr><td>" + list.get(i).getName() + "</td><td>" + list.get(i).getAddress() + "</td><td>" + list.get(i).getPic() + "</td><td>" + list.get(i).getHourlyPrice() + "</td>" + 
               "<td><form acton='VenuePage' method='get'>" +
               "<input type='hidden' name='id' value='" + list.get(i).getVenueId() + "'/>" +
               "<input type='submit' name='submit' value='Edit'/>" +
               "</form></td>" +
               
               
               
               
               "<td><form acton='VenuePage' method='get'>" +
               "<input type='hidden' name='id' value='" + list.get(i).getVenueId() + "'/>" +
               "<input type='submit' name='submit' value='Delete'/>" +
               "</form></td>" +
               "</tr>");   
            }
            %>
        </table>
        <br/>
        <form method="get" action="VenuePage">
            <input type="submit" name="submit" value="Add"/>
        </form>
        <br/><a href="MainPage.jsp">Return to Main Page</a>
    </body>
</html>
