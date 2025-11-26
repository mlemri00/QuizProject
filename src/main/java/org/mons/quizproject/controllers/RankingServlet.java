package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.GameDTO;
import org.mons.quizproject.DTO.UserDto;
import org.mons.quizproject.models.Game;
import org.mons.quizproject.models.User;
import org.mons.quizproject.service.GameService;
import org.mons.quizproject.service.UserServiceImp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@WebServlet(name="ranking-servlet", value="/ranking")

public class RankingServlet extends HttpServlet {
    GameService gameService = new GameService();
    UserServiceImp us = new UserServiceImp();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Crear session usuario
        HttpSession session = req.getSession();
        String username = session.getAttribute("username").toString();
        int id =(int)((long) session.getAttribute("id"));
        int gameScore = (int)(System.currentTimeMillis() - session.getCreationTime())/1000;


        //Guardar partida en la base de datos
        gameService.addGame(new GameDTO(gameScore, id));

        //Extracción de las partidas de la BD
        // List<GameDTO> games = gameService.getbestGames();

        // Enviar a ranking.jsp la informació  de la query
        List<Game>games = new ArrayList<>();
        req.setAttribute("games", games);

        if(games == null){
            System.out.println("No games found");
        } else{
            System.out.println(games);
        }

        session.invalidate();
        req.getRequestDispatcher("ranking.jsp").forward(req,resp);

    }
}
