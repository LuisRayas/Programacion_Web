<%-- 
    Document   : delete-note
    Created on : Jun 29, 2024, 1:44:58 PM
    Author     : Rayas Batalla Luis A.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jakarta.servlet.http.HttpServletRequest"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    Object id = request.getAttribute("id");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PersonalNotes - Eliminar</title>
    </head>
    <style>
        * { margin: 0; padding: 0; }
        
        *, *::before, *::after { box-sizing: border-box }
        
        p { text-wrap: pretty }
        
        h1, h2, h3 { text-wrap: balance }
        
        input, button, select, textarea { font: inherit; outline: none; }
        
        body {
            background-color: #f1f1f1;
            font-family: sans-serif;
            font-size: 16px;
            display: grid;
            min-height: 100dvh;
            place-content: center;
        }
        
        .delete-note__title {
            text-align: center;
        }
        
        .delete-note__form {
            background-color: #fff;
            border-radius: 0.625rem;
            display: flex;
            flex-direction: column;
            gap: 20px;
            padding: 40px;
        }
        
        .delete-note__form-input {
            display: flex;
            flex-direction: column;
            gap: 0.3125rem;
        }

        .delete-note__textarea {
            resize: none;
            height: 120px;
        }
    </style>
    <body>
        
        <form class="delete-note__form" action="DeleteNote" method="POST">
            <h2 class="delete-note__title">Eliminar Nota</h2>
            <div class="delete-note__form-input">
                <label>Selecciona una página</label>
                <select id="id" name="id">
                    <c:forEach items ="${requestScope.notes}" var="note">
                        <option value="<c:out value="${note.id}"/>" data-text="<c:out value="${note.text}"/>">
                            <c:out value="${note.id}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
           <div class="delete-note__form-input">
                <label>Nota</label>
                <textarea id="text" name="text" class="delete-note__textarea" readonly></textarea>
            </div>
            <a class="delete-note__link" href="/PersonalNotes/Dashboard">Regresar</a>
            <input type="submit" value="Eliminar">
        </form>
    </body>
    <script>
        'use strict';
        
        const id = document.querySelector('#id');

        id.addEventListener('change', (e) => {
            const text = document.querySelector('#text');
            
            const index = e.target.selectedIndex;

            text.value =  e.target.children[index].getAttribute('data-text').trim();
        }); 
    </script>
</html>
