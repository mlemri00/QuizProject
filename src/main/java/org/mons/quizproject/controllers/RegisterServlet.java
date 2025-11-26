package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.UserDto;

import org.mons.quizproject.service.UserServiceImp;

import java.io.IOException;

@WebServlet(name = "register-servlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    UserServiceImp service = new UserServiceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDto user = service.addUser(
                request.getParameter("username"),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("password")

        );
        if(user != null){
            long deadline = System.currentTimeMillis() + 60000;

            HttpSession session = request.getSession(true);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("id",user.getId());
            session.setAttribute("deadline", deadline);
            response.sendRedirect("play");
        } else {
            String error = "This user already exists, try to log in";
            request.setAttribute("error",error);
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("register.jsp");

    }
}
