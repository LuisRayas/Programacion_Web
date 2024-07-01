package com.upiicsa.servlet;

import com.upiicsa.app.DatabaseConnection;
import com.upiicsa.app.Utils;
import com.upiicsa.models.Note;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rayas Batalla Luis A.
 */
public class AddNote extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var cookies = request.getCookies();
        boolean hasCookie = false;
        int id = 0;
        
        for (var cookie : cookies) {
            if (cookie.getName().equals("user")) {
                hasCookie = true;
                id = Integer.parseInt(cookie.getValue());
            }
        }
        
        if (hasCookie) {
            String username = Utils.getUsername(id);
            
            request.setAttribute("id", id);
            request.setAttribute("username", username);
            request.getRequestDispatcher("add-note.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String userId = request.getParameter("user-id");

        Note url = new Note();
        
        url.setText(text);
        url.setUserId(Integer.parseInt(userId));
        
        try {
            var connection = new DatabaseConnection();
            String query = "INSERT INTO `note` (`text`, `user_id`) VALUES (?, ?);";
            
            connection.executeNonQuery(query, url.getText(), url.getUserId());
            
            response.sendRedirect("Dashboard");
        } catch (java.sql.SQLException ex) {
            System.out.println("Error al insertar los datos: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
