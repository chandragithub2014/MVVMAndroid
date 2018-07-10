package com.mvvm.kot.Kotlin_Retrofit.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mvvm.kot.Kotlin_Retrofit.Repository.ResultModel
import com.mvvm.kot.R

public class UserPostAdapter(): RecyclerView.Adapter<UserPostAdapter.UserPostHolder>() {
     var  postList: List<ResultModel>?=null
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserPostHolder {

        return UserPostHolder(LayoutInflater.from(parent?.context).inflate(R.layout.adapter_retro_post_item,parent,false))
    }

    override fun onBindViewHolder(holder: UserPostHolder?, position: Int) {
        holder!!.retroId?.text=postList!!.get(position).getUserId()
        holder!!.retroTitle?.text=postList!!.get(position).getTitle()
        holder!!.retroBody.text=postList!!.get(position).getBody()

    }

    override fun getItemCount(): Int {
        if(postList!=null) {
            return postList!!.size
        }else
            return  0;
    }

    public fun setListItems(postList: List<ResultModel>?){
        this.postList = postList;
        notifyDataSetChanged()
    }
    class UserPostHolder(view: View): RecyclerView.ViewHolder(view){
      val retroId = view.findViewById<TextView>(R.id.retro_id)
      val retroTitle = view.findViewById<TextView>(R.id.retro_title)
      val retroBody = view.findViewById<TextView>(R.id.retro_body)
    }

}