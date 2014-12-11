package com.whatsthere.api.transformers;

/**
 * Created by guyk on 11/8/14.
 */
public interface MessageTransformer<T> {

    public T transform(String data);
}
