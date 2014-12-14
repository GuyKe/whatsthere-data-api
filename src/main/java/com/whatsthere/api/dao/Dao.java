package com.whatsthere.api.dao;

import com.whatsthere.api.data.Image;
import org.joda.time.LocalDateTime;

import java.util.List;

/**
 * Created by guyk on 11/5/14.
 */
public interface Dao<T> {

    void store(Image image);

    T fetch(String hashTagText);
}

