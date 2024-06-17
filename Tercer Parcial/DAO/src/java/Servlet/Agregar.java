/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Clases.DAO;
import Clases.DAOImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import Clases.Departamento;

/**
 *
 * @author maxim
 */
public class Agregar extends HttpServlet {
    private final DAO<Departamento> dao = new DAOImp();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("agregar.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var nombre = request.getParameter("nombre");
        
       try {
           Departamento dep = new Departamento();
           
           dep.setNombre(nombre);
           
           if (nombre.isEmpty() || nombre.isBlank()) {
               return;
           }
           
            dao.insert(dep);
        } catch (java.sql.SQLException ex) {
            System.out.println(ex);
        }
       
       response.sendRedirect("agregar.jsp");
    }
   
}
