package com.example.quizappmysql.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quizappmysql.model.QuestionsList;
import com.example.quizappmysql.repository.MyRepository;

public class QuizViewModel extends ViewModel {
    MyRepository repo;
    LiveData<QuestionsList> questionsListLiveData;

    public QuizViewModel(){
        repo = new MyRepository();
        questionsListLiveData = repo.getQuestionFromAPI();
    }

    public LiveData<QuestionsList> getQuestionsListLiveData() {
        return questionsListLiveData;
    }
}
