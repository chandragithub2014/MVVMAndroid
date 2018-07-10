package com.andr.mvvm.RetofitMVVM.RetrofitViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andr.mvvm.R;
import com.andr.mvvm.RetofitMVVM.Repository.ResultModel;
import com.andr.mvvm.repository.User;

import java.util.List;

public class RetroPostListAdapter extends RecyclerView.Adapter<RetroPostListAdapter.PostViewHolder> {


    class PostViewHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private  final TextView title,body;

        private PostViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.retro_id);
            title = itemView.findViewById(R.id.retro_title);
            body = itemView.findViewById(R.id.retro_body);
        }
    }

    private final LayoutInflater mInflater;
    private List<ResultModel> mUsers; // Cached copy of users


    RetroPostListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.adapter_retro_post_item, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        if (mUsers != null) {
            ResultModel  current = mUsers.get(position);
            holder.id.setText(""+current.getId());
            holder.title.setText(current.getTitle());
            holder.body.setText(current.getBody());
        } else {
            // Covers the case of data not being ready yet.
           // holder.userNameView.setText("No Word");
        }
    }
    void setWords(List<ResultModel> users){
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
