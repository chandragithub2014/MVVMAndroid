package com.andr.mvvm.RetrofitRoom.Repository;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("posts")
    Call<String> makeRequest();
}
