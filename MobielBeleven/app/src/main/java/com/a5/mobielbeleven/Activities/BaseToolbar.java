package com.a5.mobielbeleven.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.a5.mobielbeleven.R;


public class BaseToolbar extends AppCompatActivity
{

    void displayToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar_in_appbar_layout);
        toolbar.setTitleMargin(16,8,8,8);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

}
