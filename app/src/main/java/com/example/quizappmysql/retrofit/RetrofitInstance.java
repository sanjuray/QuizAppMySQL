package com.example.quizappmysql.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    String baseURl = "http://192.168.0.100/quiz/";

    public Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(baseURl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



}
