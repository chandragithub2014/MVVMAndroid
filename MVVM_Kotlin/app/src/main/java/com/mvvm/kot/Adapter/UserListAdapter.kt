package com.mvvm.kot.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.mvvm.kot.R
import com.mvvm.kot.ViewModels.User
import kotlinx.android.synthetic.main.adapter_user_item.view.*
import kotlinx.android.synthetic.main.fragment_user_info.view.*
import kotlinx.android.synthetic.main.fragment_user_list.view.*

 public class UserListAdapter(): RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

     var items:List<User>?=null
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.adapter_user_item, parent, false))
    }


    override fun onBindViewHolder(holder:ViewHolder?, position: Int) {
        holder?.userName_holder?.text = items!!.get(position).userName
        holder?.userOccupation_holder?.text = items!!.get(position).userOccupation
    }

    override fun getItemCount(): Int {
        if(items!=null) {
            return items!!.size
        }else{
            return 0
        }
    }

     public fun setListItems(items:List<User>?){
         this.items = items
         notifyDataSetChanged()
     }
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
      val userName_holder = view.findViewById(R.id.user_name_item) as TextView
      val userOccupation_holder = view.findViewById(R.id.user_occ) as TextView
    }
}