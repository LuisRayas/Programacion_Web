<%-- 
    Document   : sign-up
    Created on : Jun 29, 2024, 2:29:37 AM
    Author     : Rayas Batalla Luis A.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear cuenta</title>
    </head>
    <style>
        * { margin: 0; padding: 0; }
        
        *, *::before, *::after { box-sizing: border-box }
        
        p { text-wrap: pretty }
        
        h1, h2, h3 { text-wrap: balance }
        
        input, button, select, textarea { font: inherit; outline: none; }
        
        body {
            background-color: navy;
            font-family: sans-serif;
            font-size: 16px;
            display: grid;
            min-height: 100dvh;
            place-content: center;
            
           
            
        }
        
        .sign-up__title {
            text-align: center;
        }
        
        .sign-up__form {
            background-color: #fff;
            border: 1px solid rgba(0, 0, 0, 0.13);
            border-radius: 0.625rem;
            display: flex;
            flex-direction: column;
            gap: 20px;
            padding: 40px;
        }
        
        .sign-up__form-input {
            display: flex;
            flex-direction: column;
            gap: 0.3125rem;
        }
        
        .sign-up__input {
            text-indent: 0.625rem;
        }
        
        .sign-up__link {
            text-align: center;
        }
        
        .sign-up__button {
            border: 0;
            background: steelblue;
            color: #fff;
            border-radius: 3px;
            height: 35px;
        }
        
        .sign-up__button:hover {
            background: blue;
            transition: .5s ease;
        }
    </style>
    <body>
        
       <form class="sign-up__form" action="SignUp" method="POST">
            <h2 class="sign-up__title">Crear cuenta</h2>
            <div class="sign-up__form-input">
                <label>Nombre de usuario</label>
                <input name="username" class="sign-up__input" type="text" placeholder="Nombre" required>
            </div>
            <div class="sign-up__form-input">
                <label>Correo electrónico</label>
                <input name="email" class="sign-up__input" type="email" placeholder="Correo electrónico" required>
            </div>
            <div class="sign-up__form-input">
                <label>Contraseña</label>
                <input name="password" class="sign-up__input" type="password" placeholder="Contraseña" required>
            </div>
            <a class="sign-up__link" href="/PersonalNotes/Login">Iniciar sesión</a>
            <input class="sign-up__button" type="submit" value="Crear cuenta">
        </form>
    </body>
</html>
