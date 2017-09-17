package com.example.xavier.edup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import user.*;

public class SignUp extends AppCompatActivity {



    //Buttons
    Button cancel;
    Button submit;
    //User
    User mUser;
    UserList mUserList;



    //EditText
    EditText mFirstName;
    EditText mLastName;
    EditText mPhoneNumber;
    EditText mEmail;
    EditText mPassword;
    EditText mReenterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mUserList = UserList.getInstance();

        //Buttons
        cancel = (Button) findViewById(R.id.cancel_signup);
        submit = (Button) findViewById(R.id.submit_signup);
        //EditText
        mFirstName = (EditText) findViewById(R.id.first_name_signup);
        mLastName  = (EditText) findViewById(R.id.last_name_signup);
        mPhoneNumber  = (EditText) findViewById(R.id.phone_number_signup);
        mEmail = (EditText) findViewById(R.id.email_signup);
        mPassword  = (EditText) findViewById(R.id.password_signup);
        mReenterPassword  = (EditText) findViewById(R.id.reenter_password_signup);



        /**
         * Click SUBMIT
         */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //If entries empty
                if(mFirstName.getText().toString().trim().isEmpty() ||
                        mLastName.getText().toString().trim().isEmpty() ||
                        mPhoneNumber.getText().toString().trim().isEmpty() ||
                        mEmail.getText().toString().trim().isEmpty() ||
                        mPassword.getText().toString().trim().isEmpty() ||
                        mReenterPassword.getText().toString().trim().isEmpty()) {

                    Toast.makeText(SignUp.this, R.string.error_empty_signup, Toast.LENGTH_SHORT).show();
                }
                //Check same password
                else if(mPassword.getText().toString().trim().compareTo(mReenterPassword.getText().toString().trim()) == 0)
                {


                    //Attempt to add user
                    boolean check_addUser = mUserList.addUser(mFirstName.getText().toString().trim(),
                            mLastName.getText().toString().trim(),
                            mEmail.getText().toString().trim().toLowerCase(),
                            mPassword.getText().toString().trim(),
                            Integer.parseInt(mPhoneNumber.getText().toString().trim()));


                    //ADD USER
                    if (check_addUser) {
                        Toast.makeText(SignUp.this, R.string.good_login_check_message, Toast.LENGTH_SHORT).show();

                        Intent login = new Intent(SignUp.this, Login.class);
                        startActivity(login);

                    }

                    else {
                        Toast.makeText(SignUp.this, R.string.error_signup, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(SignUp.this, R.string.password_no_match_signup, Toast.LENGTH_SHORT).show();
                }







            }
        });

        /**
         * Click CANCEL
         */
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent login = new Intent(SignUp.this, Login.class);
                startActivity(login);
            }
        });
    }
}
