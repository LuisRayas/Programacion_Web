
<%-- 
    Document   : Visitante
    Created on : 19 may. 2024, 17:53:11
    Author     : OMEN


--%>

<%
    String cookieName = "visitorName";
    String visitorName = "";
    Cookie[] cookies = request.getCookies();
    boolean existeCookie= false;
    for(Cookie cookie : cookies){
        if(cookieName.equals(cookie.getName())){
        existeCookie= true;
        visitorName = cookie.getValue();
        }
    }
    if(!existeCookie)
        response.sendRedirect("Inicio.jsp");
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bienvenido Visitante</title>
    </head>
    <body>
        <h1>Hola <%=visitorName%></h1>
    </body>
</html>
