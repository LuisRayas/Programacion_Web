<%-- 
    Document   : BD
    Created on : 9 jun. 2024, 16:16:15
    Author     : OMEN
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mrysi.beans.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
    <% getServletContext().getRequestDispatcher("/ServletEscuela").include(request, response); %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>nombre</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items ="${requestScope.ListaEscuelas}" var="e">
                <tr>
                    <td><c:out value="${e.id}"/></td>
                    <td><c:out value="${e.nombre}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    
    </body>
</html>
