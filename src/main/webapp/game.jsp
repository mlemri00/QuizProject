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
<form action="quiz" method="post">
    <input type="hidden" name="type" value="game">
    <h2><c:out value="question">${question.getQuestion.getText()}</h2>
    <div>
    <button type="submit" name="but"></button>
    </div>

</form>
</body>
</html>
