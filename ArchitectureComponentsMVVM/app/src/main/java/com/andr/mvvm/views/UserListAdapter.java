package com.andr.mvvm.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andr.mvvm.R;
import com.andr.mvvm.repository.User;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {


    class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView userNameView;
        private  final TextView userOccupationView;

        private UserViewHolder(View itemView) {
            super(itemView);
            userNameView = itemView.findViewById(R.id.user_name);
            userOccupationView = itemView.findViewById(R.id.user_occ);
        }
    }

    private final LayoutInflater mInflater;
    private List<User> mUsers; // Cached copy of users


    UserListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.adapter_user_item, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (mUsers != null) {
            User current = mUsers.get(position);
            holder.userNameView.setText(current.getUserName());
            holder.userOccupationView.setText(current.getUserOccupation());
        } else {
            // Covers the case of data not being ready yet.
            holder.userNameView.setText("No Word");
        }
    }
    void setWords(List<User> users){
        mUsers = users;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mUsers != null) {
            return mUsers.size();
        }else{
            return  0;
        }
    }
}
