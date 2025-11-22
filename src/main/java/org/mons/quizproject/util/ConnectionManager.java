package org.mons.quizproject.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionManager {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("quizMySQL");


    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
