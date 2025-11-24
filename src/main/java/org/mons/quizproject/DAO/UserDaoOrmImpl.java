package org.mons.quizproject.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.mons.quizproject.models.User;
import org.mons.quizproject.util.ConnectionManager;

public class UserDaoOrmImpl {
    private EntityManager em;

    public UserDaoOrmImpl() {
        this.em = ConnectionManager.getEntityManager();
    }

    public User getUser(String username) {

        try{
            Query query = em.createQuery("select u from User u where u.username = :username");
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();

            return user;

        } catch (Exception e) {
            return null;
        }


    }

    public User addUser(User user) {
        try{
            em.getTransaction().begin();
            em.persist(user);

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
        em.getTransaction().commit();
        return user;
    }
}
