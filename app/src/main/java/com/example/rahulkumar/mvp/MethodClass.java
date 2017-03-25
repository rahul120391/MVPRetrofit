package com.example.rahulkumar.mvp;

import java.util.Map;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rahulkumar on 03/11/16.
 */

public class MethodClass<T> {

    MyService myService;
    Subscription subscription;
    ResultInterface result;
    public MethodClass(ResultInterface result) {
        if (myService == null) {
            myService=ServiceFactory.createRetrofitService(MyService.class,URLS.ENDPOINT);
        }
        this.result=result;
    }


    public Subscription ApiProcess(Map<Object,Object> map,String url){
        switch (url){
            case URLS.LOGIN:
                subscription=myService.getUser(map.get("login").toString()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new MySubscriber(result));
                break;
            case URLS.CONTACTS:
                subscription=myService.getContacts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new MySubscriber(result));
                break;
        }
        return subscription;
    }

}
