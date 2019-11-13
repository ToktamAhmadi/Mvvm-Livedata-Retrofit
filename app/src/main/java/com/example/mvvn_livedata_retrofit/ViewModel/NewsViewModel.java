package com.example.mvvn_livedata_retrofit.ViewModel;

import com.example.mvvmexample3.Model.NewsResponse;
import com.example.mvvmexample3.networking.NewsRepository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {

    private MutableLiveData<NewsResponse> mutableLiveData;
    private NewsRepository newsRepository;

    public void init()
    {
        if(mutableLiveData != null){return;}
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNews("bbc-news","772c3c902a0b44edb40470e6931ec862");
    }

    public LiveData<NewsResponse> getNewsRepository()
    {return mutableLiveData;}
}
