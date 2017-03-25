package com.example.rahulkumar.mvp;

/**
 * Created by rahulkumar on 04/11/16.
 */

public interface ResultInterface<T> {

    void Success(T t);
    void Error(Throwable e);
}
