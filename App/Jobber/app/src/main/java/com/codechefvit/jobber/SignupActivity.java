package com.codechefvit.jobber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity {
    private TextInputEditText editTextnm;
    private TextInputEditText editTextreg;
    private TextInputEditText editTextph;
    private TextInputEditText editTextrm;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        key=getIntent().getStringExtra("token");

        editTextnm=findViewById(R.id.signupusername);
        editTextreg=findViewById(R.id.signupregno);

        String baseurl="https://jobber-vit.herokuapp.com/api/v1/";
        Retrofit retrofit1=new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getHeader(key))
                .build();
        LoginApi.SignupService service1=retrofit1.create(LoginApi.SignupService.class);
        Call<SignupResponse> call1=service1.signupUser();
        call1.enqueue(new Callback<SignupResponse>() {
            @Override
            public void onResponse(Call<SignupResponse> call, Response<SignupResponse> response) {
                SignupResponse signupResponse=response.body();
                editTextnm.setText(signupResponse.getFirstName());
                editTextreg.setText(signupResponse.getRegNumber());
            }

            @Override
            public void onFailure(Call<SignupResponse> call, Throwable t) {
                Log.e("Failure", "Signup get request failed");
            }
        });


        findViewById(R.id.signupButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextph=findViewById(R.id.signupphno);
                String phno=editTextph.getText().toString();
                editTextrm=findViewById(R.id.signuproom);
                String room=editTextrm.getText().toString();
                radioGroup=findViewById(R.id.genderradio);
                radioButton=findViewById(radioGroup.getCheckedRadioButtonId());
                String gen=radioButton.getText().toString();
                final String gender;
                if(gen.compareTo("Male")==0)
                    gender="M";
                else
                    gender="F";

                String baseurl="https://jobber-vit.herokuapp.com/api/v1/";
                String name;
                String reg;

                Retrofit retrofit2=new Retrofit.Builder()
                        .baseUrl(baseurl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(getHeader(key))
                        .build();

                name=editTextnm.getText().toString();
                reg=editTextreg.getText().toString();
                SignupResponse response1=new SignupResponse();
                response1.setFirstName(name);
                response1.setRegNumber(reg);
                response1.setHostelRoom(room);
                response1.setGender(gender);
                response1.setPhone(phno);

                LoginApi.SignupService service2=retrofit2.create(LoginApi.SignupService.class);
                Call<SignupResponseResult> call2=service2.editUser(response1);
                call2.enqueue(new Callback<SignupResponseResult>() {
                    @Override
                    public void onResponse(Call<SignupResponseResult> call, Response<SignupResponseResult> response) {
                        SignupResponseResult result=response.body();
                        if(result.getSuccess()!=null)
                        {
                            Toast.makeText(getApplicationContext(), result.getSuccess(), Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(SignupActivity.this,RequestsActivity.class);
                            intent.putExtra("token", key);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<SignupResponseResult> call, Throwable t) {
                        Log.e("Failure", "Signup patch request failed");
                    }
                });
            }
        });
    }

    public OkHttpClient getHeader(final String authorizationValue)
    {
        OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request=chain.request().newBuilder().addHeader("Authorization", "Token "+authorizationValue).build();
                return chain.proceed(request);
            }
        });
        return httpClient.build();
    }

}
