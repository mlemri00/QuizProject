package org.mons.quizproject;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mons.quizproject.services.Question;
import org.mons.quizproject.services.QuestionService;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    QuestionService qs;
    public void init() {

         qs = new QuestionService();
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html>"+"<body>");
        out.println("<h1>" + message+qs.getQuestions().get(1).getQuestion() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}