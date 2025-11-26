package org.mons.quizproject.controllers;


import com.google.common.hash.Hashing;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.UserDto;
import org.mons.quizproject.service.UserService;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@WebServlet(name="login-servlet", value= "/login")
public class LoginServlet  extends HttpServlet {
    UserService service;


    @Override
    public  void init(){
        service = new UserService();

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(Objects.equals(req.getParameter("__method"), "POST")) {
            String username = req.getParameter("username");
            UserDto user = service.getUser(username);

            String password = Hashing.sha256()
                    .hashString(req.getParameter("password"), StandardCharsets.UTF_8)
                    .toString();

            if (!service.validateUser(user, password) || user == null) {
                System.out.println("no valia o user es null");
                String error = "Invalid username or password";
                req.setAttribute("error", error);
                resp.sendRedirect("login.jsp");


            } else if (service.validateUser(user, password)) {


                HttpSession session = req.getSession(true);
                session.setAttribute("username", user.getUsername());
                req.getRequestDispatcher("start.jsp");

            }

        } else if(Objects.equals(req.getParameter("__method"), "DELETE")) {
            if(req.getSession(false).getAttribute("username") == null) {
                resp.sendRedirect("login.jsp");
            } else {
                req.getSession(false).invalidate();
                resp.sendRedirect("login.jsp");

            }

        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");

    }
}
