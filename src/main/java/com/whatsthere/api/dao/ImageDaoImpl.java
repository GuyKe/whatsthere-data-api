package com.whatsthere.api.dao;

import com.whatsthere.api.data.Image;
import com.whatsthere.api.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * Created by guyk on 11/5/14.
 */
public class ImageDaoImpl implements Dao {

    private final HibernateUtil hibernateUtil;

    private static SessionFactory sessionFactory;


    public ImageDaoImpl() {
        hibernateUtil = new HibernateUtil();
        this.sessionFactory = hibernateUtil.getSessionFactory();
    }

    @Override
    public void fetch(String imageId) {

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
