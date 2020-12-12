package com.example.goapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckoutPage extends AppCompatActivity {
    //DrawerLayout drawerLayout;
private Button pay;
private Button ecoupon;
private ImageView egreen;
private ImageView ered;
private TextView egreentxt;
private TextView eredtxt;
private TextView edisttype;
private TextView erupee;
private ImageView elogo;
private ImageView emahindra;
private TextView emahindratxt;
private TextView echeckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout_page);

        //drawerLayout = findViewById(R.id.drawer_layout);

        ecoupon = findViewById(R.id.ecoupon);
        elogo = findViewById(R.id.elogo);
        egreen = findViewById(R.id.egreen);
        egreentxt = findViewById(R.id.egreentxt);
        ered = findViewById(R.id.ered);
        eredtxt = findViewById(R.id.eredtxt);
        edisttype = findViewById(R.id.ecartype);
        erupee = findViewById(R.id.erupee);
        emahindra = findViewById(R.id.emahindra);
        emahindratxt = findViewById(R.id.emahindratxt);
        echeckout = findViewById(R.id.echecktext);



        pay = findViewById(R.id.epay);

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckoutPage.this, PaymentPage.class));
            }
        });

    }
    /*public void ClickMenu(View view){
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