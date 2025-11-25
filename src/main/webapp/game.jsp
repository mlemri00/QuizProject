<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>¡Quiz game!</h1>

<h3>${time}</h3>

    <input type="hidden" name="type" value="game">
    <h2>
<c:out value="${question}"/>
    </h2>
    <div>
    <form action="quiz" method="post">

    <c:forEach var="ans" items="${answers}">

        <button value="${ans}" type="submit" name="ans">
            <c:out value="${ans}"/>
        </button>

    </c:forEach>
    </form>

    </div>
</body>
</html>
