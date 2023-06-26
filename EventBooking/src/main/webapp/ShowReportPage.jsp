<%-- 
    Document   : ShowReportPage
    Created on : 2023年5月10日, 下午6:08:40
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.BookingBean, ict.bean.VenueBean" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="list" scope="request" class="java.util.ArrayList<BookingBean>" />
        <jsp:useBean id="vb" scope="request" class="ict.bean.VenueBean" />
                     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello This is Show Report Page!</h1>
   
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
   
 public int m1=0,m2=0,m3=0,m4=0,m5=0,m6=0,m7=0,m8=0,m9=0,m10=0,m11=0,m12=0;
%>      

                <%
                    
        out.print("<table border='1'>");
        out.print("<tr><th>Booking ID</th><th>Venue</th><th>Date</th><th>Time</th><th>Email</th></tr>");
        for (int i = 0; i<list.size(); i++) {
            out.print("<tr><td>" + list.get(i).getBookingId() + "</td><td>" + getVenue(list.get(i).getVenueId()) + "</td><td>" + list.get(i).getDate() + "</td><td>" + list.get(i).getStartTime() + "</td><td>" + list.get(i).getMemberEmail() + "</td></tr>");  
            String month = list.get(i).getDate();

            if ( month.startsWith("2023-01")) {
                m1++;
                    }
                               else if ( month.startsWith("2023-02")) {
                m2++;
                    }            else if ( month.startsWith("2023-03")) {
                m3++;
                    }            else if ( month.startsWith("2023-04")) {
                m4++;
                    }            else if ( month.startsWith("2023-05")) {
                m5++;
                    }           else  if ( month.startsWith("2023-06")) {
                m6++;
                    }            else if ( month.startsWith("2023-07")) {
                m7++;
                    }           else  if ( month.startsWith("2023-08")) {
                m8++;
                    }            else if ( month.startsWith("2023-09")) {
                m9++;
                    }            else if ( month.startsWith("2023-10")) {
                m10++;
                    }else if ( month.startsWith("2023-11")) {
                m11++;
                    }else if ( month.startsWith("2023-12")) {
                m12++;
                    }
                    
                    
                    
                    
            }
      
        out.print("</table>");
        %>
 
        <h3>Monthly Booking Rate :</h3> <%

out.println("January : " + m1 +" times <br/>");
out.println("February : " + m2 +" times <br/>");
out.println("March : " + m3 +" times <br/>");
out.println("April : " + m4 +" times <br/>");
out.println("May : " + m5 +" times <br/>");
out.println("June : " + m6 +" times <br/>");
out.println("July : " + m7 +" times <br/>");
out.println("August : " + m8 +" times <br/>");
out.println("September : " +m9 +" times <br/>");
out.println("October : " + m10 +" times <br/>");
out.println("November : " + m11 +" times <br/>");
out.println("December : " + m12 +" times <br/>");
%> 
<canvas id="canvas"></canvas>


 <h3>Monthly Income :</h3>
 <%
out.println("January : $ " + m1*vb.getHourlyPrice() +"<br/>");
out.println("February : $ " + m2*vb.getHourlyPrice() +"<br/>");
out.println("March : $ " + m3*vb.getHourlyPrice() +"<br/>");
out.println("April : $ " + m4*vb.getHourlyPrice() +"<br/>");
out.println("May : $ " + m5*vb.getHourlyPrice() +"<br/>");
out.println("June : $ " + m6*vb.getHourlyPrice() +"<br/>");
out.println("July : $ " + m7*vb.getHourlyPrice() +"<br/>");
out.println("August : $ " + m8*vb.getHourlyPrice() +"<br/>");
out.println("September : $ " +m9*vb.getHourlyPrice() +"<br/>");
out.println("October : $ " + m10*vb.getHourlyPrice() +"<br/>");
out.println("November : $ " + m11*vb.getHourlyPrice() +"<br/>");
out.println("December : $ " + m12*vb.getHourlyPrice() +"<br/>"); 
 %>       
        <br/><a href="MainPage.jsp">Return to Main Page</a>
    </body>
</html>

<script>
var lineChartData = {
    labels: ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'], //顯示區間名稱
    datasets: [{
        label: 'Monthly Booking Rate', // tootip 出現的名稱
        lineTension: 0, // 曲線的彎度，設0 表示直線
        backgroundColor: "#ea464d",
        borderColor: "#ea464d",
        borderWidth: 5,
        data: [<%=m1%>, <%=m2%>,<%=m3%>,<%=m4%>,<%=m5%>,<%=m6%>,<%=m7%>,<%=m8%>,<%=m9%>,<%=m10%>,<%=m11%>,<%=m12%>], // 資料
        fill: false, // 是否填滿色彩
    }]
};

function drawLineCanvas(ctx,data) {
    window.myLine = new Chart(ctx, {  //先建立一個 chart
        type: 'bar', // 型態
        data: data,
        options: {
                responsive: true,
                legend: { //是否要顯示圖示
                    display: true,
                },
                tooltips: { //是否要顯示 tooltip
                    enabled: true
                },
                scales: {  //是否要顯示 x、y 軸
                    xAxes: [{
                        display: true
                    }],
                    yAxes: [{
                        display: true
                    }]
                },
            }
    });
};

window.onload = function () {
    var ctx = document.getElementById("canvas").getContext("2d");
    drawLineCanvas(ctx,lineChartData);
};
    
</script>
