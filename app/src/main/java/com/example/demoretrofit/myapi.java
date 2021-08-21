package com.example.demoretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface myapi {
    String BASE_URL="https://jsonkeeper.com/b/";
    String FEED="WO6S";
    Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    @GET(FEED)
    Call<List<model>> getPosts();



}

