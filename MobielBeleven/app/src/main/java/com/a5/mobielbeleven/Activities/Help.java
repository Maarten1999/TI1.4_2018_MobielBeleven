package com.a5.mobielbeleven.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

public class Help extends BaseToolbar
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_help);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.help_title);
        super.onCreate(savedInstanceState);

        TextView infoText = findViewById(R.id.help_text_id);
        infoText.setText(R.string.help_info);
    }
}
