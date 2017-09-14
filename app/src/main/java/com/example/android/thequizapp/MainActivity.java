package com.example.android.thequizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }


    int count;


    private String getQuestionOne() {
        EditText answer = (EditText) findViewById(R.id.ans_field);

        return answer.getText().toString().trim();
    }

    private void checkQuestionOne(){
        String answer1 = getQuestionOne();
        if (answer1.trim().equalsIgnoreCase("oreo")){
            count += 1;
        }
    }

    private void checkQuestionTwo(){
        RadioButton radioButton = (RadioButton) findViewById(R.id.radioButton);
        boolean isWeightChecked = radioButton.isChecked();
        if (isWeightChecked){
            count += 1;
        }
    }

    private void checkQuestionThree(){
        RadioButton radioButton8 = (RadioButton) findViewById(R.id.radioButton8);
        boolean isSideChecked = radioButton8.isChecked();
        if (isSideChecked){
            count += 1;
        }
    }


    private void checkQuestionFour(){
        CheckBox questionRed = (CheckBox) findViewById(R.id.red);
        CheckBox questionYellow = (CheckBox) findViewById(R.id.yellow);
        CheckBox questionBlack = (CheckBox) findViewById(R.id.black);
        CheckBox questionWhite = (CheckBox) findViewById(R.id.white);
        boolean isBlackChecked = questionBlack.isChecked();
        boolean isWhiteChecked = questionWhite.isChecked();
        boolean isRedChecked = questionRed.isChecked();
        boolean isYellowChecked = questionYellow.isChecked();


        if (isRedChecked && isYellowChecked && !isBlackChecked && !isWhiteChecked){
            count += 1;
        }
    }


    private void checkAll() {
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
    }

    private void resetCounter(){
        count = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAll();
            Toast.makeText(MainActivity.this, "Correct Answers: " + count + "/4",
                    Toast.LENGTH_LONG).show();
            resetCounter();
        }
    };

}
