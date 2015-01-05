package com.whatsthere.api.data;

import com.whatsthere.api.transformers.ToJsonTransformer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by guyk on 1/4/15.
 */
public class TagImagesMap {
   private HashMap<String,Images> map;

    public void addTagImagesMap(Images images){
        checkNotNull(images);
        map = new HashMap<String, Images>();
        for(int i =0 ; i<images.getImagesLength(); i++)
        {
            if(map.containsKey(images.getImage(i).getHashTagText())) {
                map.get(images.getImage(i).getHashTagText()).addImage(images.getImage(i));
            }
            else {
                Images imageList  = new Images();
                imageList.addImage(images.getImage(i));      ;
                map.put(images.getImage(i).getHashTagText(), imageList);
            }
        }
    }



}
