<%-- 
    Document   : signupJSP
    Created on : Mar 31, 2018, 12:55:06 PM
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
            try{
                int i = st.executeUpdate("insert into student values('"+roll+"','"+name+"');");
                if(i>0){
                    response.addCookie(new Cookie("status","SUCCESS"));
                    response.sendRedirect("index.jsp");
                }else{
                    response.addCookie(new Cookie("status","FAILED"));
                    response.sendRedirect("index.jsp");
                }
            }catch(Exception e){
                response.addCookie(new Cookie("status","FAILED"));
                response.sendRedirect("index.jsp");
            }
        %>
    </body>
</html>
