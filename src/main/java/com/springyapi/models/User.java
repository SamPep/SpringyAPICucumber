package com.springyapi.models;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class User {

    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String ipAddress;
    private double latitude;
    private double longitude;

    public User (int id, String first_name, String last_name, String email, String ipAddress, double latitude, double longitude) {
        this.id = id;
        this. first_name = first_name;
        this. last_name = last_name;
        this.email = email;
        this.ipAddress = ipAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
