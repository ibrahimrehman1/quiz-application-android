package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class EndQuiz extends AppCompatActivity {
    int score = 0;
    String[] answers;
    String[][] selectedQuestion;
    int count = 0;
    String name;
    int NoOfQuestions;
    TextView txtView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_activity);
        Intent intent = getIntent();
        answers = intent.getStringArrayExtra("Answer's Array");
        name = intent.getStringExtra("Name");
        NoOfQuestions = intent.getIntExtra("No. Of Questions", 10);
        selectedQuestion = (String[][]) intent.getSerializableExtra("Selected Questions");
        findScore();
        setTitle("Score: " + score);
        txtView = findViewById(R.id.textView4);
        txtView.setText(String.format(Locale.US, "%s, You Scored %d out of %d", name, score, NoOfQuestions));
    }

    private void findScore() {
        for(String val:answers){
            if (val.equals((selectedQuestion[count][1]))){
                score++;
            }
            count++;
        }
    }
}
