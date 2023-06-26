<%-- 
    Document   : MemberList
    Created on : 2023年5月3日, 下午2:20:54
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, ict.bean.AccountBean, ict.bean.StaffBean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member List</title>
    </head>
    <body>       
        <h1>Hello This is Account List!</h1>        
        <jsp:useBean id="ArrayList"  scope="request" class="java.util.ArrayList<AccountBean>"/>
        <jsp:useBean id="StaffArrayList"  scope="request" class="java.util.ArrayList<StaffBean>"/>
        <h3>This is Member List</h3>
        <% 
            out.print("<table border='1'>");
            out.print("<tr><th>Name</th> <th>Email</th> <th>Phone</th> <th>Edit</th> <th>Delete</th> </tr>");
            for (int i=0; i<ArrayList.size(); i++) {
                AccountBean cb = ArrayList.get(i);
                out.print("<tr>");
                out.print("<td>" + cb.getName() + "</td>" + "<td>" + cb.getEmail() + "</td>" + "<td>" + cb.getPhone() + "</td>" + "<td>" + "<a href='HandleAccount?action=edit&email=" + cb.getEmail() + "&password=" + cb.getPassword() + "'>" + "Edit" + "</a>" + "</td>" + "<td>" + "<a href='HandleAccount?action=delete&email=" + cb.getEmail() + "&password=" + cb.getPassword() + "'>" + "Delete" + "</a>" + "</td>");
                out.print("</tr>");
            }
            out.print("</table>");
        %>
        <br/><br/><br/>
        <h3>This is Staff List</h3>
        <% 
            out.print("<table border='1'>");
            out.print("<tr><th>Staff ID</th> <th>Name</th> <th>Type</th> <th>Edit</th> <th>Delete</th> </tr>");
            for (int i=0; i<StaffArrayList.size(); i++) {
                StaffBean sb = StaffArrayList.get(i);
                out.print("<tr>");
                out.print("<td>" + sb.getStaffid() + "</td>" + "<td>" + sb.getName() + "</td>" + "<td>" + sb.getType() + "</td>" + "<td>" + "<a href='StaffHandler?action=edit&name=" + sb.getName() + "&password=" + sb.getPassword() + "'>" + "Edit" + "</a>" + "</td>" + "<td>" + "<a href='StaffHandler?action=delete&id=" + sb.getStaffid() + "'>" + "Delete" + "</a>" + "</td>");
                out.print("</tr>");
            }
            out.print("</table>");
        %> 
        <form method="post" action="StaffHandler" >
            <input type="hidden" name="action" value="create" />
            <input type="submit" value="Create Staff Account" />
        </form>
        <br/><a href="MainPage.jsp">Return to Main Page</a>
    </body>
</html>
