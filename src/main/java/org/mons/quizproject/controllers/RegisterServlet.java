package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.UserDto;

import org.mons.quizproject.service.UserService;

import java.io.IOException;

@WebServlet(name = "register-servlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    UserService service = new UserService();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDto user = service.addUser(
                req.getParameter("username"),
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("password")

        );
        if(user != null){
            HttpSession session = req.getSession(true);
            session.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("start.jsp").forward(req,resp);
        } else {
            String error = "This user exists, try to log in!";
            req.setAttribute("error",error);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");

    }
}
