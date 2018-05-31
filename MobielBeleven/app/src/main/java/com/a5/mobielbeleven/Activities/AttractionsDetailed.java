package com.a5.mobielbeleven.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

public class AttractionsDetailed extends BaseToolbar {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_attractions_detailed);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.attractions_button);
        super.onCreate(savedInstanceState);
    }
}
