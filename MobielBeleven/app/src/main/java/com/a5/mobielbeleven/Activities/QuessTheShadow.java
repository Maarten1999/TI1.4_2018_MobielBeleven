package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.a5.mobielbeleven.MQTT.MQTTConfig;
import com.a5.mobielbeleven.MQTT.MqttMessageService;
import com.a5.mobielbeleven.MQTT.PahoMqttClient;
import com.a5.mobielbeleven.R;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.UnsupportedEncodingException;

import static android.icu.lang.UProperty.MATH;

public class QuessTheShadow extends BaseToolbar {
    private int schaduw;
    private RadioButton knop1;
    private int correct;
    private int wrong;
    private ImageView iv;

    RadioGroup radio;

    private final String topic = "TI142018/A5/SHADOW";
    private MqttAndroidClient client;
    private PahoMqttClient pahoMqttClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raad_de_schaduw);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.raad_de_schaduw_titel);

        pahoMqttClient = new PahoMqttClient();

        client = pahoMqttClient.getMqttClient(
                getApplicationContext(),
                MQTTConfig.getInstance().MQTT_BROKER_URL(),
                MQTTConfig.getInstance().CLIENT_ID());

        try {
            Intent intent = new Intent(QuessTheShadow.this, MqttMessageService.class);
            startService(intent);
        } catch(Exception e) {
            e.printStackTrace();
        }

        iv = (ImageView) findViewById(R.id.raadDeSchaduwImageId);

        raadDeSchaduwSelecteren();
    }

    //This method generates a random number that's either 1 or 2.
    //The generated number decides what question will be displayed on the screen.
    public void raadDeSchaduwSelecteren(){
        schaduw = Math.round((float)(1 + Math.random()));

        switch(schaduw){
            case 1: firstTest();
                    break;
            case 2: secondTest();
                    break;
        }
    }

    //Method to generate the first quiz.
    public void firstTest(){
        iv.setImageResource(R.drawable.pardoes);
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

    //Method to generate the second quiz.
    public void secondTest(){
        iv.setImageResource(R.drawable.langejan);
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

    //If the answer is correct the snackbar will display this on the screen and send the score to the scoreboard.
    public void victory(View view){
        Snackbar.make(view,"Het antwoord is goed.", Snackbar.LENGTH_LONG).show();

        correct = correct + 1;

        MQTTConfig.getInstance().setMQTT_TOPIC(topic);
        try {
            pahoMqttClient.publishMessage(client,"{\"answer\":\"GOED\"}",0,MQTTConfig.getInstance().PUBLISH_TOPIC());
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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

    //If the answer is not correct the snackbar will display this on the screen and send the score to the scoreboard.
    public void lose(View view){
        Snackbar.make(view,"Het antwoord is fout.", Snackbar.LENGTH_LONG).show();

        wrong = wrong+1;

        //send message to mqtt
        MQTTConfig.getInstance().setMQTT_TOPIC(topic);
        try {
            pahoMqttClient.publishMessage(client,"{\"answer\":\"FOUT\"}",0,MQTTConfig.getInstance().PUBLISH_TOPIC());
        } catch (MqttException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

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
