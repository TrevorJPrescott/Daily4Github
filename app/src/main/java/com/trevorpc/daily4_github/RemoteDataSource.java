package com.trevorpc.daily4_github;

import com.trevorpc.model.InfoResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Url;

public class RemoteDataSource
{
    private Retrofit createInstance(){

        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_URL)
                .addConverterFactory((GsonConverterFactory.create()))
                .build();
    }

    private RemoteService getRemoteService() {
        return createInstance().create(RemoteService.class);
    }

    public Call<InfoResponse> getMyInfo (String name, Url picture, String bio, String location) {

        return getRemoteService().getInformation(name,picture,bio,location);
    }
}
