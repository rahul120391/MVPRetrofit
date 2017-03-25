package com.example.rahulkumar.mvp;

import android.app.Activity;

import java.util.Map;

import rx.Subscription;

/**
 * Created by rahulkumar on 03/11/16.
 */

public class UseCaseController<T> implements MyApiInterface, ResultInterface<T> {

    ControllerToPresenterDataTransferInterface controllerToPresenterDataTransferInterface;
    MethodClass methodClass;
    Subscription subscription;
    Activity activity;
    public UseCaseController(ControllerToPresenterDataTransferInterface controllerToPresenterDataTransferInterface,Activity activity) {
        this.controllerToPresenterDataTransferInterface = controllerToPresenterDataTransferInterface;
        this.activity=activity;
        methodClass = new MethodClass(this);
    }

    @Override
    public Subscription HitApi(Map<Object, Object> objectMap,String url) {
        subscription = methodClass.ApiProcess(objectMap, url);
        return subscription;
    }

    @Override
    public Subscription getContact(String url) {
        subscription=methodClass.ApiProcess(null,url);
        return subscription;
    }

    @Override
    public void Success(T o) {
        controllerToPresenterDataTransferInterface.transferapiResult(o);
    }

    @Override
    public void Error(Throwable e) {

    }
}
