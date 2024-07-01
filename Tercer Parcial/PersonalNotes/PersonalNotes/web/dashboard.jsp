<%-- 
    Document   : dashboard
    Created on : Jun 29, 2024, 2:58:37 AM
    Author     : Rayas Batalla Luis A.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpServletRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
   Object username = request.getAttribute("username");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
        <title>Dashboard</title>
    </head>
    <style>
        * { margin: 0; padding: 0; }
        
        *, *::before, *::after { box-sizing: border-box }
        
        p { text-wrap: pretty }
        
        h1, h2, h3 { text-wrap: balance }
        
        input, button, select, textarea { font: inherit; outline: none; }
        
        body {
            background-color: #fff;
            font-family: sans-serif;
            font-size: 16px;
            display: grid;
            grid-template-rows: 100px auto;
            min-height: 100dvh;
        }
        
        table {
            width: 100%
        }
        
        th, td {
            text-align: center !important;
        }
        
        main {
            display: grid;
            grid-template-columns: repeat(auto-fill, 200px);
            grid-template-rows: repeat(auto-fill, 200px);
            place-content: center;
            gap: 10px;
        }
        
        .dashboard__header {
            align-items: center;
            background-color: #fff;
            border-bottom: 1px solid rgba(0, 0, 0, 0.13); 
            display: flex;
            justify-content: center;
            padding: 10px 20px 0 20px;
            flex-direction: column;
        }
        
        .dashboard__title {
            font-size: 18px;
        }
        
        .dashboard__header-actions {
            display: flex;
            gap: 10px;
        }
        
        .dashboard__note {
            background-color: #FFEB3B;
            height: auto;
            width: 200px
        }
        
        .dashboard__note-header {
            display: flex;
            align-items: center;
            justify-content: space-between;
        }
        
        .dashboard__pin {
            background-color: tomato;
            border-radius: 100%;
            height: 20px;
            width: 20px;
            margin: 8px;
        }
        
        .dashboard__text {
            background: transparent;
            border: 0;
            height: calc(200px - 36px);
            resize: none;
            width: 100%;
            text-align: center;
        }

                /* width */
        ::-webkit-scrollbar {
          width: 2px;
        }

        /* Track */
        ::-webkit-scrollbar-track {
          background: transparent;
        }

        /* Handle */
        ::-webkit-scrollbar-thumb {
          background: #888;
        }

        /* Handle on hover */
        ::-webkit-scrollbar-thumb:hover {
          background: #555;
        }
    </style>
    <body>
        <header class="dashboard__header">
            <h2 class="dashboard__title">Tus notas, <%= username %></h2>
            <div class="dashboard__header-actions">
                <a href="/PersonalNotes/AddNote">
                    <span class="material-symbols-outlined" title="Agregar">
                         add_circle
                    </span>
                </a>
                <a href="/PersonalNotes/UpdateNote" title="Editar">
                    <span class="material-symbols-outlined">
                        edit
                    </span>
                </a>
                <a href="/PersonalNotes/DeleteNote" title="Eliminar">
                    <span class="material-symbols-outlined">
                        delete
                    </span>
                </a>
                <a href="/PersonalNotes/Logout" title="Salir">
                    <span class="material-symbols-outlined">
                        logout
                    </span>
                </a>
            </div>
        </header>
        <main>
            <c:forEach items ="${requestScope.notes}" var="note">
                <div class="dashboard__note">
                    <div class="dashboard__note-header">
                        <div class="dashboard__pin"></div>
                        <div class="dashboard__shadow"></div>
                    </div>
                    <div class="dashboard__note-body">
                        <textarea class="dashboard__text" title="<c:out value="${note.text}"/>" readonly>
                            <c:out value="${note.text}"/>
                        </textarea>
                    </div>
                </div>
            </c:forEach>

        </main>
    </body>
</html>
