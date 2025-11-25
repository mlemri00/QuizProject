package org.mons.quizproject.DTO;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionDTO {
    private String category;
    private List<String> possibleAnswers;
    private String question;
    private String difficulty;

}