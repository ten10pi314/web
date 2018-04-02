<%-- 
    Document   : index
    Created on : Mar 23, 2018, 12:47:52 AM
    Author     : Akshay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
   <head><title>A Comment Test</title></head> 
   
   <body>
       <!--declaration--> 
       <%! int i=0; %> 
       <p> <% for(int i=0;i<5;++i) out.println(i); %> </p>
       <!--expressions--> 
       <p>Today's date: <%= (new java.util.Date()).toString()%></p>
   </body> 
</html> 
