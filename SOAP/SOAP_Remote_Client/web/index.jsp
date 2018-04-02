<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <%-- start web service invocation --%><hr/>
            <%
            try {
                server.Addition_Service service = new server.Addition_Service();
                server.Addition port = service.getAdditionPort();
                 // TODO initialize WS operation arguments here
                int a = 100;
                int b = 100;
                // TODO process result here
                int result = port.multiply(a, b);
                out.println("Result = "+result);
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
            %>

        <%-- end web service invocation --%><hr/>

    </body>
</html>
