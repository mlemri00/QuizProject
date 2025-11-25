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

<h2 id="timeJ">${time}</h2>
<h3 id="time"></h3>

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
<script>
    document.addEventListener("DOMContentLoaded",(e)=>{
        const num = Number.parseInt(document.querySelector("#timeJ").innerHTML);
        let countDown = new Date().getTime() + num;

        let x = setInterval(function() {
            let now = new Date().getTime();

            let distance = countDown - now;
            let minutes = Math.floor((distance%(1000 *60 *60))/(1000*60));
            let seconds = Math.floor((distance%(1000 *60)) / 1000);

            document.getElementById("time").innerHTML =  minutes + "m " + seconds + "s ";

        }, 1000);
    })
</script>
</html>
