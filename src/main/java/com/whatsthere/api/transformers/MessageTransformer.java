package com.whatsthere.api.transformers;

import com.whatsthere.api.data.Image;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guyk on 11/8/14.
 */
public interface MessageTransformer<T> {

    public String transform(List<T> data);
}
