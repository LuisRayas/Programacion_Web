<%-- 
    Document   : WEBD
    Created on : 16 jun. 2024, 17:55:49
    Author     : maxim
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Clases.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestión de Entidades</title>
</head>
<style>
    body {
        background: #f1f1f1;
        font-family: 'Segoe UI';
        display: grid;
        place-content: center;
        font-size: 16px;
    }
    
    .form-to-add {
        background: #fff;
        border: 1px solid #fff;
        border-radius: 10px;
        display: flex;
        flex-direction: column;
        gap: 1rem;
        padding: 20px;
    }
    
    h1 {
        margin: 0 0 5px 0;
    }
</style>
<body>
    <form class="form-to-add" action="Agregar" method="POST">
        <h1>Insertar Nuevo Departamento</h1>
        <label for="nombre">Nombre:</label>
        <input id="nombre" type="text" id="nombre" name="nombre">
        <input type="submit" value="Insertar">
    </form>
</body>
</html>
