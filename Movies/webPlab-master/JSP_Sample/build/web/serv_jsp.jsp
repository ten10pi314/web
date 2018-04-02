<%-- 
    Document   : serv_jsp
    Created on : 23 Mar, 2018, 12:24:06 PM
    Author     : student
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
            String pass="";
            try{
                String dbClassName = "com.mysql.jdbc.Driver";
                String CONNECTION ="jdbc:mysql://localhost:3306/webprog";
            Class.forName(dbClassName);
            Connection c = DriverManager.getConnection(CONNECTION,"root","student");
            Statement stmt=c.createStatement();
            ResultSet rs=stmt.executeQuery("select password,id from student where username='gdeek'");
            
            boolean flag=false;
            int rno=-1;
            while(rs.next())
            {
                pass=rs.getString(1);
            }
            
            c.close();
        }
        catch(Exception e)
        {
            out.println(e);
        }
            %>
            <p><% out.println(pass); %></p>
    </body>
</html>
