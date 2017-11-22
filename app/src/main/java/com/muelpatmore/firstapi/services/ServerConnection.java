package com.muelpatmore.firstapi.services;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.muelpatmore.firstapi.util.constants.API_List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Samuel on 22/11/2017.
 */

public class ServerConnection {
    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;

    public static RequestInterface getServerConnection() {
        retrofit =new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
                // Adapter factor required to display data in RecyclerView
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(API_List.BASE_URL)
        .build();
        return retrofit.create(RequestInterface.class);
    }
}
