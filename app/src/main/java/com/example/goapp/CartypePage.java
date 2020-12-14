package com.example.goapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartypePage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RecyclerView recyclerView;
    Button upload;
    RecycleClass recycleClass;
    List<RecycleClass> recycleClassesList;
    RecyclerAdapter recyclerAdapter;
    //DrawerLayout drawerLayout;
private Button ebutton1;
private TextView efuel;
private TextView ecar;
private ImageView eswift;
private TextView eswifttxt;
private ImageView emahindra;
private TextView emahindtxt;
private ImageView eapplogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartype_page);

        //drawerLayout = findViewById(R.id.drawer_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        efuel = findViewById(R.id.efueltp);
        ecar = findViewById(R.id.ecartype);
        eswift = findViewById(R.id.eswift5);
        eswifttxt = findViewById(R.id.eswifttxt);
        emahindra = findViewById(R.id.elogo);
        emahindtxt = findViewById(R.id.emahindratxt);
        eapplogo = findViewById(R.id.eapplogo);

        ebutton1 = findViewById(R.id.button1);
        ebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartypePage.this, CheckoutPage.class));
            }
        });

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.FuelType,  android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = findViewById(R.id.spinner3);
        adapter = ArrayAdapter.createFromResource(this, R.array.Cartype, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleClassesList=new ArrayList<>();
        recycleClassesList.add(new RecycleClass(R.drawable.ma,"Mahindra Xuv 300","2500"));
        recycleClassesList.add(new RecycleClass(R.drawable.tata,"Mahindra marazzo tr","3500"));
        recycleClassesList.add(new RecycleClass(R.drawable.maruti_alto,"Maruti Suzuki Alto","1500"));
        recycleClassesList.add(new RecycleClass(R.drawable.ttata_tiago,"Tata Tiago","3000"));
        recycleClassesList.add(new RecycleClass(R.drawable.maruti_ertiga,"Maruti Ertiga","4500"));
        recycleClassesList.add(new RecycleClass(R.drawable.suzuki_swift,"Maruti Suzuki Swift","2500"));
        recycleClassesList.add(new RecycleClass(R.drawable.tata_nexon,"Tata Nexon","4000"));

        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(recycleClassesList,this);
        recyclerView.setAdapter(recyclerAdapter);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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