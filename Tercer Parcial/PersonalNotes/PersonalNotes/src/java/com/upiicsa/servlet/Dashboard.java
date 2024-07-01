package com.upiicsa.servlet;

import com.upiicsa.app.Utils;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Rayas Batalla Luis A.
 */
public class Dashboard extends HttpServlet {
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
            
            request.setAttribute("username", username);
            request.setAttribute("notes", notes);
            request.getRequestDispatcher("dashboard.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
}
