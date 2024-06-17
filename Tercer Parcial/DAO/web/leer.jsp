<%-- 
    Document   : leer
    Created on : 16 jun. 2024, 21:30:31
    Author     : maxim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Clases.Departamento"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es-419">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departamentos</title>
    </head>
    <!-- comment<style>
        body {
        background: #f1f1f1;
        font-family: 'Segoe UI';
        display: grid;
        place-content: center;
        font-size: 16px;
        }
        table {
            border-collapse: collapse;
            border: 1px solid #000;
        }
        th {
            text-align-all: center;
            border: 1px solid #000;
        }
        td {
            text-align: center;
            border: 1px solid #000;
        }
        .button {
            background: gray;
            color: #000;
            height: 20px;
            border-radius: 5px;
            text-decoration: none;
            width: 90px;
            text-align: center;
            align-items: center;
            display: flex;
            justify-content: center;
            margin: 5px;
        }

    </style> -->
    <body>
        <a style="align-self: center;" class="button" href="/DAO/Agregar">
             <span>Agregar</span>
        </a>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items ="${requestScope.departamentos}" var="e">
                <tr>
                    <td><c:out value="${e.id}"/></td>
                    <td><c:out value="${e.nombre}"/></td>
                    <td>
                        <a class="button" href="/DAO/Actualizar">
                            <span>Actualizar</span>
                        </a>
                        <a class="button" href="/DAO/Borrar">
                             <span>Borrar</span>
                        </a>                       
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
