package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.UserDto;

import org.mons.quizproject.service.QuizService;
import org.mons.quizproject.service.UserServiceImp;

import java.io.IOException;

@WebServlet(name = "register-servlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    UserServiceImp service = new UserServiceImp();
    QuizService serviceQuiz = new QuizService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("username") == null || request.getParameter("username").isEmpty() ||
                request.getParameter("firstName") == null || request.getParameter("firstName").isEmpty() ||
                request.getParameter("lastName") == null || request.getParameter("lastName").isEmpty() ||
                request.getParameter("password") == null || request.getParameter("password").isEmpty()){

            String error = "All fields are required";
            request.setAttribute("error",error);
            request.getRequestDispatcher("register.jsp").forward(request,response);


        } else {
            UserDto user = service.addUser(
                    request.getParameter("username"),
                    request.getParameter("firstName"),
                    request.getParameter("lastName"),
                    request.getParameter("password")

            );
            HttpSession session = request.getSession(true);
            session.setAttribute("question", serviceQuiz.getQuestionDTO((int)request.getSession(false).getAttribute("correctAnswers")));



            if (user != null) {
                long deadline = System.currentTimeMillis() + 60000;


                session.setAttribute("username", user.getUsername());
                session.setAttribute("id", user.getId());
                session.setAttribute("correctAnswers", 0);
                session.setAttribute("deadline", deadline);
                response.sendRedirect("play");
            } else {
                String error = "This user already exists, try to log in";
                request.setAttribute("error", error);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");

    }
}
