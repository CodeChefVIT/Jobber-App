package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

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

        final Button addloc=findViewById(R.id.location);
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
    }
}