package com.codechefvit.jobber;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.leanback.app.OnboardingSupportFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class OnBoardingActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        final ViewPager pager=findViewById(R.id.onboardviewpager);
        SmartTabLayout indicator=findViewById(R.id.onboardindicator);
        final Button button=findViewById(R.id.nextbtn);

        FragmentStatePagerAdapter fragmentStatePagerAdapter=new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position)
                {
                    case 0:
                        return new OnBoardingFirstFragment();
                    case 1:
                        return new OnBoardingSecondFragment();
                    case 2:
                        return new OnBoardingThirdFragment();
                    case 3:
                        return new OnBoardingFourthFragment();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };

        pager.setAdapter(fragmentStatePagerAdapter);
        indicator.setViewPager(pager);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pager.getCurrentItem()==3)
                {
                    SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
                    preferences.edit().putBoolean("onboarding_complete",true).apply();
                    Intent intent = new Intent(OnBoardingActivity.this,SignupActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                    pager.setCurrentItem(pager.getCurrentItem() + 1, true);
            }
        });

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if(position == 3)
                    button.setText("Get Started");
                else
                    button.setText("Next");
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
