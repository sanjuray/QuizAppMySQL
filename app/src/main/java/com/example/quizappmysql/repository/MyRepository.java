package com.example.quizappmysql.repository;


import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.quizappmysql.model.QuestionsList;
import com.example.quizappmysql.retrofit.QuestionsAPI;
import com.example.quizappmysql.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRepository {

    private QuestionsAPI questionsAPI;

    public MyRepository(){
        this.questionsAPI = new RetrofitInstance()
                .getRetrofitInstance()
                .create(QuestionsAPI.class);
    }

    public LiveData<QuestionsList> getQuestionFromAPI(){
        MutableLiveData<QuestionsList> data = new MutableLiveData<>();

        Call<QuestionsList> response = questionsAPI.getQuestions();
        response.enqueue(new Callback<QuestionsList>() {
            @Override
            public void onResponse(Call<QuestionsList> call, Response<QuestionsList> response) {
                QuestionsList list = response.body();
                data.setValue(list);
                Log.v("sucerr","DONE");
            }

            @Override
            public void onFailure(Call<QuestionsList> call, Throwable t) {
                Log.v("ERROR","no loaded data...");            }
        });
        return data;
    }

}
