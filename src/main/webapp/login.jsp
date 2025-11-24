<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 19/11/25
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<main class="container">
    <form action="login" method="POST">
        <input type="hidden" name="__method" value="POST">

        <div class="input-group">
            <label for="username">User</label>
            <input type="text" id="username" name="username">
        </div>



        <div class="input-group">
            <label for="passwd">Password</label>
            <input type="password" id="passwd" name="password">
        </div>



        <p>${error}</p>

        <button type="submit">Save</button>

    </form>

    <a href="register">No tines cuenta? Registrate</a>
</main>




</body>
</html>
