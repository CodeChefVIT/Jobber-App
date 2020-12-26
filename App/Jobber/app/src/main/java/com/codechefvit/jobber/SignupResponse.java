package com.codechefvit.jobber;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignupResponse {

    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("reg_number")
    @Expose
    private String regNumber;
    @SerializedName("hostel_room")
    @Expose
    private String hostelRoom;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("gender")
    @Expose
    private String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getHostelRoom() {
        return hostelRoom;
    }

    public void setHostelRoom(String hostelRoom) {
        this.hostelRoom = hostelRoom;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}