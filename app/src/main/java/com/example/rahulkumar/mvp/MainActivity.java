package com.example.rahulkumar.mvp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import component.DaggerActivityComponent;
import module.ActivityLevelModule;

public class MainActivity extends AppCompatActivity implements MyViewInterface {

    @Inject
    Activity activity;

    @Inject
    MyPresenter presenter;

    ErrorDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intializeDependencyInjector();
        if (presenter != null) {
            presenter.intializeView(this);
        }
        Map<Object,Object> map=new HashMap<>();
        map.put("login","linkedin");
        presenter.getResults(map,URLS.LOGIN);
    }


    public void intializeDependencyInjector() {
        DaggerActivityComponent.builder().activityLevelModule(new ActivityLevelModule(this)).build().inject(this);
    }


    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.Destroy();
        }
        super.onDestroy();
    }


    @Override
    public void ShowErrorDialog(String title,String message,String button1,String button2) {
        if(dialog==null){
            dialog=new ErrorDialog(activity,R.style.AppCompatAlertDialogStyle);
        }
        dialog.ShowDialog(title,message,button1,button2);
    }
}
