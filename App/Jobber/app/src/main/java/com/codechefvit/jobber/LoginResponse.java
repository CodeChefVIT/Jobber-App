package com.codechefvit.jobber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("username_exists")
    @Expose
    private boolean usernameExists;
    @SerializedName("domain_vit")
    @Expose
    private boolean domainVit;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean getUsernameExists() {
        return usernameExists;
    }

    public void setUsernameExists(Boolean usernameExists) {
        this.usernameExists = usernameExists;
    }

    public boolean getDomainVit() {
        return domainVit;
    }

    public void setDomainVit(Boolean domainVit) {
        this.domainVit = domainVit;
    }

}