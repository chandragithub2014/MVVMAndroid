package com.mvvm.kot.Kotlin_Retrofit_Room.Repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import okhttp3.OkHttpClient
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.ArrayList
import java.util.concurrent.TimeUnit

public class APIServiceFactory {
    private fun providesOkHttpClientBuilder(): OkHttpClient {

        val httpClient = OkHttpClient.Builder()
        return httpClient.readTimeout(1200, TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS).build()

    }

    fun providesWebService(): LiveData<List<ResultModel>> {
        val data = MutableLiveData<List<ResultModel>>()
        var webserviceResponseList: List<ResultModel>

        val response = ""
        try {
            val retrofit = Retrofit.Builder()
                    .baseUrl(APIURL.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(providesOkHttpClientBuilder())
                    .build()

            //Defining retrofit api service
            val service = retrofit.create(APIService::class.java)
            //  response = service.makeRequest().execute().body();
            service.makeRequest().enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    Log.d("Repository", "Response::::" + response.body()!!)
                    webserviceResponseList = parseJson(response.body())
                    data.setValue(webserviceResponseList)
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("Repository", "Failed:::")
                }
            })
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return data

    }

    private fun parseJson(response: String?): List<ResultModel> {

        val apiResults = ArrayList<ResultModel>()

        val jsonObject: JSONObject

        val jsonArray: JSONArray

        try {
            jsonArray = JSONArray(response)

            for (i in 0 until jsonArray.length()) {
                var jsonInfo:JSONObject = jsonArray.getJSONObject(i)

                val mMovieModel = ResultModel()
                //mMovieModel.setId(object.getString("id"));
                mMovieModel.setId(Integer.parseInt(jsonInfo.getString("id")))
                mMovieModel.setTitle(jsonInfo.getString("title"))
                mMovieModel.setBody(jsonInfo.getString("body"))

                apiResults.add(mMovieModel)
            }


        } catch (e: JSONException) {
            e.printStackTrace()
        }

        Log.i(javaClass.simpleName, apiResults.size.toString())
        return apiResults

    }


}