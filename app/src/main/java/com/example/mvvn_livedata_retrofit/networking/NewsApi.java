package com.example.mvvn_livedata_retrofit.networking;


import com.example.mvvn_livedata_retrofit.Model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//implement Retrofit
public interface NewsApi {
    @GET("top-headlines")
    Call<NewsResponse> getNewsList(@Query("sources")
                                           String newsSource, @Query("apiKey") String apiKey);
}
