package com.karol;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
    private static final String PERSISTENCE_UNIT_NAME = "persistance-unit-h2";
    private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private static final ThreadLocal<EntityManager> threadLocal = new ThreadLocal<>();

    public static EntityManager getEntityManager() {
        EntityManager em = threadLocal.get();
        if (em == null) {
            em = emFactory.createEntityManager();
            threadLocal.set(em);
        }

        return em;
    }

}
