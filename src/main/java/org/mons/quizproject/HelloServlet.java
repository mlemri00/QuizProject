package org.mons.quizproject;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mons.quizproject.DAO.QuestionDaoApiImpl;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    QuestionDaoApiImpl qs;
    public void init() {

         qs = new QuestionDaoApiImpl();
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html>"+"<body>");
        out.println("<h1>Hello" + qs.getQuestion("hard").get(0).getQuestion().getText() +"</h1>");
        out.println("</body>prprpddrprprppr</html>");
    }

    public void destroy() {
    }
}