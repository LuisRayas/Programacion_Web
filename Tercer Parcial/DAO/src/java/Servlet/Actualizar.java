/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import Clases.DAO;
import Clases.DAOImp;
import Clases.Departamento;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 *
 * @author maxim
 */
public class Actualizar extends HttpServlet {

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
        
         request.getRequestDispatcher("actualizar.jsp").include(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var id = Integer.parseInt(request.getParameter("id"));
        var nombre = request.getParameter("nombre");
        
       try {
           Departamento dep = new Departamento();
           
           dep.setId(id);
           dep.setNombre(nombre);
           
           if (nombre.isEmpty() || nombre.isBlank()) {
               return;
           }
           
            dao.update(dep);
        } catch (java.sql.SQLException ex) {
            System.out.println(ex);
        }
       
        doGet(request, response);
    }
   
}
