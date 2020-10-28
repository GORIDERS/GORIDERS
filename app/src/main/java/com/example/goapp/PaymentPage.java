package com.example.goapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentPage extends AppCompatActivity {
    private ImageView elogo1;
    private Button eatm;
    private Button enet;
    private TextView erupeenet;
    private Button booking;
    private ImageView enetimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        elogo1 = findViewById(R.id.elogo1);
        eatm= findViewById(R.id.eatm);
        enet = findViewById(R.id.enet);
        erupeenet = findViewById(R.id.erptxt);
        enetimg = findViewById(R.id.epayimg);

        booking = findViewById(R.id.booking);booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PaymentPage.this, BookingsPage.class));
            }
        });
    }
}