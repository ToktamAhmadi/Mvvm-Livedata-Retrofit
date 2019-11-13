package com.example.mvvn_livedata_retrofit.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse {

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("totalResult")
    @Expose
    private Integer totalResult;

    @SerializedName("articles")
    @Expose
    private List<NewArticle> articles =null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public List<NewArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NewArticle> articles) {
        this.articles = articles;
    }
}
