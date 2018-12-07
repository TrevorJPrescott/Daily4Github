package com.trevorpc.daily4_github.clients;

import android.util.Log;

import com.google.gson.Gson;
import com.trevorpc.model.InfoResponse;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpHelper {

    public static final String TAG = OkHttpHelper.class.getSimpleName() + "_TAG";

    OkHttpClient client;
    private Request request;


    public OkHttpHelper() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("github.com")
                .addPathSegment("user")
                .addQueryParameter("login","TrevorJPrescott")
                .build();

        client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        request = new Request.Builder()
                .url(url)
                .build();
    }

    public void execute()
    {
        new Thread (new Runnable(){
            @Override
            public void run() {

                try{
                    String response = client.newCall(request).execute().body().string();
                    Gson gson = new Gson();
                    InfoResponse randomResponse = gson.fromJson(response,InfoResponse.class);

                    Log.d(TAG, "run: "+ randomResponse.getName());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}