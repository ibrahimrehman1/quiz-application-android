package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.questions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void startQuiz(View view){
        String val2 = spinner.getSelectedItem().toString();
        edt1 = (EditText)findViewById(R.id.editText);
        String val1 = edt1.getText().toString().split(" ")[0];
        if (val1.length() == 0){
            val1 = "Anonymous";
        }
        Intent intent = new Intent(MainActivity.this, StartQuiz.class);
        intent.putExtra("com.example.quizapplication", val1 + " " + val2);
        startActivity(intent);
    }
}