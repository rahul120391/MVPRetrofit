package com.example.rahulkumar.mvp;


import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by rahulkumar on 03/11/16.
 */

public interface MyService<T> {

    @GET(URLS.LOGIN)
    Observable<T> getUser(@Path("login") String login);

    @GET(URLS.CONTACTS)
    Observable<T> getContacts();
}
