<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OutputPage</title>
    </head>
    <body>
       <%-- start web service invocation --%>
       <hr/>
        <%
            out.print("<div align='center'>");
            out.println("We are using a SOAP Service to calculate this!");
            String v1 = request.getParameter("value1");
            double value1 = Double.parseDouble(v1);
            String v2 = request.getParameter("value2");
            double value2 = Double.parseDouble(v2);
            
            try {
                server.Addition_Service service = new server.Addition_Service();
                server.Addition port = service.getAdditionPort();
                double result = port.add(value1, value2);
                out.println( "</br> <h2 align='center'>" + "Result = " + result + "</h2> </br>");
            } catch (Exception ex) {
                // TODO handle custom exceptions here
                out.println(ex.getMessage());
            }
            out.println("Did you like SOAP Services?");
            out.print("</br>");
            out.print("<a href='index.jsp'><button>Yes! Add more numbers!</button></a>");
            out.print("   ");
            out.print("<a href='https://goo.gl/y1g5AK'><button> No!</button></a>");
            out.print("</div>");
        %>
        <%-- end web service invocation --%>
        <hr/> 
    </body>
</html>
