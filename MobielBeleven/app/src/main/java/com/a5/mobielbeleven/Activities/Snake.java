package com.a5.mobielbeleven.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.a5.mobielbeleven.R;
import com.a5.mobielbeleven.Snake.engine.GameEngine;
import com.a5.mobielbeleven.Snake.enums.Direction;
import com.a5.mobielbeleven.Snake.enums.GameState;
import com.a5.mobielbeleven.Snake.views.SnakeView;


public class Snake extends AppCompatActivity implements View.OnTouchListener
{
    private GameEngine gameEngine;
    private SnakeView snakeView;
    private final Handler handler = new Handler();
    private long updateDelay = 125;

    private float prevX, prevY;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake);

        gameEngine = new GameEngine();
        gameEngine.initGame();

        snakeView = (SnakeView) findViewById(R.id.snakeView);
        snakeView.setOnTouchListener(this);

        startUpdateHandler();
    }

    private void startUpdateHandler()
    {
        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                gameEngine.update();

                if (gameEngine.getCurrentGameState() == GameState.RUNNING) {
                    handler.postDelayed(this, updateDelay);
                }
                if (gameEngine.getCurrentGameState() == GameState.LOST) {
                    OnGameLost();
                }
                snakeView.setSnakeViewMap(gameEngine.getMap());
                snakeView.invalidate();
            }
        },updateDelay);
    }

    private void OnGameLost()
    {
        Toast.makeText(this, "You lost \nScore = " + gameEngine.getScore(), Toast.LENGTH_SHORT).show();
        setResult(Activity.RESULT_OK, new Intent().putExtra("score", gameEngine.getScore()));
        finish();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event)
    {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                prevX = event.getX();
                prevY = event.getY();

                break;
            case MotionEvent.ACTION_UP:
                float newX = event.getX();
                float newY = event.getY();

                //calculate where we swiped
                if (Math.abs(newX - prevX) > Math.abs(newY - prevY)) {
                    //LEFT - RIGHT direction
                    if(newX > prevX){
                        //RIGHT
                        gameEngine.updateDirection(Direction.EAST);
                    }else{
                        //LEFT
                        gameEngine.updateDirection(Direction.WEST);
                    }
                }
                else{
                    //UP - DOWN direction
                    if (newY > prevY) {
                        //DOWN
                        gameEngine.updateDirection(Direction.SOUTH);
                    }else{
                        //UP
                        gameEngine.updateDirection(Direction.NORTH);
                    }
                }
                break;


        }
        return true;
    }
}
