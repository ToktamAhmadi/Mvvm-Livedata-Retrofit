package com.example.mvvn_livedata_retrofit.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Retrofit Service class for creating service
public class RetrofitService {

    public static final String BASE_URL=
            "https://newsapi.org/v2/top-headlines/772c3c902a0b44edb40470e6931ec862";

    private static Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static  <S> S createService(Class<S> serviceClass)
    {
        return  retrofit.create(serviceClass);
    }
}
