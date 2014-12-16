package com.whatsthere.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.util.ArrayList;

/**
 * Created by guyk on 12/16/14.
 */
@Configuration
public class ServiceConfig {


    @Value("${hibernate.config.file}")
    private String hibernateFileLocation;




    @Bean
        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

            PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
            propertySourcesPlaceholderConfigurer.setNullValue("@null");
            propertySourcesPlaceholderConfigurer.setLocalOverride(true);
            propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
            propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);


            ArrayList<Resource> resources = new ArrayList<Resource>();
            resources.add(new FileSystemResource("/whatsthere/config/app.properties"));

            String localAppConfigPath = System.getProperty("APP_CONFIG");
            if (localAppConfigPath != null) {
                resources.add(new FileSystemResource(localAppConfigPath));
            }
            Resource[] locations = resources.toArray(new Resource[0]);
            propertySourcesPlaceholderConfigurer.setLocations(locations);

            propertySourcesPlaceholderConfigurer.setOrder(0);
            return propertySourcesPlaceholderConfigurer;
        }

    public String getHibernateFileLocation() {
        return hibernateFileLocation;
    }

}