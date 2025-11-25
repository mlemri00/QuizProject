package org.mons.quizproject.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.mons.quizproject.models.Partida;
import org.mons.quizproject.util.ConnectionManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PartidaDaoImp {
    private EntityManager em;

    public PartidaDaoImp() {
        this.em = ConnectionManager.getEntityManager();
    }

    public List<Partida> getBestGames(){
        Query query = em.createQuery("SELECT p FROM Partida p WHERE p.puntuacion = (SELECT MAX(sub.puntuacion) FROM Partida sub WHERE sub.user_id = p.user_id) ORDER BY p.puntuacion DESC", Partida.class);
        query.setMaxResults(10);
        return query.getResultList();
    }

    public void addPartida(Partida p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
}
