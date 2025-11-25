package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.PartidaDTO;
import org.mons.quizproject.models.Juego;
import org.mons.quizproject.service.PartidaService;
import org.mons.quizproject.service.UserServiceImp;

import java.io.IOException;
import java.util.List;

@WebServlet(name="ranking-servlet", value="/ranking")

public class RankingServlet extends HttpServlet {
    PartidaService ps = new PartidaService();
    UserServiceImp us = new UserServiceImp();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        int puntuacion = (int)(System.currentTimeMillis() - session.getCreationTime())/1000;

        ps.addPartida(new PartidaDTO(0,puntuacion, Math.toIntExact(us.getUser((String) session.getAttribute("username")).getId())));
        List<Juego> juegos = ps.mejoresPartidas();
        req.setAttribute("juegos", juegos);

        if(juegos == null){
            System.out.println("No games found");
        } else{
            System.out.println(juegos);
        }

        session.invalidate();
        req.getRequestDispatcher("end.jsp").forward(req,resp);

    }
}
