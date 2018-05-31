package com.a5.mobielbeleven;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Puzzle extends AppCompatActivity {

    private String puzzleQuestion;
    private String answer;
    private int attractionNumber;
    TextView puzzleQuestionScreen;
    EditText answerScreen;
    Button submit;
    private int index = 1;


    public Puzzle(String puzzleQuestion, String answer, int attractionNumber) {
        this.puzzleQuestion = puzzleQuestion;
        this.answer = answer;
        this.attractionNumber = attractionNumber;
    }

    public String getPuzzleQuestion() {
        return puzzleQuestion;
    }
    public String getAnswer() {
        return answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);

        puzzleQuestionScreen.findViewById(R.id.puzzle_question);
        puzzleQuestionScreen.setText(puzzleList[attractionNumber].getPuzzleQuestion());

        answerScreen.findViewById(R.id.answer_id);

        submit.findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (correctAnswer()==true){
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG);
                }
            }
        });



    }

    public boolean correctAnswer(){
        if (answer == answerScreen.getText().toString() ){
            return true;
        }
        return false;
    }

    private static Puzzle[] puzzleList = {
            new Puzzle ("Welke slang is ongevaarlijk? ", "tuinslang", 1),
            new Puzzle ("Waarom vliegen vogels in de winter naar het zuiden?", "Het is te ver lopen", 2)
    };
}

