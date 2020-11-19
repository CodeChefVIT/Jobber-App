package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.app.OnboardingSupportFragment;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences= getSharedPreferences("my_preferences",MODE_PRIVATE);
        if(!(sharedPreferences.getBoolean("onboarding_complete",false)))
        {
            Intent onboarding = new Intent(this, OnBoardingActivity.class);
            startActivity(onboarding);
        }

        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });

        findViewById(R.id.textView2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignupActivity.class));
            }
        });
    }
}
