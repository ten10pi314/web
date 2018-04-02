<%-- 
    Document   : loginJSP
    Created on : Mar 31, 2018, 1:12:28 PM
    Author     : vikikkdi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String roll = request.getParameter("roll");
            String name = request.getParameter("name");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vikikkdi","root", "vikikkdi");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select name from student where roll='"+roll+"'");
            if(rs.next() && rs.getString("name").equals(name)){
                response.addCookie(new Cookie("roll",roll));
                response.addCookie(new Cookie("name",name));
                response.sendRedirect("welcome.jsp");
            }else{
                response.addCookie(new Cookie("status","FAILED"));
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>
