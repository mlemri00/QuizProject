<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pedro
  Date: 25/11/25
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
<style>
    body{
        margin: 0;
        padding: 0;
        display: flex;
        align-items: center;
        justify-content: center;
        font-family: 'Courier New', monospace;

    }
    table{
        width: 600px;
        border: 1px solid black;
        box-shadow: 4px 4px 0px black;

    }

    thead{
        border: 1px solid black;
        background-color: red;
        color: white;

    }
    th{
        width: 33%;
        border:1px solid black;
        justify-content: center;
    }
    tr{
        justify-content: center;
        text-align: center;
    }

</style>
<div class="ranking-container">
    <h1>Best results</h1>
    <c:if test="${games != null}">
    <table id="ranking-table">
        <thead>
        <tr>
            <th>User</th>
            <th id="score-column">Score</th>
            <th>Correct Answers</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="game" items="${games}">
            <tr>
                <td id="name-column">${game.username}</td>
                <td id="score-column">${game.gameScore}</td>
                <td>${game.correctAnswers}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</div>
</body>
</html>
