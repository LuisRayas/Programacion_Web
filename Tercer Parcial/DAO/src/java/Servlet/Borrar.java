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
public class Borrar extends HttpServlet {

    private final DAO<Departamento> dao = new DAOImp();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DAO<Departamento> c = new DAOImp();
           var deps = c.readAll();
            System.out.println(deps);
            request.setAttribute("departamentos", deps);
        } 
        catch (java.sql.SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         request.getRequestDispatcher("borrar.jsp").include(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt (request.getParameter("id"));
        
        try {
            dao.delete(id);
           
        } catch (java.sql.SQLException ex) {
            System.out.println(ex);
        }
        
        doGet(request, response);
    }
   
}

