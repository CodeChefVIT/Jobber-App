package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class LiveRequestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_requests);

        findViewById(R.id.liverequestback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiveRequestsActivity.super.onBackPressed();
            }
        });

        ImageView edit=findViewById(R.id.editdesc);
        MaterialButton button=findViewById(R.id.close);
        final MaterialButton btn=findViewById(R.id.liverequestsave);
        TextView compl=findViewById(R.id.completion);
        EditText editText=findViewById(R.id.liverequestDesc);

        int id=getIntent().getIntExtra("Request ID",0);
        if(id==1 || id==2 || id==3)
        {
            edit.setVisibility(View.GONE);
            compl.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
            btn.setVisibility(View.GONE);
            editText.setFocusable(false);
            editText.setEnabled(true);
            editText.setCursorVisible(false);
        }
        else
        {
            edit.setVisibility(View.VISIBLE);
            compl.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.GONE);
            editText.setFocusable(false);
            editText.setEnabled(false);
            editText.setCursorVisible(false);

            findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.close).setVisibility(View.INVISIBLE);
                    findViewById(R.id.completion).setVisibility(View.VISIBLE);
                }
            });

            findViewById(R.id.editdesc).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText=findViewById(R.id.liverequestDesc);
                    editText.setFocusableInTouchMode(true);
                    editText.setEnabled(true);
                    editText.setCursorVisible(true);
                    btn.setVisibility(View.VISIBLE);
                }
            });
        }

    }
}