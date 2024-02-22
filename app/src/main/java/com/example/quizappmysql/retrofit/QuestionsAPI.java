package com.example.quizappmysql.retrofit;

import com.example.quizappmysql.model.Model;
import com.example.quizappmysql.model.QuestionsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionsAPI {

    //Used to define the structure and behavior of
    //network request to RESTFUL API
    //Acts as a bridge between the application and web service

    @GET("mysqlapi.php") //end pt
    Call<QuestionsList> getQuestions();
}
