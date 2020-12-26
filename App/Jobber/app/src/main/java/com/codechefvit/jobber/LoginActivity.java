package com.codechefvit.jobber;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN=007;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        String serverClientID= "441940733300-nvmgluu3illb77gqdqdu5lp88167rhmn.apps.googleusercontent.com";
        final GoogleSignInOptions gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope(Scopes.DRIVE_APPFOLDER))
                .requestServerAuthCode(serverClientID)
                .requestEmail()
                .build();

        final GoogleSignInClient signInClient=GoogleSignIn.getClient(this,gso);
        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=signInClient.getSignInIntent();
                startActivityForResult(intent,RC_SIGN_IN);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RC_SIGN_IN)
        {
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(@NonNull Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            String authcode=account.getServerAuthCode();
            postCode(authcode);
        } catch (ApiException e) {
            Log.d("Here",e.getMessage());
        }
    }

    public void postCode(String authcode)
    {
        String baseurl="https://jobber-vit.herokuapp.com/api/v1/";
        String atoken="";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LoginApi.LoginService service=retrofit.create(LoginApi.LoginService.class);
        User user=new User(atoken,authcode);
        Call<LoginResponse> call=service.createUser(user);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse=response.body();
                String key=loginResponse.getKey();
                boolean usernameExists=loginResponse.getUsernameExists();
                boolean domainVIT=loginResponse.getDomainVit();
                if(usernameExists==true){
                    Intent intent=new Intent(LoginActivity.this,RequestsActivity.class);
                    intent.putExtra("token", key);
                    startActivity(intent);
                }
                else {
                    if(domainVIT==true){
                        Intent intent=new Intent(LoginActivity.this,SignupActivity.class);
                        intent.putExtra("token", key);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Please enter VIT email id", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("Failure", "Failure"+t.getLocalizedMessage());
            }
        });

    }
}
