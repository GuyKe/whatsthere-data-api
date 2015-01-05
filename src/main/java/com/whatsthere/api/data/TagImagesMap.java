package com.whatsthere.api.data;

import java.util.HashMap;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by guyk on 1/4/15.
 */
public class TagImagesMap {
   private HashMap<String,Images> hashTag;

    public void addTagImagesMap(Images images){
        checkNotNull(images);
        hashTag = new HashMap<String, Images>();
        for(int i =0 ; i<images.getImagesLength(); i++)
        {
            if(hashTag.containsKey(images.getImage(i).getHashTagText())) {
                hashTag.get(images.getImage(i).getHashTagText()).addImage(images.getImage(i));
            }
            else {
                Images imageList  = new Images();
                imageList.addImage(images.getImage(i));      ;
                hashTag.put(images.getImage(i).getHashTagText(), imageList);
            }
        }
    }



}
