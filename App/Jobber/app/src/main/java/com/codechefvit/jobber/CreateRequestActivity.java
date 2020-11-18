package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
    }
}