package com.example.mvvn_livedata_retrofit.networking;

import com.example.mvvmexample3.Model.NewsResponse;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {
    public static NewsRepository newsRepository;
    public static NewsRepository getInstance()
    {
        if(newsRepository == null)
        { newsRepository = new NewsRepository();}
        return newsRepository;
    }

    private NewsApi newsApi;
    public NewsRepository()
    {
        newsApi = RetrofitService.createService(NewsApi.class);
    }

    public MutableLiveData<NewsResponse> getNews(String source, String key)
    {
        final MutableLiveData<NewsResponse> newsData = new MutableLiveData<>();
        newsApi.getNewsList(source, key)
.enqueue(new Callback<NewsResponse>() {
    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        if(response.isSuccessful())
        {newsData.setValue(response.body());}
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        newsData.setValue(null);
    }
});
        return newsData;
    }
}
