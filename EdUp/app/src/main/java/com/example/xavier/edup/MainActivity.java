package com.example.xavier.edup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button mathGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mathGame = (Button) findViewById(R.id.button_main);

        mathGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mathGame = new Intent(MainActivity.this, MathGame.class);
                startActivity(mathGame);
            }
        });

    }
}
