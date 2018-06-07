package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

public class Puzzle extends BaseToolbar {

    private String puzzleQuestion;
    private String answer;
    private int attractionNumber = 1;
    TextView puzzleQuestionScreen;
    EditText answerScreen;
    TextView puzzleinfo;
    Button submit;


    public Puzzle(String puzzleQuestion, String answer, int attractionNumber) {
        this.puzzleQuestion = puzzleQuestion;
        this.answer = answer;
        this.attractionNumber = attractionNumber;
    }

    public Puzzle() {
    }

    public String getPuzzleQuestion() {
        return puzzleQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_puzzle);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.puzzle_text);
        super.onCreate(savedInstanceState);

        puzzleQuestionScreen = findViewById(R.id.puzzle_question);
        puzzleQuestionScreen.setText(puzzleList[attractionNumber].getPuzzleQuestion());

        puzzleinfo = findViewById(R.id.txt_good);
        puzzleinfo.setText("");
        answer = puzzleList[attractionNumber].getAnswer();
        answerScreen = findViewById(R.id.answer_id);
        submit = findViewById(R.id.submit_btn);
        submit.setText("submit");
        submit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (correctAnswer()){
//                        Toast toast = Toast.makeText(getApplicationContext(), "Goed", Toast.LENGTH_LONG);
//                        toast.show();
                        puzzleinfo.setText("Goed! \n Druk nogmaals op de knop om terug te gaan naar het hoofdscherm");

                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(
                                        getApplicationContext(),
                                        MainActivity.class
                                );
                                startActivity(intent);
                                finish();
                            }
                        });

                    }
                    if (!correctAnswer()){
                        puzzleinfo.setText("Fout! \n Druk nogmaals op de knop om terug te gaan naar het hoofdscherm.");

                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(
                                        getApplicationContext(),
                                        MainActivity.class
                                );
                                startActivity(intent);
                                finish();
                            }
                        });
                    }

                }
            });


    }


    public boolean correctAnswer() {
        if (answer.equals(answerScreen.getText().toString().toLowerCase())) {
            return true;
        }
        return false;
    }

    private static Puzzle[] puzzleList = {
            new Puzzle("Welke slang is ongevaarlijk? ", "tuinslang", 1),
            new Puzzle("Waarom vliegen vogels in de winter naar het zuiden?", "het is te ver lopen", 2),
            new Puzzle("Hoe lang leeft een goudvis gemiddeld? ", "22 jaar", 3)
    };
}


