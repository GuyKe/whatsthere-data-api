package com.whatsthere.api.utils;

import com.whatsthere.api.config.ServiceConfig;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;

@Component

public class HibernateUtil {

    private SessionFactory sessionFactory ;


    @Autowired
    public HibernateUtil(ServiceConfig serviceConfig) {
        File configFile = new File(serviceConfig.getHibernateFileLocation());
        Configuration configuration = new Configuration().configure(configFile);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(builder.build());
    }


    @Bean
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


