package com.example.rahulkumar.mvp;

import java.util.Map;

import rx.Observable;
import rx.Subscription;

/**
 * Created by rahulkumar on 03/11/16.
 */

public interface MyApiInterface {

    Subscription HitApi(Map<Object,Object> objectMap,String url);
    Subscription getContact(String url);
}
