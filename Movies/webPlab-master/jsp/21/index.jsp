<%-- 
    Document   : index
    Created on : Mar 31, 2018, 12:46:42 PM
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
        <form action="login.jsp" method ="POST">
            <input type="submit" value="Login"/>
        </form>
        <form action="signup.jsp" method ="POST">
            <input type="submit" value="SignUp"/>
        </form>
        <%
            Cookie[] ck = request.getCookies();
            out.println(ck[0].getValue());
            ck[0].setValue("");
        %>
    </body>
</html>


<!--
<%
            String name = "deepak";
%>
        <script>
            var name = "<%=name%>";
            alert(name);
        </script>
-->