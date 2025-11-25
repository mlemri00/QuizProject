package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.QuestionDTO;
import org.mons.quizproject.service.QuizService;

import java.io.IOException;




@WebServlet(name="QuizServlet", value="/quiz")
public class QuizServlet extends HttpServlet {

    private QuizService service = new QuizService();



    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDTO questionDTO = service.getQuestionDTO();
        req.setAttribute("questionDTO", questionDTO);
        req.setAttribute("category",questionDTO.getCategory());
        req.setAttribute("answers",questionDTO.getPossibleAnswers());
        req.setAttribute("question",questionDTO.getQuestion());
        req.setAttribute("difficulty",questionDTO.getDifficulty());


        req.getRequestDispatcher("game.jsp").forward(req,resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String resposta =  req.getParameter("ans");
        QuestionDTO questionDTO = (QuestionDTO) req.getAttribute("question");
        if((long)session.getAttribute("deadline")>System.currentTimeMillis()){
            session.invalidate();
            resp.sendRedirect(req.getContextPath()+"/end");
        } else {
            if (service.validarRespuesta(questionDTO, resposta)) {
                long deadline = (long) session.getAttribute("deadline");
                deadline = deadline + (10 * 1000);
                session.setAttribute("deadline", deadline);

                resp.sendRedirect(req.getContextPath() + "/quiz");
            } else{
                long deadline = (long) session.getAttribute("deadline");
                deadline = deadline - (10 * 1000);
                session.setAttribute("deadline", deadline);

                resp.sendRedirect(req.getContextPath() + "/quiz");

            }
        }





    }
}
