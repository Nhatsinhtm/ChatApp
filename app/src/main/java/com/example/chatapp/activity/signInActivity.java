package com.example.chatapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatapp.Adapter.countryAdapter;
import com.example.chatapp.Data.Country;
import com.example.chatapp.Data.DataCountry;
import com.example.chatapp.R;



public class signInActivity extends AppCompatActivity {

    Button btn_login;
    Spinner ccp;
    TextView txt_phone;
    countryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        txt_phone=findViewById(R.id.txt_phone);
        ccp =findViewById(R.id.ccp);
        btn_login = findViewById(R.id.btn_login);
        adapter = new countryAdapter(signInActivity.this,R.layout.list_country_selected,DataCountry.getCountryList());
       ccp.setAdapter(adapter);
       ccp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               txt_phone.setText(""+adapter.getItem(i).getCode());
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });
       btn_login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent myIntent = new Intent(signInActivity.this, MainActivity.class);
               startActivity(myIntent);
           }
       });

    }


}