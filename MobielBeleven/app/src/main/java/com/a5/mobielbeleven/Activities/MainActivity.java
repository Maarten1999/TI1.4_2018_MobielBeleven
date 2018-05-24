package com.a5.mobielbeleven.Activities;

//import java.awt.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import java.util.Timer;
import java.util.TimerTask;
import com.a5.mobielbeleven.R;

public class MainActivity extends AppCompatActivity
{
    static Timer timer = new Timer();
    static int seconds = 0;
    Button goButton;
    Boolean inRange =false;
    TimerTask task;
    Boolean enableFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationButtons();

        gOTimer();
        goButton.setEnabled(enableFlag);
        if(enableFlag)
        {
            goButton.setBackground(getDrawable(R.drawable.circle_button_home));
        }
        else
        {
            goButton.setBackground(getDrawable(R.drawable.circle_button_home_grey));
        }

    }

    private void initNavigationButtons()
    {
        goButton = findViewById(R.id.home_bttn_go_id);
        Button QRButton = findViewById(R.id.home_bttn_1_id);
        QRButton.setOnClickListener(new AdapterView.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(
                        getApplicationContext(),
                        QR.class
                );
                startActivity(intent);
            }
        });

        Button attractionsButton = findViewById(R.id.home_bttn_2_id);
        attractionsButton.setOnClickListener(new AdapterView.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(
                        getApplicationContext(),
                        AttractionsOverview.class
                );
                startActivity(intent);
            }
        });

        Button mapButton = findViewById(R.id.home_bttn_3_id);
        mapButton.setOnClickListener(new AdapterView.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Map.class
                );
                startActivity(intent);
            }
        });

        Button galleryButton = findViewById(R.id.home_bttn_4_id);
        galleryButton.setOnClickListener(new AdapterView.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(
                        getApplicationContext(),
                        Gallery.class
                );
                startActivity(intent);
            }
        });

        goButton.setOnClickListener(new AdapterView.OnClickListener()
        {
            @Override
            public void onClick(View view)
            { String id = "0";
                Intent intent = new Intent();

                switch (id)
                {
                    case "1":
                        intent = new Intent(getApplicationContext(), QR.class);
                        break;
                    case "2":
                        intent = new Intent(getApplicationContext(), QR.class);
                        break;
                }

                startActivity(intent);
            }
        });
    }

    public  void gOTimer() {

                task = new TimerTask() {

                    @Override
                    public void run()
                    {
                        if (inRange)
                        {
                            enableFlag = true;
                        }
                        else
                        {

                           enableFlag = false;
                        }
                    }
                };
                timer.schedule(task, 0, 1000);

           }
}
