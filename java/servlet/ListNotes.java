package servlet;

import bd.ConnectionBD;
import bd.Note;
import bd.SelectInfoBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Сервлет для отображения списка заметокы*/
public class ListNotes extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Note> listNotes = new ArrayList<Note>();
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        SelectInfoBD select = new SelectInfoBD();
        try {
            listNotes = select.getNotes(connection);
            request.setAttribute("notes", listNotes);
            request.getServletContext().getRequestDispatcher("/listNotes.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Note> listNote = new ArrayList<Note>();
        ArrayList<Note> listNotesSearch = new ArrayList<Note>();
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        SelectInfoBD select = new SelectInfoBD();
        String mes = "";
        try {
            listNote = select.getNotes(connection);
            String sort = (String) request.getAttribute("text");
            if (sort != " " || sort != null) {
                String text = sort.toLowerCase();
                for (Note note : listNote) {
                    String head = note.getHeader();
                    if (head != null) {
                        if (head.toLowerCase().contains(text)) {
                            listNotesSearch.add(note);
                        } else {
                            if (note.getNote().toLowerCase().contains(text)) {
                                listNotesSearch.add(note);
                            } else {
                                mes = "Nothing found";
                            }
                        }
                    } else {
                        if (note.getNote().toLowerCase().contains(text)) {
                            listNotesSearch.add(note);
                        } else {
                            mes = "Nothing found";
                        }
                    }
                }
                request.setAttribute("notes", listNotesSearch);
                request.setAttribute("message", mes);
                request.getServletContext().getRequestDispatcher("/listNotes.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
