package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

import static android.content.Context.MODE_PRIVATE;

public class Help extends BaseToolbar
{
    SharedPreferences sharedPreferences;
    Boolean firstTime;
    ImageView clicker;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_help);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.help_title);
        super.onCreate(savedInstanceState);
        TextView infoText = findViewById(R.id.help_text_id);
        infoText.setText(R.string.help_info);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime",true);


        ImageView clicker = findViewById(R.id.help_click);
        clicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);
                finish();
            }
        });
//        if (firstTime) {
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    firstTime = false;
//                    editor.putBoolean("firstTime", firstTime);
//                    editor.apply();
//                    Intent i = new Intent(Help.this, MainActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }, 5000);
//        }else{
//            Intent i = new Intent(Help.this, MainActivity.class);
//            startActivity(i);
//            finish();
//        }

    }
}
