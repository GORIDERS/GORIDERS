package com.example.goapp;


import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


public class BookingsPage extends AppCompatActivity {
    DrawerLayout drawerLayout;
    public ImageView emaruti;

/*private Button epastbtn;
private Button epresentbtn;
private Button eupcomingbtn;*/

    public TextView emarutitxt;
    TextView etrupe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings_page);

        drawerLayout = findViewById(R.id.drawer_layout);

        ImageView eaplogo = findViewById(R.id.eapplogo);
        emaruti = findViewById(R.id.eswift5);
        etrupe = findViewById(R.id.etrupe);
        /*Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String Price=intent.getStringExtra("price");
        int image=intent.getIntExtra("image",0);
        etrupe.setText(Price);
        emaruti.setImageResource(image);
        emarutitxt.setText(name);
        Log.d("name",name+ " "+Price);*/

        /*epastbtn = findViewById(R.id.epastbutton);
        epresentbtn = findViewById(R.id.epresentbutton);
        eupcomingbtn = findViewById(R.id.eupcomingbtn);*/

        emarutitxt = findViewById(R.id.eswifttxt);
    }
    public void ClickMenu(View view){
    Homepage.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        Homepage.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view){
        Homepage.redirectActivity(this,Homepage.class);
    }

    public void ClickBookings(View view){
      recreate();
    }

    public void ClickLogout(View view){
        Homepage.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Homepage.closeDrawer(drawerLayout);
    }


}
