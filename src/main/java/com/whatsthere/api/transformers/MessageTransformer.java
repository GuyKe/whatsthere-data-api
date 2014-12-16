package com.whatsthere.api.transformers;

import java.util.List;

/**
 * Created by guyk on 11/8/14.
 */
public interface MessageTransformer<T> {

    public String transform(List<T> data);
}
