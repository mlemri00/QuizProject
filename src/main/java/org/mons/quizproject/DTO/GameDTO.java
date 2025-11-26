package org.mons.quizproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.mons.quizproject.models.Game;
import org.mons.quizproject.models.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {
    private long id;
    private long user_id;
    private String username;
    private int gameScore;
    public GameDTO(int gameScore, int user_id){
        this.user_id=user_id;
        this.gameScore=gameScore;
    }


}

