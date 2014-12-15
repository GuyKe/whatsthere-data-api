package com.whatsthere.api.transformers;

import com.whatsthere.api.data.Image;
import com.google.gson.Gson;
import com.whatsthere.api.data.Images;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by guyk on 11/8/14.
 */
@Component
public class ToJsonTransformer implements MessageTransformer {

    private Gson gson;
    Images images;

    public ToJsonTransformer() {
        gson = new Gson();
        images = new Images();
    }

    @Override
    public String transform(List data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object image : data) {
            images.addImage((Image) image);
        }
        stringBuilder.append(gson.toJson(images, Images.class));
        return stringBuilder.toString();
    }

    public  ToJsonTransformer(Image image) {
       // return  gson.toJsonTree(image, Image.class);
     // return new Gson();
    }

    @Bean
    public Gson getGson(){
        return gson;
    }


}
