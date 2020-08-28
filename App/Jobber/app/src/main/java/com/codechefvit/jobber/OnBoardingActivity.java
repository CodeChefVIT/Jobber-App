package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class OnBoardingActivity extends AppCompatActivity {

    private int[] images;
    private String[] texts;
    private RecyclerView recyclerView;
    private OnboardAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        images=new int[]{R.drawable.lazy,R.drawable.secure,R.drawable.kid,R.drawable.earn};
        texts=new String[] {"It lets you relax","Its secure","Its effortless","You can help and earn"};

        recyclerView=findViewById(R.id.onboardrecycler);
        layoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManager);
        adapter=new OnboardAdapter(texts,images,this);
        recyclerView.setAdapter(adapter);
    }
}
