package com.example.quizappmysql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.quizappmysql.databinding.ActivityMainBinding;
import com.example.quizappmysql.model.Model;
import com.example.quizappmysql.model.QuestionsList;
import com.example.quizappmysql.viewmodel.QuizViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    QuizViewModel quizViewModel;
    ArrayList<Model> questions;

    static int totalQuestions = 0;
    static int result = 0;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        );

        result = 0;
        totalQuestions = 0;
        i = 0;

        quizViewModel = new ViewModelProvider(this)
                .get(QuizViewModel.class);

        displayQuestion();

        activityMainBinding.nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
displayFollowingQuestion();
            }
        });
    }

    private void displayFollowingQuestion(){
        totalQuestions = questions.size();
        int selectedOption = activityMainBinding.options.getCheckedRadioButtonId();
//        Toast.makeText(this,i+" "+questions.get(i).getCorrectOption(),Toast.LENGTH_SHORT).show();
        if(selectedOption != -1){
            RadioButton selected = (RadioButton) findViewById(selectedOption);
            if(selected.getText().toString().equals(questions.get(i).getCorrectOption())){
//                Toast.makeText(this, "Correst", Toast.LENGTH_SHORT).show();
                this.result++;
                activityMainBinding.result.setText("Correct answers: "+result);
            }
            if(activityMainBinding.nxtBtn.getText().toString().equals("Finish")){
                Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                Bundle b = new Bundle();
                b.putString("Score",this.result+"");
                b.putString("Total",this.totalQuestions+"");
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }

            i++;

            if(i == questions.size() - 1){
                activityMainBinding.nxtBtn.setText("Finish");
            }

            activityMainBinding.options.clearCheck();
            activityMainBinding.question.setText("Question "+(i+1)+" : "+questions.get(i).getQuestion());
            activityMainBinding.option1.setText(questions.get(i).getOption1());
            activityMainBinding.option2.setText(questions.get(i).getOption2());
            activityMainBinding.option3.setText(questions.get(i).getOption3());
            activityMainBinding.option4.setText(questions.get(i).getOption4());


        }else{
            Toast.makeText(
                    getApplicationContext(),
                    "You need to make a Selection",
                    Toast.LENGTH_LONG).show();
        }
    }

    //Mystery why the commented code doesn't send the static values changed like the uncommmented one which is logically incorrect
    private void displayNxtQuestion() {

//        int selectedOption = activityMainBinding.options.getCheckedRadioButtonId();
//
//        if(selectedOption != -1){
//            RadioButton radioButton = (RadioButton) findViewById(selectedOption);
//
//            if((questions.size() - i) > 0){
//                this.totalQuestions = questions.size();
//                if(radioButton.getText().toString().equals(questions.get(i).getCorrectOption())){
//                    this.result++;
//                    activityMainBinding.result.setText("Correct Answers: "+result);
//                }
//
//                if(activityMainBinding.nxtBtn.getText().equals("Finish")){
//                    Toast.makeText(this, this.result+"/"+this.totalQuestions, Toast.LENGTH_SHORT).show();
//                    Intent i  = new Intent(MainActivity.this, ResultsActivity.class);
//                    check();
//                    startActivity(i);
//                    finish();
//                }
//
//                i++;
//
//                activityMainBinding.question.setText("Question "+(i+1)+" : "+questions.get(i).getQuestion());
//                activityMainBinding.option1.setText(questions.get(i).getOption1());
//                activityMainBinding.option2.setText(questions.get(i).getOption2());
//                activityMainBinding.option3.setText(questions.get(i).getOption3());
//                activityMainBinding.option4.setText(questions.get(i).getOption4());
//
//                if(i == (questions.size() - 1)){
//                    activityMainBinding.nxtBtn.setText("Finish");
//                }
//
//                activityMainBinding.options.clearCheck();
//            }else{
//                if(radioButton.getText().toString().equals(questions.get(i-1).getCorrectOption())){
//                    result++;
//                    activityMainBinding.result.setText("Correct : "+result);
//                }
//            }
//        }else{
//            Toast.makeText(this,"" +
//                    "You need to make a selection",
//                    Toast.LENGTH_SHORT).show();
//        }

        Toast.makeText(MainActivity.this,i+"",Toast.LENGTH_SHORT).show();
        if (activityMainBinding.nxtBtn.getText().equals("Finish")){
            Intent i = new Intent(MainActivity.this, ResultsActivity.class);
            startActivity(i);
            finish();
        }


        // Displaying the question
        int selectedOption = activityMainBinding.options.getCheckedRadioButtonId();
        if (selectedOption != -1){
            RadioButton radioButton = findViewById(selectedOption);

            // More Questions to Display??
            if ((questions.size() -i) > 0){

                // Getting the number of questions
                totalQuestions = questions.size();

                // Check if the chosen option is correct
                if(radioButton.getText().toString().equals(
                        questions.get(i).getCorrectOption()
                )){
                    result++;
                    activityMainBinding.result.setText(
                            "Correct Answers: "+result
                    );
                }

//                if (i ==0){
//                    i++;
//                }

                // Displaying the next Questions
                activityMainBinding.question.setText("Question "+(i+1)+ " : "+
                        questions.get(i).getQuestion());

                activityMainBinding.option1.setText(questions.get(i).getOption1());
                activityMainBinding.option2.setText(questions.get(i).getOption2());
                activityMainBinding.option3.setText(questions.get(i).getOption3());
                activityMainBinding.option4.setText(questions.get(i).getOption4());


                // Check if it is the last question
                if(i == (questions.size() -1)){
                    activityMainBinding.nxtBtn.setText("Finish");
                }

                activityMainBinding.options.clearCheck();
                i++;


            }else{
                if (radioButton.getText().toString().equals(
                        questions.get(i-1).getCorrectOption()
                )){
                    result++;
                    activityMainBinding.result.setText("Correct Answers : "+result);
                }

            }
        }else{
            Toast.makeText(
                    this,
                    "You need to make a selection",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void check() {
        Toast.makeText(this,this.result+" "+this.totalQuestions, Toast.LENGTH_SHORT).show();
    }

    private void displayQuestion() {
        quizViewModel.getQuestionsListLiveData().observe(this, new Observer<QuestionsList>() {
            @Override
            public void onChanged(QuestionsList models) {
                questions = models;
                activityMainBinding.question.setText("Question 1: "+ questions.get(0).getQuestion());;
                activityMainBinding.option1.setText(questions.get(0).getOption1());
                activityMainBinding.option2.setText(questions.get(0).getOption2());
                activityMainBinding.option3.setText(questions.get(0).getOption3());
                activityMainBinding.option4.setText(questions.get(0).getOption4());
                if(questions.size() ==1) activityMainBinding.nxtBtn.setText("Finish");
            }
        });
    }


}