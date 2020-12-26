package com.codechefvit.jobber;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public class LoginApi {
    public interface LoginService{
        @POST("users/auth/google/")
        Call<LoginResponse> createUser(@Body User user);
    }

    public interface SignupService{
        @GET("users/me/form/")
        Call<SignupResponse> signupUser();

        @PATCH("users/me/form/")
        Call<SignupResponseResult> editUser(@Body SignupResponse signupResponse);
    }
}
