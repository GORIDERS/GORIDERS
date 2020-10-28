package com.example.goapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Homepage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Switch switch_btn;
    private CalendarView eEndDat;
    private CalendarView eStartDat;
    private TextView ehed;
    private TextView estart;
    private TextView eend;
    private TextView eselect;
    private TextView etype;
    private Button eSearch;

    SaveState saveState;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        saveState=new SaveState(this);
        if(saveState.getState()==true)
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        else
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);


        setContentView(R.layout.activity_homepage);

        ehed = findViewById(R.id.ehead);
        estart = findViewById(R.id.eStartDatetxt);
        eend = findViewById(R.id.eEndDatetxt);
        eselect = findViewById(R.id.eselectcity);
        etype = findViewById(R.id.eTypeofcar);
        eEndDat = findViewById(R.id.eEndDate);
        eStartDat = findViewById(R.id.eStartDate);
        eSearch = findViewById(R.id.esearchcar);

        eSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,CartypePage.class));
            }
        });

        Spinner spinner = findViewById(R.id.spcity);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.city,  android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner = findViewById(R.id.spcar);
        adapter = ArrayAdapter.createFromResource(this, R.array.Cartype, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        switch_btn = findViewById(R.id.switch_btn);

        if(saveState.getState()==true)
            switch_btn.setChecked(true);

        switch_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    saveState.setState(true);
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else {
                    saveState.setState(false);
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });
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