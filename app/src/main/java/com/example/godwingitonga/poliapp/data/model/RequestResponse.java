package com.example.godwingitonga.poliapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by godwingitonga on 02/03/2018.
 */

public class RequestResponse {
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("name")
    @Expose
    private String name;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
