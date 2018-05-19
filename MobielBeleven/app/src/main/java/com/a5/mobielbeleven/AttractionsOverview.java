package com.a5.mobielbeleven;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AttractionsOverview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions_overview);

        TextView titleBar = (TextView) findViewById(R.id.titlebar_txt_1_id);
        titleBar.setText(getLocalClassName());
    }
}
