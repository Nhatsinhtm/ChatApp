package com.example.chatapp.Data;

import java.io.Serializable;

public class Country implements Serializable {

    private String name,code;
    private int img;

    public Country(String name, String code, int img) {
        this.name = name;
        this.code = code;
        this.img = img;
    }

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
