package com.example.chatapp.Data;

import com.google.gson.Gson;

public class User {
    private String name , about, id;

    public User(String name, String about, String id) {
        this.name = name;
        this.about = about;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toJson(){
        Gson gson   = new Gson();
        return  gson.toJson(this);
    }
}
