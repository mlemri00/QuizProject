package org.mons.quizproject.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.mons.quizproject.models.Game;
import org.mons.quizproject.util.ConnectionManager;

import java.util.List;

public class GameDaoImp {
    private EntityManager em;

    public GameDaoImp() {
        this.em = ConnectionManager.getEntityManager();
    }

    public List<Game> getBestGames(){
        Query query = em.createQuery("SELECT p FROM Game p WHERE p.gameScore = (SELECT MAX(sub.gameScore) FROM Game sub WHERE sub.userId = p.userId) ORDER BY p.gameScore DESC", Game.class);
        query.setMaxResults(10);

        List<Game> games = query.getResultList();
        return query.getResultList();
    }

    public void addGame(Game p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
}
