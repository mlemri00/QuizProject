<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="login-container">
    <h1>REGISTRO</h1>
    <form action="register" method="POST">
        <div class="input-group">
            <label for="username">NOMBRE DE USUARIO</label>
            <input type="text" id="username" name="username">
            <p>${error}</p>
        </div>
        <div class="input-group">
            <label for="firstName">NOMBRE</label>
            <input type="text" id="firstName" name="firstName">
        </div>
        <div class="input-group">
            <label for="lastName">APELLIDOS</label>
            <input type="text" id="lastName" name="lastName">
        </div>

        <div class="input-group">
            <label for="password">CONTRASEÑA</label>
            <input type="password" id="password" name="password" placeholder="••••••••">
        </div>

        <button type="submit">REGISTRAR</button>
    </form>
</div>



</body>
</html>