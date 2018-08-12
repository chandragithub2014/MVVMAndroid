package com.mvvm.kot.Kotlin_tabs.views

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mvvm.kot.Kotlin_Simple_List_DataBinding.ViewModels.SimpleListDTO
import com.mvvm.kot.R
import com.mvvm.kot.databinding.SimpleListAdapterBinding


class SimpleListAdapter :RecyclerView.Adapter<SimpleListAdapter.SimpleListHolder>(){
    var  simpleList: List<SimpleListDTO>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListHolder {
        val simpleItemBinding: SimpleListAdapterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.simple_row_list,parent,false)
        //  val userPostHolder:UserPostHolder = UserPostHolder(postItemBinding)
        return SimpleListHolder(simpleItemBinding)
    }

    override fun onBindViewHolder(holder: SimpleListHolder, position: Int) {
        holder!!.simpleItemBinding.model  = simpleList!!.get(position)
    }

   /* override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SimpleListHolder {
        val simpleItemBinding: SimpleListAdapterBinding = DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.simple_row_list,parent,false)
        //  val userPostHolder:UserPostHolder = UserPostHolder(postItemBinding)
        return SimpleListHolder(simpleItemBinding)
    }

    override fun onBindViewHolder(holder: SimpleListHolder?, position: Int) {
           holder!!.simpleItemBinding.model  = simpleList!!.get(position)
    }*/

    public fun setListItems(postList: List<SimpleListDTO>?){
        this.simpleList = postList;
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        if(simpleList!=null) {
            return simpleList!!.size
        }else
            return  0;
    }

    inner class SimpleListHolder(var simpleItemBinding: SimpleListAdapterBinding) : RecyclerView.ViewHolder(simpleItemBinding.getRoot())
}