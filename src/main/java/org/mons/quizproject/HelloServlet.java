package org.mons.quizproject;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mons.quizproject.DAO.QuestionDaoApiImpl;
import org.mons.quizproject.DTO.GameDTO;
import org.mons.quizproject.models.User;
import org.mons.quizproject.service.GameService;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;
    QuestionDaoApiImpl qs;
    public void init() {
        GameService gs = new GameService();
         qs = new QuestionDaoApiImpl();
        message = "Hello World!";
        User user = new User("test","test","test","test");


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