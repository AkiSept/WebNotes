package servlet;

import bd.ConnectionBD;
import bd.InsertInfoBD;
import bd.Note;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Сервлет для добавления заметки в бд*/
public class AddNoteBD extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String header = request.getParameter("header");
        String text = request.getParameter("note");
        Note note = new Note();
        if (text.equals("")) {
            int error = 0;
            request.setAttribute("error", error);
            request.getServletContext().getRequestDispatcher("/perform.jsp").forward(request, response);
        } else {
            if (header.equals("")) {
                note.setHeader(null);
            } else {
                note.setHeader(header);
            }
            note.setNote(text);
            ConnectionBD con = new ConnectionBD();
            Connection connection = con.connect();
            InsertInfoBD insert = new InsertInfoBD();
            try {

                int error = insert.setNote(connection, note);
                request.setAttribute("error", error);
                request.getServletContext().getRequestDispatcher("/perform.jsp").forward(request, response);
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
}
