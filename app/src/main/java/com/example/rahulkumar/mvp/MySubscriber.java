package com.example.rahulkumar.mvp;

import android.icu.text.RelativeDateTimeFormatter;

import rx.Subscriber;


/**
 * Created by rahulkumar on 04/11/16.
 */

public class MySubscriber<T> extends Subscriber<T> {

    ResultInterface resultInterface;
    public MySubscriber(ResultInterface resultInterface){
        this.resultInterface=resultInterface;
    }
    @Override
    public void onCompleted() {
        ProgressDialogg.DismissDialog();
    }

    @Override
    public void onError(Throwable e) {
        ProgressDialogg.DismissDialog();
        resultInterface.Error(e);
    }

    @Override
    public void onNext(T t) {
        ProgressDialogg.DismissDialog();
        resultInterface.Success(t);
    }
}
