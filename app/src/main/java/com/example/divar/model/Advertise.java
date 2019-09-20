package com.example.divar.model;

import java.util.UUID;

public class Advertise {
    private UUID uuid;
    private String title;
    private String description;
    private String phoneNumber;
    private String address;
    private boolean isSpecial;

    public Advertise() {
        uuid = UUID.randomUUID();
    }


    public Advertise(UUID uuid, String title, String description, String phoneNumber, String address, boolean isSpecial) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isSpecial = isSpecial;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public void setSpecial(boolean special) {
        isSpecial = special;
    }
}
