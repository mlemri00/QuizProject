package org.mons.quizproject.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.mons.quizproject.models.User;
import org.mons.quizproject.util.ConnectionManager;

import java.util.List;

public class UserDaoOrmImpl {


    public User getUser(String username) {
        EntityManager em = ConnectionManager.getEntityManager();
        try{
            Query query = em.createQuery("select u from User u where u.username = :username");
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();
            em.close();
            return user;

        } catch (Exception e) {
            return null;
        }


    }

    public User getUser(int id) {
        EntityManager em = ConnectionManager.getEntityManager();
        try{
            User user = em.find(User.class, id);
            em.close();
            return user;

        } catch (Exception e) {
            em.close();
            throw new RuntimeException(e);
        }

    }

    public User addUser(User user) {
        EntityManager em = ConnectionManager.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(user);
        } catch (Exception e) {
            em.getTransaction().rollback();

            throw new RuntimeException(e);
        }
        em.getTransaction().commit();

        User userCheck = getUser(user.getUsername());

        em.close();
        return userCheck;
    }
}
