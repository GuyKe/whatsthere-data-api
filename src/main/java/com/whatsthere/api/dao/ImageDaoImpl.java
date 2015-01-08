package com.whatsthere.api.dao;

import com.whatsthere.api.data.Image;
import com.whatsthere.api.data.Images;
import com.whatsthere.api.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guyk on 11/5/14.
 */
@Component
public class ImageDaoImpl implements Dao {

    @Autowired
    private  HibernateUtil hibernateUtil;


    @Override
    public Images fetchByHashtag(String hashTagText) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Image.class);
        cr.add(Restrictions.like("hashTagText", "%" + hashTagText + "%"));
        List<Image> results = cr.list();
        return getImagesList(results);
    }

    @Override
    public String fetchById(String id) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Image.class);
        cr.add(Restrictions.like("id", id));
        return cr.list().toString();
    }

    @Override
    public List<String> fetchByEqTag(String tag) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Image.class);
        cr.add(Restrictions.eq("hashTagText", tag));
        return cr.list();
    }

    @Override
    public void store(Image image) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(image);
        tx.commit();
        session.close();
    }

    private Images getImagesList(List<Image> results) {
        List<Image> imagesList = new ArrayList<Image>();
        for (Image image : results) {
            imagesList.add(image);
        }
        return new Images(imagesList);
    }


}
