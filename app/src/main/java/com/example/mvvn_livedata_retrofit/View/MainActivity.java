package com.example.mvvn_livedata_retrofit.View;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvn_livedata_retrofit.Model.NewArticle;
import com.example.mvvn_livedata_retrofit.R;
import com.example.mvvn_livedata_retrofit.ViewModel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    ArrayList<NewArticle> articleArrayList = new ArrayList<>();
    NewsAdapter newsAdapter;
    RecyclerView rvHeadline;
    NewsViewModel newsViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"ok"+articleArrayList,Toast.LENGTH_LONG).show();
        rvHeadline = findViewById(R.id.rvNews);

//        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
//        newsViewModel.init();
//        newsViewModel.getNewsRepository().observe(this, new Observer<NewsResponse>() {
//            @Override
//            public void onChanged(NewsResponse newsResponse) {
//                List<NewArticle> newsArticles = newsResponse.getArticles();
//                articleArrayList.addAll(newsArticles);
//                newsAdapter.notifyDataSetChanged();
//            }
//        });
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.init();
        newsViewModel.getNewsRepository().observe(this, newsResponse -> {
            List<NewArticle> newsArticles = newsResponse.getArticles();
            articleArrayList.addAll(newsArticles);
            newsAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();



    }
    private void setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = new NewsAdapter(MainActivity.this, articleArrayList);
            rvHeadline.setLayoutManager(new LinearLayoutManager(this));
            rvHeadline.setAdapter(newsAdapter);
            rvHeadline.setItemAnimator(new DefaultItemAnimator());
            rvHeadline.setNestedScrollingEnabled(true);
        } else {
            newsAdapter.notifyDataSetChanged();
        }
    }
}
