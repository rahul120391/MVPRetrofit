package com.example.rahulkumar.mvp;

import android.app.Activity;
import android.widget.Toast;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by rahulkumar on 03/11/16.
 */

public class MyPresenter implements ControllerToPresenterDataTransferInterface {

    MainActivity mainActivity;
    MainActivity myactivity;
    UseCaseController useCaseController;
    CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Inject
    public MyPresenter(Activity activity) {
        myactivity = (MainActivity) activity;
        useCaseController = new UseCaseController(this,activity);
    }


    public void intializeView(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


    public void getResults(Map<Object, Object> objectMap,String url) {
        if (Utils.checkInternetConnection(mainActivity)) {
            ProgressDialogg.ShowDialog(mainActivity);
            compositeSubscription.add(useCaseController.HitApi(objectMap,url));
        } else {
            myactivity.ShowErrorDialog("CONNECTION ERROR", "Please check your internetconnection", "OK", "CANCEL");
        }
    }

    public void getContacts


    @Override
    public void transferapiResult(Object o) {
        if(o!=null){
            try{
                ObjectMapper mapper=new ObjectMapper();
                Github github = mapper.convertValue(o,Github.class);
                if(github!=null){
                    String blog=github.getBlog();
                    Toast.makeText(mainActivity, "blog is"+blog, Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(mainActivity, "github is null", Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }


        }

    }

    @Override
    public void transferError(Throwable e) {
        if(e!=null && e.getMessage()!=null && !e.getMessage().equalsIgnoreCase("")){
            myactivity.ShowErrorDialog("ERROR", e.getMessage(), "OK", "CANCEL");
        }

    }

    public void Destroy() {
        if (compositeSubscription != null && !compositeSubscription.isUnsubscribed()) {
            compositeSubscription.unsubscribe();
            compositeSubscription.clear();
        }
        intializeView(null);
    }

}
