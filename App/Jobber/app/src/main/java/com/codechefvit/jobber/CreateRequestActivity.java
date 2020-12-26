package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class CreateRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_request);

        findViewById(R.id.createrequestback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateRequestActivity.super.onBackPressed();
            }
        });

        final Button addloc=findViewById(R.id.createrequestlocation);
        addloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu pop=new PopupMenu(CreateRequestActivity.this,addloc);
                pop.getMenuInflater().inflate(R.menu.locations,pop.getMenu());
                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        addloc.setText(item.getTitle());
                        return true;
                    }
                });
                pop.show();
            }
        });

        final TextView time = findViewById(R.id.addtime);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar=Calendar.getInstance();
                int hour=calendar.get(Calendar.HOUR_OF_DAY);
                final int min=calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog;
                timePickerDialog=new TimePickerDialog(CreateRequestActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if(minute>=10)
                            time.setText(hourOfDay+" : "+minute);
                        else
                            time.setText(hourOfDay+" : 0"+minute);
                    }
                },hour,min,true);
                timePickerDialog.show();
            }
        });
    }
}