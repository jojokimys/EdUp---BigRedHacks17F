package com.example.xavier.edup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

import user.User;
import user.UserList;

public class Login extends AppCompatActivity {




    Button loginButton;
    Button signUpButton;


    //Singleton userList
    UserList userList = UserList.getInstance();

    //TextViews
    EditText mEmail;
    EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Buttons
        loginButton = (Button) findViewById(R.id.login_button);
        signUpButton = (Button) findViewById(R.id.sign_up_button);

        //EditText
        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sign_up = new Intent(Login.this, SignUp.class);
                startActivity(sign_up);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean loginCheck = userList.login(mEmail.getText().toString().trim() ,
                mPassword.getText().toString().trim());

                //User logs in
                if(loginCheck) {
                    Toast.makeText(Login.this, R.string.good_login_check_message, Toast.LENGTH_SHORT).show();

                    Intent main = new Intent(Login.this, MainActivity.class);
                    startActivity(main);


                }
                else {
                    Toast.makeText(Login.this, R.string.bad_login_check_message, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
