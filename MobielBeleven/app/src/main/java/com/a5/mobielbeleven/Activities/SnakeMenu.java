package com.a5.mobielbeleven.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.a5.mobielbeleven.R;

public class SnakeMenu extends AppCompatActivity
{
    private TextView scoreBoard;
    Button sendButton,newGameButton;
    private final int SNAKE_GAME_SCORE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_menu);

        TextView titleBar = (TextView) findViewById(R.id.titlebar_txt_1_id);
        titleBar.setText(getApplicationContext().getString(R.string.snake_menu_text));

        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("score", 0);

        scoreBoard = findViewById(R.id.snake_menu_score_text_id);
        scoreBoard.setText(String.valueOf(score));

        newGameButton = findViewById(R.id.snake_menu_new_game_button_id);
        newGameButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Snake.class
                );
                startActivityForResult(intent,SNAKE_GAME_SCORE);
            }
        });


        sendButton = findViewById(R.id.snake_menu_send_id);
        sendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),
                        "Sended score", Toast.LENGTH_LONG).show();
            }
        });

        checkScore();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == SNAKE_GAME_SCORE && resultCode == Activity.RESULT_OK) {
            int newScore = data.getIntExtra("score", 0);
            setHighScoreBoard(newScore);
        }
    }

    private void setHighScoreBoard(int newScore){
        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("score", 0);
        if(newScore > score){

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("score", newScore);
            editor.commit();

            scoreBoard.setText(String.valueOf(newScore));
            sendButton.setVisibility(Button.VISIBLE);
            newGameButton.setText(R.string.snake_menu_button_improve);
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "Highscore niet verbeterd", Toast.LENGTH_LONG).show();
        }
    }

    private void checkScore(){
        int currentScore = PreferenceManager.getDefaultSharedPreferences(this).getInt("score", 0);
        if (currentScore != 0) {
            sendButton.setVisibility(Button.VISIBLE);
            newGameButton.setText(R.string.snake_menu_button_improve);
        }
        else{
            sendButton.setVisibility(Button.INVISIBLE);
            newGameButton.setText(R.string.new_game);
        }

    }
}
