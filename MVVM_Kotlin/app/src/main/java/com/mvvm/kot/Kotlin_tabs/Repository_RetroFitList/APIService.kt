package com.mvvm.kot.Kotlin_tabs.Repository_RetroFitList

import retrofit2.Call
import retrofit2.http.GET

public interface APIService {
    @GET("posts")
    abstract fun makeRequest(): Call<String>
}