package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class JpaManager {

    private static final String PERSISTENCE_UNIT_NAME = "persistence";
    private static EntityManager manager;
    private static EntityManagerFactory managerFactory;

    public EntityManager getManager(){
        managerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME,getDatabaseCredentials());
        manager = managerFactory.createEntityManager();
        return manager;
    }

    private Map<String,String> getDatabaseCredentials(){
        Map<String,String> config = new HashMap<>();
        config.put("jakarta.persistence.jdbc.url",System.getenv("MYSQL_PERSONAS"));
        config.put("jakarta.persistence.jdbc.user",System.getenv("MYSQL_USER"));
        config.put("jakarta.persistence.jdbc.password",System.getenv("MYSQL_PASSW"));
        return config;
    }


}
