<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 24/11/25
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-family: 'Courier New', monospace;
    }

    body {
        background-color: #FFFFFF;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        padding: 20px;
    }

    a {
        width: 40%;
        padding: 12px;
        background-color: #FF5E5B;
        color: #FFFFFF;
        border: 2px solid #000000;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        margin-top: 10px;
        transition: all 0.3s;
    }

    a:hover {
        box-shadow: 4px 4px 0px var(--primary);
        transform: translate(-2px, -2px);
    }
    a{
        text-decoration: none;
        color: #FFFFFF;
    }


</style>
<h1>¡Quiz game!</h1>
<a href="play">play</a>

</body>
</html>
