package servlet;

import bd.ConnectionBD;
import bd.DeleteInfoBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Сервлет для удаления заметки*/
public class DeleteNote extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ConnectionBD con = new ConnectionBD();
        Connection connection = con.connect();
        DeleteInfoBD delete = new DeleteInfoBD();
        try {
            int id = Integer.parseInt(request.getParameter("delete"));
            int error = delete.delNote(connection, id);
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
