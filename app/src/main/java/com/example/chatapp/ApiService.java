package com.example.chatapp;

import com.example.chatapp.Data.User;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


public interface ApiService {



    @GET("v3/b/65812395266cfc3fde6aa19f")
    @Headers({"X-ACCESS-KEY:$2a$10$Fe3IHMJPY8zsCz19zbao8.yQOGj04XIwr5sM12HjTXjl3u/fYGtCK"})
    Call<List<User>> getApi();
}
