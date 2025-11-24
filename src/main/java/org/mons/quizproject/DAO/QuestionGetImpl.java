package org.mons.quizproject.DAO;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import org.mons.quizproject.models.Question;

import java.util.List;

public class QuestionGetImpl {

    private final String URL = "https://the-trivia-api.com/v2/questions/";


    public List<Question> getQuestion (String difficulty){
        Client client = ClientBuilder.newClient();

        return client.target("https://the-trivia-api.com/v2/questions").request(MediaType.APPLICATION_JSON).get(new GenericType<>(){});


    }
    public List<Question>getQuestions(){
        Client client = ClientBuilder.newClient();

        return client.target("https://the-trivia-api.com/v2/questions").request(MediaType.APPLICATION_JSON).get(new GenericType<>(){});
    }

}
