package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DAO.QuestionDaoApiImpl;
import org.mons.quizproject.models.Question;
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
        req.getRequestDispatcher("start.jsp").forward(req,resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getParameter("but");

    }
}
