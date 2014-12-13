package com.whatsthere.api.manager;

import com.whatsthere.api.dao.Dao;
import com.whatsthere.api.dao.ImageDaoImpl;
import com.whatsthere.api.data.Image;
import com.whatsthere.api.data.ImageFile;
import com.whatsthere.api.exception.ImageToOldException;
import com.whatsthere.api.utils.DateTimeUtils;
import com.whatsthere.api.utils.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by guyk on 11/5/14.
 */

public class ImageStore {

    private final Dao dao = new ImageDaoImpl();
    private final DateTimeUtils dateTimeUtils = new DateTimeUtils();
    ImageFile imageFile;


    public String writeFile(byte[] fileContent) throws ImageToOldException {
        try {
            imageFile = new ImageFile(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
            return "NA";
        }
    return imageFile.getPath();
    }

    public boolean storeImage(String name, String hashTagText, String timeOfCapture
            , String fbToken, String formattedLocation) {
        Image image = new Image(name,hashTagText,fbToken,formattedLocation,timeOfCapture);
        dao.store(image);
        return false;

    }

    public Image fetchImage(int id) {
        return null;
    }
}

