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
