<%-- 
    Document   : CreateStaffAccount
    Created on : 2023年5月6日, 下午3:34:36
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Staff Account</title>
    </head>
    <body>
        <h1>Hello This is Create Staff Account Page!</h1>
        <jsp:useBean id="sb" class="ict.bean.StaffBean" scope="request" />
        <%  
            String name = sb.getName() !=null? sb.getName() : "";
            String password = sb.getPassword() !=null? sb.getPassword() : "";
            String type = sb.getType() !=null? sb.getType() : "";
            int id = sb.getStaffid();
            String action = (String)request.getAttribute("action") !=null? (String)request.getAttribute("action") : "";
        %>
        
        <form method="post" action="StaffHandler">
            Staff Name:<input type="text" name="name" value="<%= name %>" /><br/>
            Password:<input type="password" name="password" value="<%= password %>"><br/>      
            <%
                if ("manager".equals(type)) {
                    out.print("<label for='type'>Choose a role:</label>");                
                    out.print("<select id='type' name='type'>");
                    out.print("<option selected value='manager'>Manager</option>");
                    out.print("<option value='staff'>Staff</option>");
                    out.print("</select>");
                } else if ("staff".equals(type)) {
                    out.print("<label for='type'>Choose a role:</label>");
                    out.print("<select id='type' name='type'>");
                    out.print("<option value='manager'>Manager</option>");
                    out.print("<option selected value='staff'>Staff</option>");
                    out.print("</select>");                
                } else {
                    out.print("<label for='type'>Choose a role:</label>");
                    out.print("<select id='type' name='type'>");
                    out.print("<option selected value='manager'>Manager</option>");
                    out.print("<option value='staff'>Staff</option>");
                    out.print("</select>");                
                }
            %>    
            <br/>
            <input type="hidden" name="action" value="<%= action %>" />
            <input type="hidden" name="id" value="<%=id %>"/>
            <input type="submit" value="Submit">
        </form>
        <br/><a href="MainPage.jsp">Return to Main Page</a>        
    </body>
</html>
