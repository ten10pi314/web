<%-- 
    Document   : welcome
    Created on : Mar 31, 2018, 1:04:40 PM
    Author     : vikikkdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie[] ck = request.getCookies();
            out.print(ck[0].getValue());
            out.print(ck[1].getValue());
        %>
    </body>
</html>
