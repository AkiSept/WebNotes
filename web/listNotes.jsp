<%-- 
    Document   : listNotes
    Created on : 18.09.2020, 13:32:15
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bd.Note"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список заметок</title>
    </head>
    <body>
    <center>
        <form action="searchNote" method="POST">
            <input name="search" />
            <input type="submit" value="Поиск" />
        </form>
        <h3>List of notes</h3>
        <table cellspacing="5" >
            <tr>
                <%
                    ArrayList<Note> note = new ArrayList<Note>();
                    note = (ArrayList<Note>) request.getAttribute("notes");
                    for (int i = 0; i < note.size(); i++) {
                        String text = "";
                        if (note.get(i).getHeader() == null) {
                            text = note.get(i).getNote().substring(0, 10) + "...";
                        } else {
                            text = note.get(i).getHeader();
                        }
                        out.println("<tr>\n"
                                + "<td>" + i + "</td>"
                                + "<td>" + text + "</td>"
                                + "<td><form action='deleteNote' method='POST'> " //
                                + "<p><button type='submit' value=" + note.get(i).getIdNote() + " name='delete' >delete</button> </p></form></td>"
                                + "</tr>");
                    }
                    String mes = (String) request.getAttribute("message");
                    if (mes != "") {
                        out.println(mes);
                    }
                %>
            </tr>
        </table>
        <form action="addOut" method="POST">
            <input type="submit" value="Добавить заметку" />
        </form>
    </center>
</body>
</html>
