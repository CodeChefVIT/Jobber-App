package com.codechefvit.jobber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("access_token")
    @Expose
    public String accessToken;
    @SerializedName("code")
    @Expose
    public String code;

    /**
     * No args constructor for use in serialization
     *
     */
    public User() {
    }

    public User(String accessToken, String code) {
        super();
        this.accessToken = accessToken;
        this.code = code;
    }

}