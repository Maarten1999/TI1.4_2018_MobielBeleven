package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.a5.mobielbeleven.R;

import static android.icu.lang.UProperty.MATH;

public class RaadDeSchaduw extends AppCompatActivity {
    private int schaduw;
    private RadioButton knop1;
    private int correct;
    private int wrong;

    RadioGroup radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raad_de_schaduw);

        TextView titleBar = (TextView) findViewById(R.id.titlebar_txt_1_id);
        titleBar.setText(getApplicationContext().getString(R.string.raad_de_schaduw_titel));

        raadDeSchaduwSelecteren();
    }

    public void raadDeSchaduwSelecteren(){
        schaduw = Math.round((float)(1 + Math.random()));

        switch(schaduw){
            case 1: firstTest();
                    break;
            case 2: secondTest();
                    break;
        }
    }

    public void firstTest(){
        radio = findViewById(R.id.raadDeSchaduwRadioGroupId);
        knop1 = findViewById(R.id.raadDeSchaduwEersteAntId);
        knop1.setText("Pardoes");
        RadioButton knop2 = findViewById(R.id.raadDeSchaduwTweedeAntId);
        knop2.setText("Pickachu");
        RadioButton knop3 = findViewById(R.id.raadDeSchaduwDerdeAntId);
        knop3.setText("Mickey Mouse");
        RadioButton knop4 = findViewById(R.id.raadDeSchaduwVierdeAntId);
        knop4.setText("Spongebob");

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radio.getCheckedRadioButtonId() == R.id.raadDeSchaduwEersteAntId){
                    victory(radio.getRootView());
                }
                else lose(radio.getRootView());
            }
        });
    }

    public void secondTest(){
        radio = findViewById(R.id.raadDeSchaduwRadioGroupId);
        knop1 = findViewById(R.id.raadDeSchaduwEersteAntId);
        knop1.setText("Winnie de poo");
        RadioButton knop2 = findViewById(R.id.raadDeSchaduwTweedeAntId);
        knop2.setText("Donald Duck");
        RadioButton knop3 = findViewById(R.id.raadDeSchaduwDerdeAntId);
        knop3.setText("Lange jan");
        RadioButton knop4 = findViewById(R.id.raadDeSchaduwVierdeAntId);
        knop4.setText("Kabouter plop");

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(radio.getCheckedRadioButtonId() == R.id.raadDeSchaduwDerdeAntId){
                    victory(radio.getRootView());
                }
                else lose(radio.getRootView());
            }
        });
    }

    public void victory(View view){
        Snackbar snackbar = Snackbar
                .make(view,"Het antwoord is goed.", Snackbar.LENGTH_LONG);

        snackbar.show();

        correct = correct + 1;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);
            }
        }, 1000); // Millisecond 1000 = 1 sec
    }

    public void lose(View view){
        Snackbar snackbar = Snackbar
                .make(view,"Het antwoord is fout.", Snackbar.LENGTH_LONG);

        snackbar.show();

        wrong = wrong+1;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);
            }
        }, 1500); // Millisecond 1000 = 1 sec
    }
}
