<%-- 
    Document   : addNote
    Created on : 18.09.2020, 13:57:29
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить заметку</title>
    </head>
    <body>
    <center>
        <h3>Добавить заметку</h3>
        <form action = 'addNote' method = 'POST'>
            Header: <input name="header" />
            <br><br>
            Note: <textarea name="note" ></textarea>
            <br><br>
            <input type="submit" value="Добавить" />
        </form>
    </center> 
</body>
</html>
