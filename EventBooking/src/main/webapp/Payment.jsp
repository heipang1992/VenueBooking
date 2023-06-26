<%-- 
    Document   : AvailableTime
    Created on : May 6, 2023, 5:06:43 PM
    Author     : mahei
--%>

<%@page import="ict.bean.VenueBean"%>
<%@page import="java.util.*, ict.bean.BookingBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
        <%@include file="memberHeader.jsp" %>
    </head>
    <body>
                <%
        //ArrayList<BookingBean> book_list = new ArrayList();
        String[] checkedTime = (String[])request.getAttribute("checkedTime");
        VenueBean vb = (VenueBean)request.getSession().getAttribute("VenueBean");
        //int totalFee = Integer.parseInt((String)request.getAttribute("totalFee"));
        //ArrayList<BookingBean> book_list = (ArrayList<BookingBean>)request.getSession().getAttribute("BookingsBean");
        //BookingBean book = new BookingBean();
        //book = book_list.get(0);
        int totalFee = checkedTime.length * vb.getHourlyPrice();
        
        if (checkedTime != null) {
            out.println("<h1>Please follow the instruction for payment</h1>");
            out.println("FPS No: 55440221   Name: IVE International Limited");
            out.println("<h3>Booking Detail:</h3>");
            out.println("<form action='MemberConsole.jsp' method='get'><table><tr><td>Venue</td><td>"+ vb.getName() +  "</td></tr>");
            out.println("<tr><td>TimeSlot</td><td>");
            for (int i=0;i<checkedTime.length;i++){
                String time = checkedTime[i];
                out.println("<div>"+time+"</div>");
            }
            out.println("</td></tr>");
            out.println("<tr><td>Total Fee</td><td> $" + totalFee + "</td></tr></table></br>");
            out.println("Please upload the Payment Recipt </br><input type='file' value='Upload Receipt'/></br></br>");
            out.println("<input type='submit' value='Submit' onclick='promptMsg()'/></form>");
        } else {
            out.println("<h1>No Available Time Slot. Please check the other date</h1>");
        }  
        %> 

    </body>
</html>

<script>
    function promptMsg(){
        alert("The request is sent to the manager. Please wait 24 hours for the approval of venue. You can edit the guest list first.");
        //location.href = "/MemberConsole.jsp";
    }
    
</script>
