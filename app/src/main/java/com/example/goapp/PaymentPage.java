package com.example.goapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PaymentPage extends AppCompatActivity {
   // DrawerLayout drawerLayout;
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

       // drawerLayout = findViewById(R.id.drawer_layout);

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
   /* public void ClickMenu(View view){
        Homepage.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        Homepage.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        Homepage.redirectActivity(this,Homepage.class);
    }

    public void ClickBookings(View view){
        Homepage.redirectActivity(this,BookingsPage.class);
    }

    public void ClickLogout(View view){
        Homepage.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Homepage.closeDrawer(drawerLayout);
    }*/
}