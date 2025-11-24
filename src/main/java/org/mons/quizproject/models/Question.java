package org.mons.quizproject.models;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Question {
    private String category;
    private String id;
    private String correctAnswer;
    private List<String>incorrectAnswers;
    private questionText question;
    private List<String>tags;
    private String type;
    private String difficulty;
    private List<String>regions;
    private boolean isNiche;

    @Data
    @Getter
    public static class questionText{
        String text;

    }

}