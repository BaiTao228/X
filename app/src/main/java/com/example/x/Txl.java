package com.example.x;

public class Txl {
    private String name;
    private int imageId;
    private String phone;

    public Txl(String name, int imageId, String phone) {
        this.name = name;
        this.imageId = imageId;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getPhone() {
        return phone;
    }
}
