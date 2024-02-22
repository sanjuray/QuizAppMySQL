package com.example.quizappmysql;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quizappmysql.databinding.ActivityResultsBinding;

public class ResultsActivity extends AppCompatActivity {

    ActivityResultsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_results
        );
        Intent i = getIntent();
        String result = i.getExtras().getString("Score");
        String totalQuestions = i.getExtras().getString("Total");
        binding.results.setText("Your score: "+ result+"/"+totalQuestions);
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}