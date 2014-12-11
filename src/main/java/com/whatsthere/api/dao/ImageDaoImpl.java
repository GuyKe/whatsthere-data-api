package com.whatsthere.api.dao;

import com.whatsthere.api.data.Image;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.LocalDateTime;

import java.util.List;

/**
 * Created by guyk on 11/5/14.
 */
public class ImageDaoImpl implements Dao {


    @Override
    public void fetch(String imageId) {

    }

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void store(Image image) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(image);
        tx.commit();
        session.close();
    }


}
