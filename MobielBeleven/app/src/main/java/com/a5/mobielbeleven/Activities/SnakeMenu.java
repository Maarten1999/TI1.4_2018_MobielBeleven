package com.a5.mobielbeleven.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputFilter;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a5.mobielbeleven.R;

import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_PERSON_NAME;

public class SnakeMenu extends BaseToolbar
{
    private TextView scoreBoard;
    Button sendButton, newGameButton;
    private final int SNAKE_GAME_SCORE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_snake_menu);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.snake_menu_text);
        super.onCreate(savedInstanceState);

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
                startActivityForResult(intent, SNAKE_GAME_SCORE);
            }
        });


        sendButton = findViewById(R.id.snake_menu_send_id);
        sendButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                askForName();
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

    private void setHighScoreBoard(int newScore)
    {
        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("score", 0);
        if (newScore > score) {

            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("score", newScore);
            editor.commit();

            scoreBoard.setText(String.valueOf(newScore));
            sendButton.setVisibility(Button.VISIBLE);
            newGameButton.setText(R.string.snake_menu_button_improve);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Highscore niet verbeterd", Toast.LENGTH_LONG).show();
        }
    }

    private void checkScore()
    {
        int currentScore = PreferenceManager.getDefaultSharedPreferences(this).getInt("score", 0);
        if (currentScore != 0) {
            sendButton.setVisibility(Button.VISIBLE);
            newGameButton.setText(R.string.snake_menu_button_improve);
        } else {
            sendButton.setVisibility(Button.INVISIBLE);
            newGameButton.setText(R.string.new_game);
        }

    }


    private void askForName()
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SnakeMenu.this);
        alertDialog.setTitle("Enter a Name");
        //alertDialog.setMessage("Enter a name");

        final EditText input = new EditText(this);
        input.setInputType(TYPE_TEXT_VARIATION_PERSON_NAME);
        input.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        //alertDialog.setIcon(R.drawable.key);


        alertDialog.setPositiveButton("SEND",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String name = input.getText().toString();
                        Toast.makeText(getApplicationContext(),
                                name, Toast.LENGTH_SHORT).show();
                    }
                });

        alertDialog.setNegativeButton("CANCEL",
                new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        Toast.makeText(getApplicationContext(),
                                "Geen naam ingevoerd", Toast.LENGTH_LONG).show();
                        dialog.cancel();
                    }
                });

        alertDialog.show();

    }

}
