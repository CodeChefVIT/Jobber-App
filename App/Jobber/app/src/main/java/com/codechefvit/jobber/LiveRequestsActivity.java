package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.button.MaterialButton;

public class LiveRequestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_requests);

        String id=getIntent().getStringExtra("Request ID");
        if(id=="1" || id=="2" || id=="3")
        {
            findViewById(R.id.editdesc).setVisibility(View.INVISIBLE);
            MaterialButton button=findViewById(R.id.close);
            button.setText("Save Changes");
            findViewById(R.id.completion).setVisibility(View.INVISIBLE);
            EditText editText=findViewById(R.id.requestDesc);
            editText.setFocusable(false);
            editText.setEnabled(false);
            editText.setCursorVisible(false);
        }
        else
        {
            findViewById(R.id.editdesc).setVisibility(View.VISIBLE);
            findViewById(R.id.completion).setVisibility(View.INVISIBLE);
            EditText editText=findViewById(R.id.requestDesc);
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
                    EditText editText=findViewById(R.id.requestDesc);
                    editText.setFocusable(true);
                    editText.setEnabled(true);
                    editText.setCursorVisible(true);
                }
            });
        }

    }
}