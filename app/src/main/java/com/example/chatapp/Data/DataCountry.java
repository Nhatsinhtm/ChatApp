package com.example.chatapp.Data;

import com.example.chatapp.R;

import java.util.ArrayList;
import java.util.List;

public class DataCountry {
public static List<Country> getCountryList(){
    List<Country> countryList = new ArrayList<>();

    Country VietNam = new Country();
    VietNam.setName("Việt Nam");
    VietNam.setCode("+84");
    VietNam.setImg(R.drawable.quockyvietnam);
    countryList.add(VietNam);

    Country Laos = new Country();
    Laos.setName("Lào");
    Laos.setCode("+856");
    Laos.setImg(R.drawable.laos);
    countryList.add(Laos);

   Country Campuchia = new Country();
    Campuchia.setName("Campuchia");
    Campuchia.setCode("+855");
    Campuchia.setImg(R.drawable.campuchia);
    countryList.add(Campuchia);

    return countryList;
}
}
