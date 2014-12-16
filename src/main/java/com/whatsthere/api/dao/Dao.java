package com.whatsthere.api.dao;

import com.whatsthere.api.data.Image;

/**
 * Created by guyk on 11/5/14.
 */
public interface Dao<T> {

    void store(Image image);

    T fetch(String hashTagText);
}

