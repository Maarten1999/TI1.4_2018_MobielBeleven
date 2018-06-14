package com.a5.mobielbeleven.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.a5.mobielbeleven.MQTT.MQTTConfig;
import com.a5.mobielbeleven.MQTT.MqttMessageService;
import com.a5.mobielbeleven.MQTT.PahoMqttClient;
import com.a5.mobielbeleven.R;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Random;

public class Puzzle extends BaseToolbar {

    private String puzzleQuestion;
    private String answer;
    private int attractionNumber = 1;
    TextView puzzleQuestionScreen;
    EditText answerScreen;
    TextView puzzleinfo;
    Button submit;
    private int index;

    private final String topic = "TI142018/A5/RIDDLE";
    private MqttAndroidClient client;
    private PahoMqttClient pahoMqttClient;
    private int tryCount;

    public Puzzle(String puzzleQuestion, String answer, int attractionNumber) {
        this.puzzleQuestion = puzzleQuestion;
        this.answer = answer;
        this.attractionNumber = attractionNumber;
    }

    public Puzzle() {
    }

    public String getPuzzleQuestion() {
        return puzzleQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_puzzle);
        displayToolbar();
        getSupportActionBar().setTitle(R.string.puzzle_text);
        super.onCreate(savedInstanceState);

        tryCount = 0;
        index = new Random().nextInt(2);

        puzzleQuestionScreen = findViewById(R.id.puzzle_question);
        puzzleQuestionScreen.setText(puzzleList[index].getPuzzleQuestion());

        puzzleinfo = findViewById(R.id.txt_good);
        puzzleinfo.setText("");
        answer = puzzleList[index].getAnswer();
        answerScreen = findViewById(R.id.answer_id);

        pahoMqttClient = new PahoMqttClient();

        client = pahoMqttClient.getMqttClient(
                getApplicationContext(),
                MQTTConfig.getInstance().MQTT_BROKER_URL(),
                MQTTConfig.getInstance().CLIENT_ID());

        try {
            Intent intent = new Intent(Puzzle.this, MqttMessageService.class);
            startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        submit = findViewById(R.id.submit_btn);
        submit.setText("submit");
        submit.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                tryCount++;
                if (correctAnswer()) {
//                        Toast toast = Toast.makeText(getApplicationContext(), "Goed", Toast.LENGTH_LONG);
//                        toast.show();
                    puzzleinfo.setText("Goed! \n Druk nogmaals op de knop om terug te gaan naar het hoofdscherm");

                    try {
                        MQTTConfig.getInstance().setMQTT_TOPIC(topic);
                        pahoMqttClient.publishMessage(client, "{\"answer\":\"GOED\"}", 0, MQTTConfig.getInstance().PUBLISH_TOPIC());
                    } catch (MqttException e) {
                        e.printStackTrace();
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    submit.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View view)
                        {
                            Intent intent = new Intent(
                                    getApplicationContext(),
                                    MainActivity.class
                            );
                            startActivity(intent);
                            finish();
                        }
                    });

                } else {
                    if (tryCount >= 3) {
                        puzzleinfo.setText("Fout! \n Druk nogmaals op de knop om terug te gaan naar het hoofdscherm.");

                        try {
                            MQTTConfig.getInstance().setMQTT_TOPIC(topic);
                            pahoMqttClient.publishMessage(client, "{\"answer\":\"FOUT\"}", 0, MQTTConfig.getInstance().PUBLISH_TOPIC());
                        } catch (MqttException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                        submit.setOnClickListener(new View.OnClickListener()
                        {
                            @Override
                            public void onClick(View view)
                            {
                                Intent intent = new Intent(
                                        getApplicationContext(),
                                        MainActivity.class
                                );
                                startActivity(intent);
                                finish();
                            }
                        });
                    } else {
                        puzzleinfo.setText("Fout! \n Je kan het nog " + String.valueOf(3 - tryCount) + " keer proberen.");
                    }
                }
            }
        });


    }


    public boolean correctAnswer()
    {
        String tempCorrectAnswer = answer.toLowerCase(Locale.getDefault());
        String tempUserAnswer = answerScreen.getText().toString().toLowerCase(Locale.getDefault());
        if (tempCorrectAnswer.equals(tempUserAnswer)) {
            return true;
        } else if (tempUserAnswer.contains("te ver")
                && tempUserAnswer.contains("lopen") && puzzleList[index].getAttractionNumber() == 2) {
            return true;
        } else if (tempUserAnswer.contains("22") && puzzleList[index].getAttractionNumber() == 3) {
            return true;
        }
        return false;
    }

    private static Puzzle[] puzzleList = {
            new Puzzle("Welke slang is ongevaarlijk? ", "tuinslang", 1),
            new Puzzle("Waarom vliegen vogels in de winter naar het zuiden?", "het is te ver lopen", 2),
            new Puzzle("Hoe lang leeft een goudvis gemiddeld? ", "22 jaar", 3)
    };

    public int getAttractionNumber()
    {
        return attractionNumber;
    }
}


