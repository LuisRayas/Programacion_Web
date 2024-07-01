<%-- 
    Document   : add-note
    Created on : Jun 29, 2024, 10:45:47 AM
    Author     : Rayas Batalla Luis A.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpServletRequest"%>
<%
    Object id = request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Nota</title>
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
            min-height: 100dvh;
            place-content: center;
        }
        
        .add-note__title {
            text-align: center;
        }
        
        .add-note__form {
            background-color: #fff;
            border: 1px solid rgba(0, 0, 0, 0.13);
            border-radius: 0.625rem;
            display: flex;
            flex-direction: column;
            gap: 20px;
            padding: 40px;
        }
        
        .add-note__form-input {
            display: flex;
            flex-direction: column;
            gap: 0.3125rem;
        }
        
        .add-note__textarea {
            resize: none;
            height: 120px;
        }
        
    </style>
    <body>
        <form class="add-note__form" action="AddNote" method="POST">
            <h2 class="add-note__title">Agregar url</h2>
            <input name="user-id" type="hidden" placeholder="Página" value="<%= id %>">
            <div class="add-note__form-input">
                <label>Nota</label>
                <textarea name="text" class="add-note__textarea"></textarea>
            </div>
            <a class="add-note__link" href="/PersonalNotes/Dashboard">Regresar</a>
            <input type="submit" value="Agregar">
        </form>
    </body>
</html>
