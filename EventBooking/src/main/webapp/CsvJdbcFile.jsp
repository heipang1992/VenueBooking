<%-- 
    Document   : CsvJdbcFile
    Created on : May 11, 2023, 3:45:25 AM
    Author     : mahei
--%>

<%@ page import="java.io.*,java.sql.*"%>
<html>
<body>
<% 

String filename = "c:\\csv\\bookings.csv";
Connection conn = null;
String url = this.getServletContext().getInitParameter("dbUrl");
String dbName = "booking";
String driver = "com.mysql.jdbc.Driver";
String userName = this.getServletContext().getInitParameter("dbUser");
String password = this.getServletContext().getInitParameter("dbPassword");
Statement stmt;
try
{
FileWriter fw = new FileWriter(filename);

fw.append("Venue Id");
fw.append(',');
fw.append("Date");
fw.append(',');
fw.append("Start Time");
fw.append(',');
fw.append("Member Email");
fw.append(',');
fw.append("Available");
fw.append(',');
fw.append("Approval");
fw.append('\n');

Class.forName(driver).newInstance();
conn = DriverManager.getConnection(url,userName,password);
String query = "select venueId, date, startTime, memberEmail, available, isApproved from booking Where available=false";
stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery(query);
while(rs.next())
{
fw.append((rs.getString(1)));
fw.append(',');
fw.append(rs.getString(2));
fw.append(',');
fw.append(rs.getString(3));
fw.append(',');
fw.append(rs.getString(4));
fw.append(',');
fw.append(rs.getString(5));
fw.append(',');
fw.append(rs.getString(6));

fw.append('\n');
}
fw.flush();
fw.close();
conn.close();
out.println("<b>You are Successfully Created Csv file.</b>");
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>
