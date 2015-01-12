package com.whatsthere.api.dao;

import com.whatsthere.api.data.Image;
import com.whatsthere.api.data.Location;

import java.util.List;

/**
 * Created by guyk on 11/5/14.
 */
public interface Dao<T> {

    void storeImage(Image image);

    void storeLocation(Location location);

    T fetchByHashtag(String hashTagText);

    List<String> fetchByEqTag(String tag);

    T fetchById(String id);
}

