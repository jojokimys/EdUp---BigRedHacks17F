package com.example.xavier.edup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import user.UserList;


public class MainActivity extends AppCompatActivity {

    Button mathGame;
 
    UserList userList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mathGame = (Button) findViewById(R.id.button_main);
        userList = UserList.getInstance();



        mathGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mathGame = new Intent(MainActivity.this, MathGame.class);
                startActivity(mathGame);
            }
        });

    }
}
