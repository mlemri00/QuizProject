package org.mons.quizproject.service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.mons.quizproject.DAO.QuestionDaoApiImpl;
import org.mons.quizproject.DTO.QuestionDTO;
import org.mons.quizproject.models.Question;

public class QuizService {
    QuestionDaoApiImpl questionDAO = new QuestionDaoApiImpl();
    QuestionDTO questionDTO;




    public QuestionDTO getQuestionDTO(){
        Question question = questionDAO.getQuestion("hard").get(0);




    }







}
