package com.trevorpc.daily4_github;

import com.trevorpc.model.InfoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RemoteService {

    @GET("/users/TrevorJPrescott")
    Call<InfoResponse> getInformation(@Query("login") String name, @Query("avatar_url") Url picture,
                                      @Query("location") String location, @Query("bio") String bio);

    // @GET for Repo
}
