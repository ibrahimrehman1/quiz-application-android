package com.example.quizapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class StartQuiz extends AppCompatActivity {
    String[][] arr;
    String[][] choices;
    String[][] selectedQuestions;
    String[][] selectedChoices;
    String[] answers;
    TextView txt1;
    RadioGroup radGroup;
    int selectedId;
    RadioButton rad1;
    String currentVal = "";
    RadioButton selectedRad;
    RadioButton rad2;
    RadioButton rad3;
    RadioButton rad4;
    int counter = 0;
    int count = 0;
    String str;
    int NoOfQuestions;
    String name;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        arr = new String[][]{{(String) getText(R.string.q1), (String)getText(R.string.ca1)}, {(String) getText(R.string.q2), (String)getText(R.string.ca2)},
                {(String) getText(R.string.q3), (String)getText(R.string.ca3)}, {(String) getText(R.string.q4), (String)getText(R.string.ca4)},
                {(String) getText(R.string.q5), (String)getText(R.string.ca5)}, {(String) getText(R.string.q6), (String)getText(R.string.ca6)},
                {(String) getText(R.string.q7), (String)getText(R.string.ca7)}, {(String) getText(R.string.q8), (String)getText(R.string.ca8)}, {(String) getText(R.string.q9), (String)getText(R.string.ca9)},
                {(String) getText(R.string.q10), (String)getText(R.string.ca10)}, {(String) getText(R.string.q11), (String)getText(R.string.ca11)},
                {(String) getText(R.string.q12), (String)getText(R.string.ca12)},
                {(String) getText(R.string.q13), (String)getText(R.string.ca13)}, {(String) getText(R.string.q14), (String)getText(R.string.ca14)},
                {(String) getText(R.string.q15), (String)getText(R.string.ca15)}, {(String) getText(R.string.q16), (String)getText(R.string.ca16)}, {(String) getText(R.string.q17), (String)getText(R.string.ca17)},
                {(String) getText(R.string.q18), (String)getText(R.string.ca18)}, {(String) getText(R.string.q19), (String)getText(R.string.ca19)}, {(String) getText(R.string.q20), (String)getText(R.string.ca20)},
                {(String) getText(R.string.q21), (String)getText(R.string.ca21)}, {(String) getText(R.string.q22), (String)getText(R.string.ca22)},
                {(String) getText(R.string.q23), (String)getText(R.string.ca23)}, {(String) getText(R.string.q24), (String)getText(R.string.ca24)}, {(String) getText(R.string.q25), (String)getText(R.string.ca25)},
                {(String) getText(R.string.q26), (String)getText(R.string.ca26)}, {(String) getText(R.string.q27), (String)getText(R.string.ca27)},
                {(String) getText(R.string.q28), (String)getText(R.string.ca28)}, {(String) getText(R.string.q29), (String)getText(R.string.ca29)},
                {(String) getText(R.string.q30), (String)getText(R.string.ca30)}};
        choices = new String[][]{{(String)getText(R.string.ch1), (String)getText(R.string.ca1), (String)getText(R.string.ch2), (String)getText(R.string.none)}, {(String)getText(R.string.ch3), (String)getText(R.string.ch4), (String)getText(R.string.ca2), (String)getText(R.string.none)},
                {(String)getText(R.string.ca3), (String)getText(R.string.ch5), (String)getText(R.string.ch6), (String)getText(R.string.none)}, {(String)getText(R.string.ch7), (String)getText(R.string.ca4), (String)getText(R.string.ch8), (String)getText(R.string.none)},
                {(String)getText(R.string.ch9), (String)getText(R.string.ch10), (String)getText(R.string.ca5), (String)getText(R.string.all)}, {(String)getText(R.string.ch11), (String)getText(R.string.ch12), (String)getText(R.string.ca6), (String)getText(R.string.ch13)},
                {(String)getText(R.string.ca7), (String)getText(R.string.ch14), (String)getText(R.string.ch15), (String)getText(R.string.ch16)}, {(String)getText(R.string.ca8), (String)getText(R.string.ch17), (String)getText(R.string.ch18), (String)getText(R.string.none)},
                {(String)getText(R.string.ch19), (String)getText(R.string.ca9), (String)getText(R.string.ch20), (String)getText(R.string.ch21)}, {(String)getText(R.string.ca10), (String)getText(R.string.ch22), (String)getText(R.string.ch23), (String)getText(R.string.ch24)}, {(String)getText(R.string.ch25), (String)getText(R.string.ca11), (String)getText(R.string.ch26), (String)getText(R.string.ch27)},
                {(String)getText(R.string.ca12), (String)getText(R.string.ch28), (String)getText(R.string.ch29), (String)getText(R.string.ch30)}, {(String)getText(R.string.ch31), (String)getText(R.string.ch32), (String)getText(R.string.ca13), (String)getText(R.string.all)}, {(String)getText(R.string.ch33), (String)getText(R.string.ca14), (String)getText(R.string.ch34), (String)getText(R.string.none)},
                {(String)getText(R.string.ch35), (String)getText(R.string.ca15), (String)getText(R.string.ch36), (String)getText(R.string.ch37)}, {(String)getText(R.string.ch38), (String)getText(R.string.ca16), (String)getText(R.string.ch39), (String)getText(R.string.ch40)}, {(String)getText(R.string.ch41), (String)getText(R.string.ch42), (String)getText(R.string.ca17), (String)getText(R.string.ch43)},
                {(String)getText(R.string.ca18), (String)getText(R.string.ch44), (String)getText(R.string.ch45), (String)getText(R.string.none)}, {(String)getText(R.string.ch46), (String)getText(R.string.ch47), (String)getText(R.string.ca19), (String)getText(R.string.none)}, {(String)getText(R.string.ch48), (String)getText(R.string.ch49), (String)getText(R.string.ca20), (String)getText(R.string.none)},
                {(String)getText(R.string.ch50), (String)getText(R.string.ch51), (String)getText(R.string.ca21), (String)getText(R.string.all)}, {(String)getText(R.string.ch52), (String)getText(R.string.ca22), (String)getText(R.string.ch53), (String)getText(R.string.none)},
                {(String)getText(R.string.ca23), (String)getText(R.string.ch54), (String)getText(R.string.ch55), (String)getText(R.string.none)}, {(String)getText(R.string.ch56), (String)getText(R.string.ch57), (String)getText(R.string.ca24), (String)getText(R.string.none)},
                {(String)getText(R.string.ch58), (String)getText(R.string.ch59), (String)getText(R.string.ca25), (String)getText(R.string.none)}, {(String)getText(R.string.ch60), (String)getText(R.string.ch61), (String)getText(R.string.ch62), (String)getText(R.string.ca26)},
                {(String)getText(R.string.ca27), (String)getText(R.string.ch63), (String)getText(R.string.ch64), (String)getText(R.string.all)}, {(String)getText(R.string.ch65), (String)getText(R.string.ch66), (String)getText(R.string.ca28), (String)getText(R.string.all)},
                {(String)getText(R.string.ca29), (String)getText(R.string.ch67), (String)getText(R.string.ch68), (String)getText(R.string.all)}, {(String)getText(R.string.ch69), (String)getText(R.string.ch70), (String)getText(R.string.ca30), (String)getText(R.string.none)},
                };
        setTitle("Question 1");
        Intent intent = getIntent();
        str = intent.getStringExtra("com.example.quizapplication");
        NoOfQuestions = Integer.parseInt(str.split(" ")[1]);
        selectedQuestions = new String[NoOfQuestions][];
        selectedChoices = new String[NoOfQuestions][];
        selectQuestion();
        answers = new String[NoOfQuestions];
        name = str.split(" ")[0];
        txt1 = findViewById(R.id.textView3);
        txt1.setText(selectedQuestions[count][0]);
        radGroup = findViewById(R.id.radioGroup);
        rad1 = findViewById(R.id.radio_1);
        rad2 = findViewById(R.id.radio_2);
        rad3 = findViewById(R.id.radio_3);
        rad4 = findViewById(R.id.radio_4);
        rad1.setText(selectedChoices[count][0]);
        rad2.setText(selectedChoices[count][1]);
        rad3.setText(selectedChoices[count][2]);
        rad4.setText(selectedChoices[count][3]);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void selectQuestion(){
        while (counter < NoOfQuestions) {
            int rnd = new Random().nextInt(arr.length);
            boolean found = Arrays.stream(selectedQuestions).anyMatch(t -> Arrays.equals(t, arr[rnd]));
            if (!found) {
                selectedQuestions[counter] = arr[rnd];
                selectedChoices[counter] = choices[rnd];
                counter++;
            }
        }
    }

    public void update(View view){
        selectedId = radGroup.getCheckedRadioButtonId();
        selectedRad = findViewById(selectedId);
        currentVal = selectedRad.getText().toString();
    }

    public void check(View view) {
        answers[count] = Integer.toString(currentVal.length()).equals("0") ? " ": currentVal;
        if((count + 1) == NoOfQuestions) {
            Intent intent = new Intent(this, EndQuiz.class);
            intent.putExtra("Answer's Array", answers);
            intent.putExtra("Name", name);
            intent.putExtra("Selected Questions", selectedQuestions);
            intent.putExtra("No. Of Questions", NoOfQuestions);
            startActivity(intent);
        }else{
            count++;
            radGroup.clearCheck();
            rad1.setText(selectedChoices[count][0]);
            rad2.setText(selectedChoices[count][1]);
            rad3.setText(selectedChoices[count][2]);
            rad4.setText(selectedChoices[count][3]);
            setTitle("Question " + (count + 1));
            txt1.setText(selectedQuestions[count][0]);
        }
    }
}
