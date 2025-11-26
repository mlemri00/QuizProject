package org.mons.quizproject.service;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.mons.quizproject.DAO.QuestionDaoApiImpl;
import org.mons.quizproject.DTO.QuestionDTO;
import org.mons.quizproject.models.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizService {
    QuestionDaoApiImpl questionDAO = new QuestionDaoApiImpl();
    QuestionDTO questionDTO;
    List <String> Difficulties= List.of("easy","medium","hard");



    public QuestionDTO getQuestionDTO(){
        Question question = questionDAO.getQuestion("hard").get(0);
        return convQuestionDTO(question);
    }

    private QuestionDTO convQuestionDTO(Question question){
        List<String> allAnswers =  new ArrayList<>();
        allAnswers.addAll(question.getIncorrectAnswers());
        allAnswers.add(question.getCorrectAnswer());
        Collections.shuffle(allAnswers);


        return new QuestionDTO(question.getCategory(),
                allAnswers,
                question.getQuestion().getText(),
                question.getDifficulty(),
                question.getIncorrectAnswers(),
                question.getCorrectAnswer());
    }

    public boolean validarRespuesta(QuestionDTO ques, String respuesta){
        return ques.getCorrectAnswer().equals(respuesta);
    }








}
