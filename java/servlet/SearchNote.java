package servlet;

import bd.ConnectionBD;
import bd.Note;
import bd.SelectInfoBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Сервлет для поиска*/
public class SearchNote extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sort = request.getParameter("search");
        request.setAttribute("text", sort);
        request.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
