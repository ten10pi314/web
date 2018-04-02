    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Database JSP1</title>
    </head>
    <body>
     
     <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
         url="jdbc:mysql://localhost/GuruTest"
         user="gururoot"  password="guru"/>
     
    <sql:query dataSource="${snapshot}" var="result">
    SELECT * from guru_test;
    </sql:query>
     
    <table>
    <tr>
       <th>Guru ID</th>
       <th>Name</th>
     
    </tr>
    <c:forEach var="row" items="${result.rows}">
    <tr>
       <td><c:out value="${row.emp_id}"/></td>
       <td><c:out value="${row.emp_name}"/></td>
     
    </tr>
    </c:forEach>
    </table>
     
    </body>
    </html>













        <%@ page import="java.io.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="gurucore"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="gurusql"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Database JSP1</title>
    </head>
    <body>
     
     <gurusql:setDataSource var="guru" driver="com.mysql.jdbc.Driver"
         url="jdbc:mysql://localhost/GuruTest"
         user="gururoot"  password="guru"/>
         
         <gurusql:update dataSource="${guru}" var="guruvar">
    INSERT INTO guru_test VALUES (3, 'emp emp3');
    </gurusql:update>
     
     
     
    </body>
    </html>









        <%@ page import="java.io.*,java.util.*,java.sql.*"%>
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="gurucore"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="gurusql"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Database JSP1</title>
    </head>
    <body>
     
     <gurusql:setDataSource var="guru" driver="com.mysql.jdbc.Driver"
         url="jdbc:mysql://localhost/GuruTest"
         user="gururoot"  password="guru"/>
         <gurucore:set var="guruid" value="3"/>
         <gurusql:update dataSource="${guru}" var="guruvar">
    DELETE FROM guru_test WHERE emp_id = ?
      <gurusql:param value="${guruid}" />
    </gurusql:update>
     
     
     
    </body>
    </html>







    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="gurucore"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="gurusql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Guru Database JSP1</title>
</head>
<body>
 
<gurusql:setDataSource var="guru" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/GuruTest"
     user="gururoot"  password="guru"/>
     <gurucore:set var="guruid" value="2"/>
     <gurusql:update dataSource="${guru}" var="guruvar">
UPDATE guru_test SET emp_name='emp guru99'
  <gurusql:param value="${guruid}" />
</gurusql:update>
 
 
 
</body>
</html>