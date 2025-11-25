package org.mons.quizproject.controllers;


import com.google.common.hash.Hashing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.UserDto;
import org.mons.quizproject.service.UserServiceImp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet(name="login-servlet", value= "/login")
public class LoginServlet  extends HttpServlet {
    UserServiceImp service;


    @Override
    public  void init(){
        service = new UserServiceImp();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(Objects.equals(request.getParameter("__method"), "POST")) {
            String username = request.getParameter("username");
            UserDto user = service.getUser(username);

            String password = Hashing.sha256()
                    .hashString(request.getParameter("password"), StandardCharsets.UTF_8)
                    .toString();

            if (!service.validateUser(user, password) || user == null) {
                System.out.println("no valia o user es null");
                String error = "Invalid username or password";
                request.setAttribute("error", error);
                response.sendRedirect("login.jsp");


            } else if (service.validateUser(user, password)) {
                long deadline = System.currentTimeMillis() + 60000;

                HttpSession session = request.getSession(true);
                session.setAttribute("username", user.getUsername());
                session.setAttribute("deadline", deadline);
                response.sendRedirect("play");

            }

        } else if(Objects.equals(request.getParameter("__method"), "DELETE")) {
            if(request.getSession(false).getAttribute("username") == null) {
                response.sendRedirect("login.jsp");
            } else {
                request.getSession(false).invalidate();
                response.sendRedirect("login.jsp");

            }

        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");

    }
}
