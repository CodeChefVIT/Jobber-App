package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.leanback.app.OnboardingSupportFragment;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        if (!(sharedPreferences.getBoolean("onboarding_complete", false))) {
            Intent onboarding = new Intent(this, OnBoardingActivity.class);
            startActivity(onboarding);
        } else {
            GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
            if (account != null)
                startActivity(new Intent(this, RequestsActivity.class));
            else
                startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
