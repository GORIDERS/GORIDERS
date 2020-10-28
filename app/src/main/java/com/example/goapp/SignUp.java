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

public class SignUp extends AppCompatActivity {
    private ImageView eimage;
    private EditText eEnternm;
    private EditText eEmail;
    private EditText eMobile;
    private EditText ePassword;
    private Button eRegister;
    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        eimage = findViewById(R.id.imageView3);
        eEnternm = findViewById(R.id.etname);
        eEmail = findViewById(R.id.etMail);
        eMobile = findViewById(R.id.etPhn);
        ePassword = findViewById(R.id.etpass);
        eRegister = findViewById(R.id.etReg);

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = eEmail.getText().toString();
                String password = ePassword.getText().toString();
                String mobile = eMobile.getText().toString();
                String name = eEnternm.getText().toString();
                firebaseAuth = FirebaseAuth.getInstance();

                if(email.isEmpty())
                {
                    eEmail.setError("Please enter your Username");
                    eEmail.requestFocus();
                }
                else if(password.isEmpty())
                {
                    ePassword.setError("Please enter your password");
                    ePassword.requestFocus();
                }
                else if(mobile.isEmpty())
                {
                    eMobile.setError("Please enter your password");
                    eMobile.requestFocus();
                }
                else if(name.isEmpty())
                {
                    eEnternm.setError("Please enter your password");
                    eEnternm.requestFocus();
                }
                else if(password.length() < 8)
                {
                    ePassword.setError("Password should be atleast 8 characters!");
                    ePassword.requestFocus();
                }

                else if(!email.isEmpty() && !password.isEmpty() && !mobile.isEmpty() && !name.isEmpty() )
                {
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(SignUp.this, "Signup failed , enter all the details", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(SignUp.this, "Signup Successfull!!!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, Homepage.class));
                            }
                        }
                    });
                }


            }
        });

    }



}