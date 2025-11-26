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
        Query query = em.createQuery("SELECT p FROM Game p WHERE p.gameScore = (SELECT MAX(sub.gameScore) FROM Game sub WHERE sub.user.id = p.user.id) ORDER BY p.gameScore DESC, p.correctAnswers DESC ", Game.class);
        query.setMaxResults(10);

        List<Game> games = query.getResultList();
        em.close();
        return games;
    }

    public void addGame(Game p){
        EntityManager em = ConnectionManager.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(p);
        }catch (Exception e){
            em.getTransaction().rollback();
        }
        em.getTransaction().commit();
        em.close();
    }
}
