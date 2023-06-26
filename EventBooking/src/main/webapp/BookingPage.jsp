<%-- 
    Document   : BookingPage
    Created on : 2023年5月3日, 下午12:03:14
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.AccountBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
        <%@include file="memberHeader.jsp" %>
        <%@taglib uri="/WEB-INF/tlds/venue.tld" prefix="ict" %>

    </head>
    
      <%--<jsp:useBean id="cb" class="ict.bean.AccountBean" scope="session" />--%>

    <body>
        <br/><br/><label for="date">Pick a date</label>
        <form action="CheckBooking" method="GET" name="timeSlot">
            <input type="date" name="date">
            <select name="venueId">
                <option value="1">Sha Tin</option>
                <option value="2">Tsing Yi</option>
                <option value="3">Lee Wai Lee</option>
                <option value="4">Tseun Mun</option>
                <option value="5">Chai Wan</option>
            </select>
            <input type="submit" value="Check Availability"/>
        </form>
        </br></br>
        <ict:Venue  v1="photo/ShaTin.png" v2="photo/TsingYi.png" v3="photo/LeeWaiLee.png" v4="photo/TuenMun.png" v5="photo/ChaiWan.png" />
        
 

    </body>
</html>



