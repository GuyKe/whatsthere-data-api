package com.whatsthere.api.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory ;
    static {
        File configFile = new File("/Users/guyk/personal_projects/whatsthere/data-api/src/resources/hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure(configFile);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    @Bean
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
