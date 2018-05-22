package com.a5.mobielbeleven.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

public class Map extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        TextView titleBar = (TextView) findViewById(R.id.titlebar_txt_1_id);
        String[] className = getLocalClassName().split("\\.");
        titleBar.setText(className[className.length - 1]);
    }
}
