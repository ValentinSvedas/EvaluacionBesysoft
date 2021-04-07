package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private final EntityManagerFactory entityManagerFactory;

    private static final ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        entityManagerFactory = Persistence.createEntityManagerFactory("EvaluacionBesysoft");
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
