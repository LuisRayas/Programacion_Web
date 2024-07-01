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
public class DeleteNote extends HttpServlet {
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
            var notes = Utils.getNotes(id);
            
            request.setAttribute("id", id);
            request.setAttribute("username", username);
            request.setAttribute("notes", notes);
            
            request.setAttribute("username", username);
            request.getRequestDispatcher("delete-note.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        
        Note url = new Note();
        
        url.setId(Integer.parseInt(id));
        
        try {
            var connection = new DatabaseConnection();
            String query = "DELETE FROM `note` WHERE `id` = ?;";
            
            connection.executeNonQuery(query, url.getId());
            
            response.sendRedirect("Dashboard");
        } catch (java.sql.SQLException ex) {
            System.out.println("Error al eliminar los datos: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
