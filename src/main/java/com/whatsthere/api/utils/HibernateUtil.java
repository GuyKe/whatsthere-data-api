package com.whatsthere.api.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@PropertySource("classpath:app.properties")
public class HibernateUtil {

    private SessionFactory sessionFactory ;

    @Value("${hibernate.config.file}")
    private String fileLocation;


    public HibernateUtil() {
        File configFile = new File("/Users/guyk/personal_projects/whatsthere/data-api/src/resources/hibernate.cfg.xml");
        Configuration configuration = new Configuration().configure(configFile);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    @Bean
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
