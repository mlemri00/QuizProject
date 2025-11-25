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
</head>
<body>

<c:if test="${juegos != null}">
    <c:forEach var="juego" items="${juegos}">
        <tr>
            <td>${juego.username}</td>
            <td>${juego.puntuacion}</td>
        </tr>
    </c:forEach>
</c:if>
</body>
</html>
