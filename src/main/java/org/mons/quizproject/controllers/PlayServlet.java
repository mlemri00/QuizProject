package org.mons.quizproject.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mons.quizproject.DTO.PartidaDTO;
import org.mons.quizproject.DTO.QuestionDTO;
import org.mons.quizproject.service.GameService;
import org.mons.quizproject.service.QuizService;
import org.mons.quizproject.service.UserService;

import java.io.IOException;




@WebServlet(name="play-servlet", value="/play")
public class PlayServlet extends HttpServlet {

    private QuizService quizService = new QuizService();
    private GameService gameService = new GameService();
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("post")){
            if (req.getParameter("type").equalsIgnoreCase("init")){
               initTimeDeadline(req, resp);
            }else{
                doPost(req, resp);
            }
        }else{
            doGet(req, resp);
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if((long)req.getSession().getAttribute("deadline")<System.currentTimeMillis()) {
            saveGame(req);
            resp.sendRedirect(req.getContextPath() + "/ranking");
        }else {
            QuestionDTO questionDTO = quizService.getQuestionDTO();
            req.getSession().setAttribute("questionDTO", questionDTO);
            req.setAttribute("category", questionDTO.getCategory());
            req.setAttribute("answers", questionDTO.getPossibleAnswers());
            req.setAttribute("question", questionDTO.getQuestion());
            req.setAttribute("difficulty", questionDTO.getDifficulty());
            req.setAttribute("time", ((long) req.getSession().getAttribute("deadline")) - System.currentTimeMillis());


            req.getRequestDispatcher("game.jsp").forward(req, resp);
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String resposta =  req.getParameter("ans");
        QuestionDTO questionDTO = (QuestionDTO) session.getAttribute("questionDTO");
        if(questionDTO == null){
            System.out.println("Question DTO is null");

        }
        if((long)session.getAttribute("deadline")<System.currentTimeMillis()){
            saveGame(req);
            resp.sendRedirect(req.getContextPath()+"/ranking");

        } else {
            if (quizService.validarRespuesta(questionDTO, resposta)) {
                long deadline = (long) session.getAttribute("deadline");
                deadline = deadline + (10 * 1000);
                session.setAttribute("deadline", deadline);

                resp.sendRedirect(req.getContextPath() + "/play");
            } else{
                long deadline = (long) session.getAttribute("deadline");
                deadline = deadline - (10 * 1000);
                session.setAttribute("deadline", deadline);

                resp.sendRedirect(req.getContextPath() + "/play");

            }
        }
    }

    private void saveGame(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        int puntuacion = (int)(System.currentTimeMillis() - (long) session.getAttribute("createdAt"))/1000;
        System.out.println("---------------------------------GAME-SAVED-------------------------------------");
        gameService.addPartida(new PartidaDTO(
                        0,
                        puntuacion,
                        Math.toIntExact(
                                userService.getUser(
                                        (String) session.getAttribute("username")).getId()
                        )
                )
        );

        session.removeAttribute("createdAt");
    }
    private void initTimeDeadline(HttpServletRequest req, HttpServletResponse resp){
        HttpSession session = req.getSession();
        long deadline = System.currentTimeMillis() + 60000;

        session.setAttribute("deadline", deadline);
        session.setAttribute("createdAt",System.currentTimeMillis());


    }


}
