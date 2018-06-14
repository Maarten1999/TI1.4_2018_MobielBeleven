package com.a5.mobielbeleven.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;

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
    String ssid;
    final Handler handler_interact = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        beacon = new BaeconAdapter(getApplicationContext());

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


        // code voor de go button.
        goButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();

                if (inRange && ssid != "0") {
                    switch (ssid) {
                        case "COBRA_ATTRACTION_BEACON":
                            intent = new Intent(getApplicationContext(), SnakeMenu.class);
                            break;
                        case "AMPERA_ATTRACTION_BEACON":
                            intent = new Intent(getApplicationContext(), RaadDeSchaduw.class);
                            break;
                        case "PIETER_ATTRACTION_BEACON":
                            intent = new Intent(getApplicationContext(), Puzzle.class);
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

        ImageButton helpButton = findViewById(R.id.home_bttn_help_id);
        helpButton.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Help.class
                );
                startActivity(intent);
            }
        });
    }

    // timer voor het scannen voor beacons
    public void gOTimer() {

        task = new TimerTask() {

            @Override
            public void run() {
                //TODO: een methode maken in de sensor adapter voor het zetten van inrange
                beacon.scan();
                inRange = beacon.getInRange();
                ssid = beacon.getssid();
                updateButton();

            }
        };
        timer.schedule(task, 0, 500);

    }


    // code voor het veranderen vsan de go button
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


    // request pop up voor premisie voor gps
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
