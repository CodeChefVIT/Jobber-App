package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class RequestsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int[] images;
    private String[] head;
    private String[] location;
    private RequestsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private DividerItemDecoration dividerItemDecoration;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        tabLayout=findViewById(R.id.tabs);
        int pos=tabLayout.getSelectedTabPosition();
        FloatingActionButton btn;
        switch(pos){
            case 0:
                images=new int[]{R.drawable.prof,R.drawable.prof,R.drawable.prof};
                head=new String[]{"Amazon Parcel","Flipkart Parcel","Amazon Parcel"};
                location=new String[]{"Main Gate","D-Annexe","Technology tower"};
                btn=findViewById(R.id.addbtn);
                btn.setEnabled(true);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(RequestsActivity.this,CreateRequestActivity.class));
                    }
                });
                break;
            case 1:
                    images=new int[]{R.drawable.prf2,R.drawable.prf3};
                    head=new String[]{"Amazon Parcel","Amazon Parcel"};
                    location=new String[]{"Main Gate","D-Annexe"};
                    btn=findViewById(R.id.addbtn);
                    btn.setEnabled(false);
                    break;
            default:
                    Toast.makeText(getApplicationContext(),"Wrong tab selected",Toast.LENGTH_LONG).show();
        }
        recyclerView=findViewById(R.id.requestrecyclerview);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RequestsAdapter(images,head,location,this);
        recyclerView.setAdapter(adapter);
        /*dividerItemDecoration=new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(dividerItemDecoration);*/
    }
}