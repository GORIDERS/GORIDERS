package com.example.goapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

public class Homepage extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    private Switch switch_btn;
    private TextView ehed;
    private TextView estart;
    private TextView eend;
    private TextView eselect;
    private TextView etype;
    private Button eSearch;
    private Button sdbutton;
    private Button edbutton;
    private Button pickbutton;
    private TextView picktext,droptext;


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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
          getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        ehed = findViewById(R.id.ehead);
        estart = findViewById(R.id.eStartDatetxt);
        eend = findViewById(R.id.eEndDatetxt);
        eselect = findViewById(R.id.eselectcity);
        etype = findViewById(R.id.eTypeofcar);
        edbutton = findViewById(R.id.edbutton);
        sdbutton = findViewById(R.id.sdbutton);
        pickbutton = findViewById(R.id.pickbutton);
        Button dropbutton = findViewById(R.id.dropbutton);
        picktext = findViewById(R.id.picktext);
        droptext = findViewById(R.id.droptext);
        eSearch = findViewById(R.id.esearchcar);

        edbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleEndDateButton();
            }
        });

        sdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              handleStartDateButton();
            }


        });





        pickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlePickupButton();

            }
        });


        dropbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleDropButton();
            }
        });




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

    public void setSupportActionBar(Toolbar toolbar) {
    }

    private void handleDropButton() {
        Calendar calendar = Calendar.getInstance();
        int DHour = calendar.get(Calendar.HOUR);
        int DMinute = calendar.get(Calendar.MINUTE);

        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                //String timeString = "hour: " + hour + "minute: " + minute;
                //picktext.setText(timeString);

                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(Calendar.HOUR, hour);
                calendar2.set(Calendar.MINUTE, minute);

                CharSequence charSequence = DateFormat.format("hh:mm a", calendar2);
                droptext.setText(charSequence);

            }
        }, DHour, DMinute, is24HourFormat);
        timePickerDialog.show();
    }

    private void handlePickupButton() {
        Calendar calendar = Calendar.getInstance();
        int Hour = calendar.get(Calendar.HOUR);
        int Minute = calendar.get(Calendar.MINUTE);

        boolean is24HourFormat = DateFormat.is24HourFormat(this);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                //String timeString = "hour: " + hour + "minute: " + minute;
                //picktext.setText(timeString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR, hour);
                calendar1.set(Calendar.MINUTE, minute);

                CharSequence charSequence = DateFormat.format("hh:mm a", calendar1);
                picktext.setText(charSequence);

            }
        }, Hour, Minute, is24HourFormat);
        timePickerDialog.show();

    }


    private void handleEndDateButton() {
        Calendar calendar = Calendar.getInstance();
        int EYear = calendar.get(Calendar.YEAR);
        int EMonth = calendar.get(Calendar.MONTH);
        int EDate = calendar.get(Calendar.DATE);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int date) {
                    Calendar calendar2 = Calendar.getInstance();
                    calendar2.set(Calendar.YEAR, year);
                    calendar2.set(Calendar.MONTH, month);
                    calendar2.set(Calendar.DATE, date);

                    CharSequence dateCharSequence = DateFormat.format("EEEE, dd MMM yyyy", calendar2);
                    eend.setText(dateCharSequence);
                }
            }, EYear, EMonth , EDate);
            datePickerDialog.show();
        }




    private void handleStartDateButton() {
        Calendar calendar = Calendar.getInstance();
        int Year = calendar.get(Calendar.YEAR);
        int Month = calendar.get(Calendar.MONTH);
        int Date = calendar.get(Calendar.DATE);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int date) {
                //String  dateString = date + " " + month +" " + year;
                //estart.setText(dateString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE, date);

                CharSequence dateCharSequence = DateFormat.format("EEEE, dd MMM yyyy", calendar1);
                estart.setText(dateCharSequence);
            }
        }, Year, Month, Date);
        datePickerDialog.show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.nav_bookings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Bookings()).commit();
            break;
           // case R.id.nav_home:
             //   getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();
               // break;
            case R.id.nav_contactus:
                Toast.makeText(this,"Contact here : 0142225480 , gmail : goriders@gmail.com",Toast.LENGTH_SHORT).show();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}