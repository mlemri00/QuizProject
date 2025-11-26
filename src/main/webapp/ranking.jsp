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
</head>
<body>

<c:if test="${games != null}">
    <tr>
    <c:forEach var="game" items="${games}">
            <td>${game.username}</td>
            <td>${game.gameScore}</td>
    </c:forEach>
    </tr>
</c:if>

</body>
</html>
