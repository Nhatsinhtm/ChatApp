package com.example.chatapp.Adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.chatapp.fragment.Pined;
import com.example.chatapp.fragment.Read;
import com.example.chatapp.fragment.all;
import com.example.chatapp.fragment.unread;

public class pageAdapter extends FragmentStateAdapter {


    public pageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new all();
            case 1: return new Read();
            case 2: return new unread();
            case 3: return new Pined();
            default: return new all();
        }

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
