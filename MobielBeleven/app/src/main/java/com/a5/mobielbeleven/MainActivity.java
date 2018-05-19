package com.a5.mobielbeleven;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationButtons();
    }

    private void initNavigationButtons()
    {
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
    }
}
