package com.mvvm.kot.Kotlin_tabs.views

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import com.mvvm.kot.Kotlin_tabs.Repository_RetroFitList.ResultModel

import com.mvvm.kot.Kotlin_tabs.interfaces.OnItemClickListener

import com.mvvm.kot.R
import com.mvvm.kot.ViewModels.User
import com.mvvm.kot.databinding.RetrofitAdapterBindingTabs


public class PostsAdapter(onItemClickListener:OnItemClickListener): RecyclerView.Adapter<PostsAdapter.UserPostHolder>() {
     var  postList: List<ResultModel>?=null
     var  itemListener:OnItemClickListener = onItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostHolder {
        val postItemBinding: RetrofitAdapterBindingTabs = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),R.layout.adapter_retro_post_item_binding_tab,parent,false)
        //  val userPostHolder:UserPostHolder = UserPostHolder(postItemBinding)
        return UserPostHolder(postItemBinding)
    }

    override fun onBindViewHolder(holder: UserPostHolder, position: Int) {
        holder!!.postItemBinding.model = postList!!.get(position)
       /* holder!!.apply {
            postItemBinding.model = postList!!.get(position)

        }*/



        holder.itemView.setOnClickListener(View.OnClickListener {
            itemListener.onItemClick(holder!!.postItemBinding.model)
        })

    }


   /* override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserPostHolder {

        val postItemBinding: RetrofitAdapterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context),R.layout.adapter_retro_post_item_binding,parent,false)
      //  val userPostHolder:UserPostHolder = UserPostHolder(postItemBinding)
        return UserPostHolder(postItemBinding)
        //    return UserPostHolder(LayoutInflater.from(parent?.context).inflate(R.layout.adapter_retro_post_item_binding,parent,false))
    }

    override fun onBindViewHolder(holder: UserPostHolder?, position: Int) {
        *//*holder!!.retroId?.text=postList!!.get(position).getId().toString()
        holder!!.retroTitle?.text=postList!!.get(position).getTitle()
        holder!!.retroBody.text=postList!!.get(position).getBody()*//*
        holder!!.postItemBinding.model = postList!!.get(position)

    }*/

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
   /* class UserPostHolder(view: View): RecyclerView.ViewHolder(view){
      val retroId = view.findViewById<TextView>(R.id.retro_id)
      val retroTitle = view.findViewById<TextView>(R.id.retro_title)
      val retroBody = view.findViewById<TextView>(R.id.retro_body)
    }*/

    inner class UserPostHolder(var postItemBinding: RetrofitAdapterBindingTabs) : RecyclerView.ViewHolder(postItemBinding.getRoot())

}