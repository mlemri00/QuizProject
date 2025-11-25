package org.mons.quizproject.service;

import org.mons.quizproject.DAO.PartidaDaoImp;
import org.mons.quizproject.DAO.UserDaoOrmImpl;
import org.mons.quizproject.DTO.PartidaDTO;
import org.mons.quizproject.models.Juego;
import org.mons.quizproject.models.Partida;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class PartidaService {
    UserDaoOrmImpl userDaoOrm = new UserDaoOrmImpl();
    PartidaDaoImp partidaDao = new PartidaDaoImp();

    public List<Juego> mejoresPartidas() {
        return partidaDao.getBestGames()
                .stream().map(p-> new Juego(p.getId(),p.getPuntuacion(),userDaoOrm.getUser(p.getUser_id()).getUsername())).collect(toList());

    }

    public void addPartida(PartidaDTO p) {
        Partida partida = new Partida(
                0,
                p.getPuntuacion(),
                (int) p.getUser_id()
        );

        partidaDao.addPartida(partida);
    }
}
