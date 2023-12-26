package com.example.chatapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.chatapp.Adapter.UserAdapter;
import com.example.chatapp.Data.DataCountry;
import com.example.chatapp.R;
import com.example.chatapp.Adapter.pageAdapter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer_layout;
    NavigationView navigation_View;
    Toolbar toolbar;
    ViewPager2 viewPager;
    TabLayout tab_layout;
    pageAdapter myPageAdapter;
    UserAdapter userAdapter;
    Button btn_login;
    SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer_layout = findViewById(R.id.drawer_layout);
        navigation_View=findViewById(R.id.navigation_View);
        toolbar  =findViewById(R.id.toolbar);
        viewPager=findViewById(R.id.viewPager);
        tab_layout = findViewById(R.id.tab_layout);


//        -------------------------------------toolbar-------------------------
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        -------------------------------------navigation menu----------------------
        navigation_View.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.naviga_view_open,R.string.naviga_view_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
        navigation_View.setNavigationItemSelectedListener(this);
//-------------------------------------------------------ViewPager-----------------------------
        myPageAdapter = new pageAdapter(this);
        viewPager.setAdapter(myPageAdapter);
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tab_layout.getTabAt(position).select();
            }
        });



//        ----------------------------------------tabLayout-----------------------------------





    }

    @Override
    public void onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return true;
    }

//    -------------------------------------------search ----------------------------------------------

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
//        userAdapter = new UserAdapter(DataCountry.getCountryList());
//        RecyclerView recycle = findViewById(R.id.recycle);
//        recycle.setAdapter(userAdapter);
//        searchView = (SearchView) menuItem.getActionView();
//        searchView.setQueryHint("type here to search");
//        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                userAdapter.getFilter().filter(query);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                userAdapter.getFilter().filter(newText);
//                return false;
//            }
//        });
        return true;
    }
}