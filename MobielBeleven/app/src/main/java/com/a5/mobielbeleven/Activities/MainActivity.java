package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;

import com.a5.mobielbeleven.Adapters.BaeconAdapter;
import com.a5.mobielbeleven.R;

public class MainActivity extends AppCompatActivity {
    static Timer timer = new Timer();
    static int seconds = 0;
    Button goButton;
    Boolean inRange = false;
    TimerTask task;
    BaeconAdapter beacon;
    final Handler handler_interact = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beacon = new BaeconAdapter();

        initNavigationButtons();

        gOTimer();


    }

    private void initNavigationButtons() {
        goButton = findViewById(R.id.home_bttn_go_id);
        Button QRButton = findViewById(R.id.home_bttn_1_id);
        QRButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        //QR.class
                        QR.class
                );
                startActivity(intent);
            }
        });

        Button attractionsButton = findViewById(R.id.home_bttn_2_id);
        attractionsButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        AttractionsOverview.class
                );
                startActivity(intent);
            }
        });

        Button mapButton = findViewById(R.id.home_bttn_3_id);
        mapButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Map.class
                );
                startActivity(intent);
            }
        });

        Button galleryButton = findViewById(R.id.home_bttn_4_id);
        galleryButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Gallery.class
                );
                startActivity(intent);
            }
        });

        goButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = String.valueOf(Math.round((float)(1+Math.random()*2)));
                Intent intent = new Intent();

                if (inRange && id != "0") {
                    switch (id) {
                        case "1":
                            intent = new Intent(getApplicationContext(), Puzzle.class);
                            break;
                        case "2":
                            intent = new Intent(getApplicationContext(), RaadDeSchaduw.class);
                            break;
                        case "3":
                            intent = new Intent(getApplicationContext(), SnakeMenu.class);
                            break;
                    }
                    startActivity(intent);
                } else {
                    Snackbar snackbar = Snackbar
                            .make(view, "No game avaible", Snackbar.LENGTH_LONG);

                    snackbar.show();
                }

            }
        });
    }

    public void gOTimer() {

        task = new TimerTask() {

            @Override
            public void run() {
                //TODO: een methode maken in de sensor adapter voor het zetten van inrange
                inRange = beacon.getInRange();
                updateButton();

            }
        };
        timer.schedule(task, 0, 1000);

    }

    private void updateButton() {
        handler_interact.post(runnable_interact);
    }

    //creating runnable
    final Runnable runnable_interact = new Runnable() {
        public void run() {
            if (inRange) {
                goButton.setBackground(getDrawable(R.drawable.circle_button_home));
            } else {
                goButton.setBackground(getDrawable(R.drawable.circle_button_home_grey));
            }
        }

    };
}
