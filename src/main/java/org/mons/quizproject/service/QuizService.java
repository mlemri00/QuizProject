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
    List <String> difficulties= List.of("easy","medium","hard");



    public QuestionDTO getQuestionDTO(int correctAnswers){

        Question question = questionDAO.getQuestion(getDifficulty(correctAnswers)).get(0);
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
    private String getDifficulty(int correctAnswers){
        if (correctAnswers>=0&&correctAnswers<3){
            return difficulties.get(0);
        } else if (correctAnswers>=3&&correctAnswers<6) {
            return difficulties.get(1);
        }else {
            return difficulties.get(2);
        }
    }







}
