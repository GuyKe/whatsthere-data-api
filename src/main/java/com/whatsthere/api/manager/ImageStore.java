package com.whatsthere.api.manager;

import com.whatsthere.api.dao.Dao;
import com.whatsthere.api.dao.ImageDaoImpl;
import com.whatsthere.api.data.Image;
import com.whatsthere.api.data.ImageFile;
import com.whatsthere.api.exception.ImageToOldException;
import com.whatsthere.api.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guyk on 11/5/14.
 */

public class ImageStore {

    private final Dao dao;
    private final DateTimeUtils dateTimeUtils = new DateTimeUtils();
    ImageFile imageFile;

    @Autowired
    public ImageStore(ImageDaoImpl dao) {
        this.dao = dao;
    }

    public String writeFile(byte[] fileContent) throws ImageToOldException {
        try {
            imageFile = new ImageFile(fileContent);
        } catch (IOException e) {
            e.printStackTrace();
            return "NA";
        }
    return imageFile.getPath();
    }

    public boolean storeImage(String locationOnStorage, String hashTagText, String timeOfCapture
            , String fbToken, String formattedLocation) {
        Image image = new Image(locationOnStorage,hashTagText,fbToken,formattedLocation,timeOfCapture);
        dao.store(image);
        return true;

    }

    public List<Image> fetchImageByHashtag(String hashTagText) {
        return (List<Image>) dao.fetch(hashTagText);
    }
}

