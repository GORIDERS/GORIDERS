package com.example.goapp;

import androidx.appcompat.app.AppCompatActivity;

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

public class CartypePage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
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
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}