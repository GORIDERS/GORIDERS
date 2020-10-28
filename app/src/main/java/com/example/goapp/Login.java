package com.example.goapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText eName;
    private ImageView eimageview;
    private EditText epassword;
    private Button eLog;
    private EditText eForgotpass;
    private Button eSignup;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        eimageview = findViewById(R.id.imageView);
        eName = findViewById(R.id.etName);
        epassword = findViewById(R.id.etPassword);
        eLog = findViewById(R.id.etLgbtn);
        eForgotpass = findViewById(R.id.etforgotpass);
        eSignup = findViewById(R.id.etsign);

        eSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));
            }
        });


        eLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = eName.getText().toString();
                String userPassword = epassword.getText().toString();
                firebaseAuth = FirebaseAuth.getInstance();

                if (userName.isEmpty()) {
                    eName.setError("Please enter your Username@gmail.com");
                    eName.requestFocus();
                } else if (userPassword.isEmpty()) {
                    epassword.setError("Please enter your password");
                    epassword.requestFocus();
                } else if (!userName.isEmpty() && !userPassword.isEmpty()) {
                    firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Login failed , please enter correct details..", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(Login.this, "Login Successfull!!!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this, Homepage.class));
                            }
                        }
                    });
                }


            }

        });
    }

}




