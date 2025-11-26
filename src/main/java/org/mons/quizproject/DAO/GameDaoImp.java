package org.mons.quizproject.DAO;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.mons.quizproject.models.Game;
import org.mons.quizproject.util.ConnectionManager;

import java.util.List;

public class GameDaoImp {


    public GameDaoImp() {

    }

    public List<Game> getBestGames(){
        EntityManager em = ConnectionManager.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Game p WHERE p.gameScore = (SELECT MAX(sub.gameScore) FROM Game sub WHERE sub.userId = p.userId) ORDER BY p.gameScore DESC", Game.class);
        query.setMaxResults(10);

        List<Game> games = query.getResultList();
        em.close();
        return query.getResultList();
    }

    public void addGame(Game p){
        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
    }
}
