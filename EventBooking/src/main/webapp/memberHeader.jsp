<%-- 
    Document   : memberHeader
    Created on : May 10, 2023, 12:57:34 AM
    Author     : mahei
--%>

<%@page import="ict.bean.AccountBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>complete responsive hotel booking website design tutorial</title>

<!--   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css" />-->

   <!-- font awesome cdn link  -->
   <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">-->

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/style.css">

</head>
<body>
   
<!-- header section starts  -->

<section class="header">
    
    <jsp:useBean id="cb" class="ict.bean.AccountBean" scope="session" />
    
        <%
            String name ="Login";
            if(cb!=null){
                name = cb.getName();
            }
        %> 
        
   <div class="flex">
       <a href="MainPage.jsp" class="logo">Event Point Limited</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="MainPage.jsp" class="btn" ><%=name%></a>&nbsp;&nbsp;&nbsp;&nbsp;
      <div id="menu-btn" class="fas fa-bars"></div>&nbsp;&nbsp;&nbsp;&nbsp;
   </div>

   <nav class="navbar">
      <a href="MyBooking.jsp">Processing Booking</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="BookingPage.jsp">Check Venue</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="EditGuestList.jsp">Update Guest List</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="#gallery">Previous Booking</a>
   </nav>

</section>

</body>
</html>
