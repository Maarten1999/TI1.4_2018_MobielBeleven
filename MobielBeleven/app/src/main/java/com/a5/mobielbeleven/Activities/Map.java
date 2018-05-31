package com.a5.mobielbeleven.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

public class Map extends BaseToolbar
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_map);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.map_button);
        super.onCreate(savedInstanceState);

    }
}
