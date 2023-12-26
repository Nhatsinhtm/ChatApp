package com.example.chatapp.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import com.example.chatapp.Data.User;
import com.example.chatapp.R;


import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.userViewHolder> {
    List<User> listUser;
    List<User> listUserOld;
    public UserAdapter(List<User> listUser) {
        this.listUser = listUser;
        this.listUserOld = listUser;
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_user,parent,false);

        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {

        if (listUser==null){
            return;
        }else{
//            holder.img_avatar.setImageResource(country.get());
            holder.txt_about.setText(listUser.get(position).getAbout());
            holder.txt_name.setText(listUser.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        if (listUser!=null){
            return listUser.size();
        }
        else {
            return 0;
        }

    }



    public static class userViewHolder extends RecyclerView.ViewHolder{

        TextView txt_name, txt_about;
        ImageView img_avatar;
        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_about= itemView.findViewById(R.id.txt_about);
            txt_name = itemView.findViewById(R.id.txt_name);
            img_avatar = itemView.findViewById(R.id.img_avatar);
        }
    }
//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                String strSearch = charSequence.toString();
//                if (strSearch.isEmpty()){
//                    listUser=listUserOld;
//                }
//                else {
//                    List<User> list = new ArrayList<>();
//                    for (User country : listUserOld){
//                        if (country.getName().toLowerCase().contains(strSearch.toLowerCase())){
//                            list.add(country);
//                        }
//                    }
//                    listUser =list;
//                }
//                FilterResults filterResults = new FilterResults();
//                filterResults.values =listUser;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//
//                listUser = (List<User>) filterResults.values;
//                notifyDataSetChanged();
//            }
//        };
//    }

}

