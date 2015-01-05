package com.whatsthere.api.data;

import java.util.ArrayList;
import java.util.List;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by guyk on 12/15/14.
 */
public class Images {
    ArrayList<Image> images;

    public Images(List<Image> list) {
        images = new ArrayList<Image>();
        for(Image image : list) {
            images.add(image);
        }
    }

    public Images() {
        images = new ArrayList<Image>();
    }

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

    public Image getImage(int index) {
        return images.get(index);
    }

    public int getImagesLength() {
        return images.size();
    }


}
