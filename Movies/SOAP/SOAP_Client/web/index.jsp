<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>InputPage</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div align ="center">
            <form action="performanddisplay.jsp" method="POST">
                Enter first value:<input type="number" step="any" name="value1"></input></br>
                Enter second value:<input type="number" step="any" name="value2"></input></br>
                <input type="submit" value="ADD NOW!"/></br>
            </form>
        </div>

    </body>
</html>
