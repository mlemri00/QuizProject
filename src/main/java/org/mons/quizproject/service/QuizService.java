package org.mons.quizproject.service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.mons.quizproject.DAO.QuestionDaoApiImpl;
import org.mons.quizproject.DTO.QuestionDTO;

public class QuizService {
    QuestionDaoApiImpl questionDAO = new QuestionDaoApiImpl();
    QuestionDTO questionDTO;






    public HttpServletRequest setRequestAttributes(HttpServletRequest req){

    return req;

    }








}
