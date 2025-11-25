package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mons.quizproject.DTO.QuestionDTO;
import org.mons.quizproject.service.QuizService;

import java.io.IOException;




@WebServlet(name="QuizServlet", value="/quiz")
public class QuizServlet extends HttpServlet {

    private QuizService service = new QuizService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("post")){

        }else{
            resp.sendRedirect("quiz");
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDTO questionDTO = service.getQuestionDTO();
        req.setAttribute("category",questionDTO.getCategory());
        req.setAttribute("answers",questionDTO.getPossibleAnswers());



        req.getRequestDispatcher("start.jsp").forward(req,resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




    }
}
