package com.example.xavier.edup;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import problem.Generator;

public class MathGame extends AppCompatActivity {

    TextToSpeech toSpeech;
    int result;
    TextView score;
    EditText answer;
    String test;
    boolean firstTime = true;
    static int scoreVal = 0;

    Generator gen = Generator.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_game);


        score = (TextView) findViewById(R.id.score);
        answer = (EditText) findViewById(R.id.math_answer);



        toSpeech = new TextToSpeech(MathGame.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS)
                {
                    result = toSpeech.setLanguage(Locale.US);
                }
                else {
                    Toast.makeText(MathGame.this, "Feature is not supported", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }

    public void TTS(View view) {
        //Check answer
        if(!firstTime) {
            if(!answer.getText().toString().isEmpty()) {
                int eval = Integer.parseInt(answer.getText().toString().trim());
                if (eval == Generator.result) {
                    scoreVal++;
                } else {
                    scoreVal--;
                }
            }
            else {
                scoreVal--;
            }


            score.setText("Score: " + scoreVal);
            answer.setText("");
        }
        firstTime = false;

        switch (view.getId()){
            case R.id.done_button:
                //problem.setText(gen.makeProblem(1,1).toString());
                if (result == TextToSpeech.LANG_MISSING_DATA ||
                        result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(MathGame.this, "Feature not supported in your device", Toast.LENGTH_SHORT).show();
                }
                else {
                    test = gen.makeProblem(1,1).toString();
                    toSpeech.speak(test, TextToSpeech.QUEUE_FLUSH, null);
                }
                break;



        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (toSpeech != null)
        {
            toSpeech.stop();
            toSpeech.shutdown();
        }
    }


}
