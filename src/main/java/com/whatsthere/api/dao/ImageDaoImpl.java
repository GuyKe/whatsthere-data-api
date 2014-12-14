package com.whatsthere.api.dao;

import com.whatsthere.api.data.Image;
import com.whatsthere.api.utils.HibernateUtil;
import org.hibernate.*;
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
    public List<Image> fetch(String hashTagText) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Image.class);
        cr.add(Restrictions.like("hashTagText", hashTagText));
        List<Image> results = cr.list();
        return getImagesList(results);
    }

    @Override
    public void store(Image image) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(image);
        tx.commit();
        session.close();
    }

    private List<Image> getImagesList(List<Image> results) {
        List<Image> imagesList = new ArrayList<Image>();
        for (Image image : results) {
            imagesList.add(new Image(image.getLocationOnStorage(), image.getHashTagText(), image.getFbToken(), image.getFormattedLocation(), image.getTimeOfCapture()));
        }
        return imagesList;
    }


}
