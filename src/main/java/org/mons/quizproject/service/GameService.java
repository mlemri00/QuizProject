package org.mons.quizproject.service;

import jakarta.persistence.EntityManager;
import org.mons.quizproject.DAO.GameDaoImp;
import org.mons.quizproject.DAO.UserDaoOrmImpl;
import org.mons.quizproject.DTO.GameDTO;
import org.mons.quizproject.models.Game;
import org.mons.quizproject.models.User;

import java.util.List;

public class GameService {
    UserDaoOrmImpl userDao = new UserDaoOrmImpl();
    GameDaoImp gameDao = new GameDaoImp();
    /*public List<GameDTO> getbestGames() {
        return gameDao.getBestGames()
                .stream().map();

    }
*/

    public void addGame(GameDTO gameDTO) {

        User user = userDao.getUser(1);
        Game game = new Game(user, gameDTO.getGameScore());

        gameDao.addGame(game);
    }
}
