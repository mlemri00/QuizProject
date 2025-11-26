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
    <title>¡Quiz game!<</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="game-content"> <h3 id="time"></h3>
    <input type="hidden" id="timeJ" value="${time}">


    <input type="hidden" name="type" value="game">
    <h2>
        <c:out value="${question}"/>
    </h2>
    <div class="answers-container"> <form action="play" method="post">

        <c:forEach var="ans" items="${answers}">
            <button value="${ans}" type="submit" name="ans">
                <c:out value="${ans}"/>
            </button>

        </c:forEach>
    </form>

    </div>
</div>
</body>
<script>
    document.addEventListener("DOMContentLoaded",(e)=>{
        const num = Number.parseInt(document.querySelector("#timeJ").value);
        let countDown = new Date().getTime() + num;
        let x = setInterval(function() {
            let now = new Date().getTime();
            let rest = countDown - now;
            let min = Math.floor((rest%(1000 *60*60))/(1000*60));
            let sec = Math.floor((rest%(1000 *60)) / 1000);
            document.getElementById("time").innerHTML =  min + "m " + sec + "s ";
            if (rest<=0){
                document.getElementById("time").innerHTML="LOSERR!!"
                clearInterval(x);
            }
        }, 37);

    })
</script>
</html>
