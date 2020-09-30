<%-- 
    Document   : perform
    Created on : 18.09.2020, 16:57:44
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <%
            int error = (int) request.getAttribute("error");
            if (error == 1) {
                out.println("The operation was successful");
            } else {
                out.println("The operation was unsuccessful");
            }
            out.println("<p><a  href ='" + request.getContextPath() + "/index.jsp'>&larr;</a>");

        %>
    </center>
</body>
</html>
