<%-- 
    Document   : login
    Created on : Mar 31, 2018, 12:52:18 PM
    Author     : vikikkdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="loginJSP.jsp" method="POST">
            Roll :<input type="text" value="enter roll number" name="roll"/>
            Name :<input type="text" value="enter name" name="name"/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
