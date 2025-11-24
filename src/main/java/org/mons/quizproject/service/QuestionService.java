package org.mons.quizproject.service;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

import java.util.*;

public class QuestionService {


    public static void main(String[] args) {



    }

    public List<Question>getQuestions(){
        Client client = ClientBuilder.newClient();

        return client.target("https://the-trivia-api.com/v2/questions").request(MediaType.APPLICATION_JSON).get(new GenericType<>(){});
    }

}
