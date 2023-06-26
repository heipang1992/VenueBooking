<%-- 
    Document   : AddVenue
    Created on : 2023年5月10日, 下午2:19:54
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Venue</title>
    </head>
    <body>
        <h1>Hello This is Add Venue Page!</h1>
        <form method="post" action="VenuePage">
            Venue ID: <input type="text" name="id" /><br/>
            Name : <input type="text" name="name" /><br/>
            Address : <input type="text" name="address" /><br/>
            Person In Charge : <input type="text" name="pic" /><br/>
            Phone : <input type="text" name="phone" /><br/>
            Email : <input type="text" name="email" /><br/>
            Hourly Price : <input type="number" name="price" /><br/>
            <input type="submit" value="Add" />
            <input type="hidden" name="action" value="addsubmit"/>
        </form>
    </body>
</html>
