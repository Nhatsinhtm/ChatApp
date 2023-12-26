package com.example.chatapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatapp.Adapter.UserAdapter;
import com.example.chatapp.ApiService;
import com.example.chatapp.Data.Country;
import com.example.chatapp.Data.DataCountry;
import com.example.chatapp.Data.User;
import com.example.chatapp.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Tag;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link all#} factory method to
 * create an instance of this fragment.
 */
public class all extends Fragment {



RecyclerView recycle;
ProgressBar progressBar;
UserAdapter userAdapter;

List<User> userList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all, container, false);
        recycle=view.findViewById(R.id.recycle);
        progressBar=view.findViewById(R.id.progressBar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        recycle.setLayoutManager(linearLayoutManager);

        fetchUsers();

        return view;
    }

    private void fetchUsers() {

//              https://api.jsonbin.io/v3/b/65812395266cfc3fde6aa19f
        //          X-ACCESS-KEY:$2a$10$Fe3IHMJPY8zsCz19zbao8.yQOGj04XIwr5sM12HjTXjl3u/fYGtCK
        Gson gson = new GsonBuilder().create();
        progressBar.setVisibility(View.VISIBLE);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(" https://api.jsonbin.io/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<User>> call = apiService.getApi();

        System.out.println();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                    System.out.println("zzz");
                if (response.isSuccessful()&& response.body() !=null){
                    userList.addAll(response.body());
                    userAdapter=new UserAdapter(userList);
                    recycle.setAdapter(userAdapter);
                    progressBar.setVisibility(View.GONE);
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                System.out.println("xxx" + call.toString() + t.getMessage());

            }
        });

    }
}