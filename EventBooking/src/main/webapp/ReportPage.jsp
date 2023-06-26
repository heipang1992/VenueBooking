<%-- 
    Document   : ReportPage
    Created on : 2023年5月10日, 下午5:21:33
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.BookingBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Report Page</title>
    </head>
    <body>
        
        <%!
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

        <h1>Hello This is Report Page!</h1>
        <h3>Show Report By Venue</h3>
        <form action="RecordPage" method="get" >
        <select name="select">
            <option value="1">Sha Tin Meeting Room</option>
            <option value="2"> Tsing Yi Conference Room</option>
            <option value="3">Lee Wai Lee Classroom</option>
            <option value="4">Tuen Mun</option>
            <option value="5">Chai Wan Dining Room</option>                
        </select>
        <input type="submit" name="action" value="List"/>
        </form>
        
        
    </body>
</html>
