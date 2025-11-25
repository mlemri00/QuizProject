package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.PartidaDTO;
import org.mons.quizproject.models.Juego;
import org.mons.quizproject.service.GameService;
import org.mons.quizproject.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name="ranking-servlet", value="/ranking")

public class RankingServlet extends HttpServlet {
    GameService gameService = new GameService();
    UserService userService = new UserService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Juego> juegos = gameService.mejoresPartidas();
        req.setAttribute("juegos", juegos);

        if(juegos == null){
            System.out.println("No games found");
        } else{
            System.out.println(juegos);
        }

        req.getRequestDispatcher("end.jsp").forward(req,resp);

    }
}
