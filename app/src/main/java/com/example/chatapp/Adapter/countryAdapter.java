package com.example.chatapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.chatapp.Data.Country;
import com.example.chatapp.R;

import java.util.List;

public class countryAdapter extends ArrayAdapter<Country> {



    public countryAdapter(@NonNull Context context, int countryList, @NonNull List<Country> objects) {
        super(context, countryList, objects);
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_country_selected,viewGroup,false);
        TextView txt_country = rootView.findViewById(R.id.txt_country);
        ImageView img = rootView.findViewById(R.id.img);
        Country country = this.getItem(i);
        txt_country.setText(country.getName());
        img.setImageResource(country.getImg());

        return rootView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_country,parent,false);
        TextView txt_country = convertView.findViewById(R.id.txt_country);
        ImageView img = convertView.findViewById(R.id.img);
        Country country = this.getItem(position);
        txt_country.setText(country.getName());
        img.setImageResource(country.getImg());
        return convertView;

    }
}
