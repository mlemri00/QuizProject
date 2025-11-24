package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.models.Question;
import org.mons.quizproject.service.QuizService;

import java.io.IOException;

import static jdk.vm.ci.hotspot.JFR.Ticks.now;

@WebServlet(name="QuizServlet", value="/quiz")
public class QuizServlet extends HttpServlet {

    private QuizService service = new QuizService();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Question q = service.getQuestion();


        req.setAttribute("question", q);
        resp.sendRedirect("index.jsq");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        long creationTime = session.getCreationTime();

        if(session.getAttribute("timeLeft") == null) {
            session.setAttribute("timeLeft", 60);
        }



        Question q = (Question) req.getAttribute("question");
        String resposta =  req.getParameter("resposta");

        boolean acertada = service.validarResposta(q, resposta);
        if(acertada) {
            session.setAttribute("timeLeft",(Long) session.getAttribute("timeLeft")+10);
        } else  {
            session.setAttribute("timeLeft",(Long) session.getAttribute("timeLeft") -10 );
        }
        long actual = now();
        Long timeLess = actual-creationTime;
        session.setAttribute("timeLeft", (Long) session.getAttribute("timeLeft") - timeLess);
        long time = (long) session.getAttribute("timeLeft");
        if(timeLess<=0) {
            session.invalidate();
            resp.sendRedirect("login");
        }

    }
}
