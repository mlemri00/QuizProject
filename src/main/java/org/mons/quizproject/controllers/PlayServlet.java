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




@WebServlet(name="play-servlet", value="/play")
public class PlayServlet extends HttpServlet {

    private QuizService service = new QuizService();



    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((long)req.getSession().getAttribute("deadline")<System.currentTimeMillis()) {
            resp.sendRedirect(req.getContextPath() + "/end");
        }else {
            QuestionDTO questionDTO = service.getQuestionDTO();
            req.getSession().setAttribute("questionDTO", questionDTO);
            req.setAttribute("category", questionDTO.getCategory());
            req.setAttribute("answers", questionDTO.getPossibleAnswers());
            req.setAttribute("question", questionDTO.getQuestion());
            req.setAttribute("difficulty", questionDTO.getDifficulty());
            req.setAttribute("time", ((long) req.getSession().getAttribute("deadline")) - System.currentTimeMillis());


            req.getRequestDispatcher("game.jsp").forward(req, resp);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String resposta =  req.getParameter("ans");
        QuestionDTO questionDTO = (QuestionDTO) session.getAttribute("questionDTO");
        if(questionDTO == null){
            System.out.println("Question DTO is null");

        }
        if((long)session.getAttribute("deadline")<System.currentTimeMillis()){

            resp.sendRedirect(req.getContextPath()+"/end");

        } else {
            if (service.validarRespuesta(questionDTO, resposta)) {
                long deadline = (long) session.getAttribute("deadline");
                deadline = deadline + (10 * 1000);
                session.setAttribute("deadline", deadline);

                resp.sendRedirect(req.getContextPath() + "/play");
            } else{
                long deadline = (long) session.getAttribute("deadline");
                deadline = deadline - (10 * 1000);
                session.setAttribute("deadline", deadline);

                resp.sendRedirect(req.getContextPath() + "/play");

            }
        }





    }
}
