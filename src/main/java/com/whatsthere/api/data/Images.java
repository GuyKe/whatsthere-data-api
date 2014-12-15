package com.whatsthere.api.data;

import java.util.ArrayList;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by guyk on 12/15/14.
 */
public class Images {
    ArrayList<Image> images;

    public ArrayList<Image> getImages() {
        checkNotNull(images);
        return this.images;
    }

    public void addImage(Image image) {
        if (images == null) {
            images = new ArrayList<Image>();
        }
        images.add(image);
    }


}
