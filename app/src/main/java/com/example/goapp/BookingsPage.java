package com.example.goapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BookingsPage extends AppCompatActivity {
private ImageView eaplogo;
private ImageView emaruti;
private Button epastbtn;
private Button epresentbtn;
private Button eupcomingbtn;
private TextView emarutitxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings_page);
        eaplogo = findViewById(R.id.eapplogo);
        emaruti = findViewById(R.id.eswift5);
        epastbtn = findViewById(R.id.epastbutton);
        epresentbtn = findViewById(R.id.epresentbutton);
        eupcomingbtn = findViewById(R.id.eupcomingbtn);
        emarutitxt = findViewById(R.id.eswifttxt);
    }
}