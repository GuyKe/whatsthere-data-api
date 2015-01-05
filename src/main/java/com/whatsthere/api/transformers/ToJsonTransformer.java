package com.whatsthere.api.transformers;

import com.google.gson.Gson;
import com.whatsthere.api.data.Image;
import com.whatsthere.api.data.Images;
import com.whatsthere.api.data.TagImagesMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guyk on 11/8/14.
 */
@Component
public class ToJsonTransformer implements MessageTransformer<Image> {

    private static  Map<String,ArrayList<Image>> map;
    private Gson gson;
    Images images;

    public ToJsonTransformer() {
        gson = new Gson();
        images = new Images();
    }

    @Override
    public String transform(Images data) {
        images = new Images();
        StringBuilder stringBuilder = new StringBuilder();
        TagImagesMap tagImagesMap = new TagImagesMap();
        tagImagesMap.addTagImagesMap(data);
        stringBuilder.append(gson.toJson(tagImagesMap, TagImagesMap.class));
        return stringBuilder.toString();
    }

    public ToJsonTransformer(Image image) {
        // return  gson.toJsonTree(image, Image.class);
        // return new Gson();
    }

    @Bean
    public Gson getGson() {
        return gson;
    }



    public static Map<String,ArrayList<Image>> getMap() {
        return map;
    }
}